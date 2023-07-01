package com.mizhousoft.weixin.payment.service.impl;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.RestException;
import com.mizhousoft.commons.restclient.RestResponse;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.cipher.impl.CipherServiceImpl;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.WXSystemErrorException;
import com.mizhousoft.weixin.common.WxFrequencyLimitedException;
import com.mizhousoft.weixin.payment.WxPayConfig;
import com.mizhousoft.weixin.payment.WxPayError;
import com.mizhousoft.weixin.payment.constant.HttpConstants;
import com.mizhousoft.weixin.payment.service.WxPayHttpClient;

/**
 * WxPayHttpClient
 *
 */
public class WxPayHttpClientImpl implements WxPayHttpClient
{
	private static final Logger LOG = LoggerFactory.getLogger(WxPayHttpClientImpl.class);

	private RestClientService restClientService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RestResponse get(String canonicalUrl, boolean withSerial, WxPayConfig payConfig) throws WXException
	{
		return executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, withSerial, payConfig);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RestResponse post(String body, String canonicalUrl, boolean withSerial, WxPayConfig payConfig) throws WXException
	{
		return executeRequest(body, canonicalUrl, HttpConstants.HTTP_METHOD_POST, withSerial, payConfig);
	}

	private RestResponse executeRequest(String body, String canonicalUrl, String httpMethod, boolean withSerial, WxPayConfig payConfig)
	        throws WXException
	{
		Map<String, String> headerMap = new HashMap<>(3);
		headerMap.put(HttpConstants.ACCEPT, HttpConstants.HTTP_MEDIA_JSON);
		headerMap.put(HttpConstants.CONTENT_TYPE, HttpConstants.HTTP_MEDIA_JSON);

		if (withSerial)
		{
			String serialNumber = payConfig.getPlatformCertSerialNumber();
			headerMap.put(HttpConstants.WECHAT_PAY_SERIAL, serialNumber);
		}

		String authorization = getAuthorization(canonicalUrl, httpMethod, body, payConfig);
		headerMap.put(HttpConstants.AUTHORIZATION, authorization);

		String requestPath = payConfig.getEndpoint() + canonicalUrl;

		RestResponse restResp = null;

		try
		{
			if (HttpConstants.HTTP_METHOD_POST.equals(httpMethod))
			{
				restResp = restClientService.postJSON(requestPath, body, headerMap);
			}
			else
			{
				restResp = restClientService.get(requestPath, headerMap);
			}
		}
		catch (RestException e)
		{
			throw new WXException("Request failed.", e);
		}

		if (HttpStatus.OK.value() != restResp.getStatusCode() && HttpStatus.NO_CONTENT.value() != restResp.getStatusCode())
		{
			handleException(restResp);
		}

		if (!validate(restResp.getHeaders(), restResp.getBody(), payConfig))
		{
			String requestId = restResp.getHeaders().get(HttpConstants.REQUEST_ID);

			throw new WXException(String.format(
			        "Validate response failed,the WechatPay signature is incorrect.%n" + "Request-ID[%s], responseBody[%.1024s]", requestId,
			        restResp.getBody()));
		}

		return restResp;
	}

	private void handleException(RestResponse restResp) throws WXException
	{
		if (HttpStatus.TOO_MANY_REQUESTS.value() == restResp.getStatusCode())
		{
			throw new WxFrequencyLimitedException(
			        "Request failed, body is " + restResp.getBody() + ", status code is " + restResp.getStatusCode());
		}
		else if (HttpStatus.INTERNAL_SERVER_ERROR.value() == restResp.getStatusCode())
		{
			throw new WXSystemErrorException(
			        "Request failed, body is " + restResp.getBody() + ", status code is " + restResp.getStatusCode());
		}

		try
		{
			WxPayError error = JSONUtils.parse(restResp.getBody(), WxPayError.class);

			if (null != error)
			{
				throw new WXException(error.getCode(), error.getMessage());
			}
		}
		catch (JSONException e)
		{
			// ignore
		}

		throw new WXException(String.valueOf(restResp.getStatusCode()),
		        "Request failed, body is " + restResp.getBody() + ", status code is " + restResp.getStatusCode());
	}

	private boolean validate(Map<String, String> headers, String body, WxPayConfig payConfig) throws WXException
	{
		String timestamp = headers.get(HttpConstants.WECHAT_PAY_TIMESTAMP);
		String requestId = headers.get(HttpConstants.REQUEST_ID);
		String nonce = headers.get(HttpConstants.WECHAT_PAY_NONCE);
		String signature = headers.get(HttpConstants.WECHAT_PAY_SIGNATURE);

		body = body == null ? "" : body;

		try
		{
			Instant responseTime = Instant.ofEpochSecond(Long.parseLong(timestamp));

			// 拒绝过期请求
			if (Duration.between(responseTime, Instant.now()).abs().toMinutes() >= HttpConstants.RESPONSE_EXPIRED_MINUTES)
			{
				throw new WXException(String.format("Validate http response,timestamp[%s] of httpResponse is expires, " + "request-id[%s]",
				        timestamp, requestId));
			}
		}
		catch (DateTimeException | NumberFormatException e)
		{
			throw new WXException(
			        String.format("Validate http response,timestamp[%s] of httpResponse is invalid, request-id[%s]", timestamp, requestId));
		}

		String message = timestamp + "\n" + nonce + "\n" + body + "\n";
		LOG.debug("Message for verifying signatures is [{}]", message);
		LOG.debug("Signature for verifying signatures is [{}]", signature);

		String serialNumber = headers.get(HttpConstants.WECHAT_PAY_SERIAL);
		LOG.debug("SerialNumber for verifying signatures is [{}]", serialNumber);

		return payConfig.getCipherService().verify(serialNumber, message, signature);
	}

	private String getAuthorization(String canonicalUrl, String httpMethod, String body, WxPayConfig payConfig) throws WXException
	{
		String nonceStr = RandomGenerator.genHexString(16, false);
		long timestamp = Instant.now().getEpochSecond();
		body = body == null ? "" : body;

		String message = httpMethod + "\n" + canonicalUrl + "\n" + timestamp + "\n" + nonceStr + "\n" + body + "\n";

		String certSerialNumber = payConfig.getMchCertSerialNumber();
		String signature = payConfig.getCipherService().sign(message);

		String token = "mchid=\"" + payConfig.getMchId() + "\"," + "nonce_str=\"" + nonceStr + "\"," + "timestamp=\"" + timestamp + "\","
		        + "serial_no=\"" + certSerialNumber + "\"," + "signature=\"" + signature + "\"";

		String schema = "WECHATPAY2-" + CipherServiceImpl.ALGORITHM;

		return schema + " " + token;
	}

	/**
	 * 设置restClientService
	 * 
	 * @param restClientService
	 */
	public void setRestClientService(RestClientService restClientService)
	{
		this.restClientService = restClientService;
	}
}
