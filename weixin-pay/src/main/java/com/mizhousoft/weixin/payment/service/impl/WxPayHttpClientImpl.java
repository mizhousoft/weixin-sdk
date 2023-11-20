package com.mizhousoft.weixin.payment.service.impl;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.cipher.impl.CipherServiceImpl;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.WXSystemErrorException;
import com.mizhousoft.weixin.common.WxFrequencyLimitedException;
import com.mizhousoft.weixin.payment.WxPayConfig;
import com.mizhousoft.weixin.payment.WxPayError;
import com.mizhousoft.weixin.payment.constant.HttpConstants;
import com.mizhousoft.weixin.payment.service.WxPayHttpClient;

import kong.unirest.core.Headers;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.HttpStatus;
import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * WxPayHttpClient
 *
 */
public class WxPayHttpClientImpl implements WxPayHttpClient
{
	private static final Logger LOG = LoggerFactory.getLogger(WxPayHttpClientImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HttpResponse<String> get(String canonicalUrl, boolean withSerial, WxPayConfig payConfig) throws WXException
	{
		return executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, withSerial, payConfig);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HttpResponse<String> post(String body, String canonicalUrl, boolean withSerial, WxPayConfig payConfig) throws WXException
	{
		return executeRequest(body, canonicalUrl, HttpConstants.HTTP_METHOD_POST, withSerial, payConfig);
	}

	private HttpResponse<String> executeRequest(String body, String canonicalUrl, String httpMethod, boolean withSerial,
	        WxPayConfig payConfig) throws WXException
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

		HttpResponse<String> httpResp = null;

		try
		{
			if (HttpConstants.HTTP_METHOD_POST.equals(httpMethod))
			{
				httpResp = Unirest.post(requestPath).headers(headerMap).body(body).contentType("application/json; charset=UTF-8")
				        .asString();
			}
			else
			{
				httpResp = Unirest.get(requestPath).headers(headerMap).asString();
			}
		}
		catch (UnirestException e)
		{
			throw new WXException("Request failed.", e);
		}

		if (HttpStatus.OK != httpResp.getStatus() && HttpStatus.NO_CONTENT != httpResp.getStatus())
		{
			handleException(httpResp);
		}

		if (!validate(httpResp.getHeaders(), httpResp.getBody(), payConfig))
		{
			String requestId = httpResp.getHeaders().getFirst(HttpConstants.REQUEST_ID);

			throw new WXException(String.format(
			        "Validate response failed,the WechatPay signature is incorrect.%n" + "Request-ID[%s], responseBody[%.1024s]", requestId,
			        httpResp.getBody()));
		}

		return httpResp;
	}

	private void handleException(HttpResponse<String> httpResp) throws WXException
	{
		if (HttpStatus.TOO_MANY_REQUESTS == httpResp.getStatus())
		{
			throw new WxFrequencyLimitedException(
			        "Request failed, body is " + httpResp.getBody() + ", status code is " + httpResp.getStatus());
		}
		else if (HttpStatus.INTERNAL_SERVER_ERROR == httpResp.getStatus())
		{
			throw new WXSystemErrorException("Request failed, body is " + httpResp.getBody() + ", status code is " + httpResp.getStatus());
		}

		try
		{
			WxPayError error = JSONUtils.parse(httpResp.getBody(), WxPayError.class);

			if (null != error)
			{
				throw new WXException(error.getCode(), error.getMessage());
			}
		}
		catch (JSONException e)
		{
			// ignore
		}

		throw new WXException(String.valueOf(httpResp.getStatus()),
		        "Request failed, body is " + httpResp.getBody() + ", status code is " + httpResp.getStatus());
	}

	private boolean validate(Headers headers, String body, WxPayConfig payConfig) throws WXException
	{
		String timestamp = headers.getFirst(HttpConstants.WECHAT_PAY_TIMESTAMP);
		String requestId = headers.getFirst(HttpConstants.REQUEST_ID);
		String nonce = headers.getFirst(HttpConstants.WECHAT_PAY_NONCE);
		String signature = headers.getFirst(HttpConstants.WECHAT_PAY_SIGNATURE);

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

		String serialNumber = headers.getFirst(HttpConstants.WECHAT_PAY_SERIAL);
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
}
