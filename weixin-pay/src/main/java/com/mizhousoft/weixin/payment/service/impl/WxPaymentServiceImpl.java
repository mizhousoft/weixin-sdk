package com.mizhousoft.weixin.payment.service.impl;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.RestResponse;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.WxPayConfig;
import com.mizhousoft.weixin.payment.constant.HttpConstants;
import com.mizhousoft.weixin.payment.request.WxPayOrderCreateRequest;
import com.mizhousoft.weixin.payment.response.WxPayOrderCreateResponse;
import com.mizhousoft.weixin.payment.response.WxPayOrderQueryResponse;
import com.mizhousoft.weixin.payment.result.WxPayOrderCreateResult;
import com.mizhousoft.weixin.payment.service.WxPayCredential;
import com.mizhousoft.weixin.payment.service.WxPayValidator;
import com.mizhousoft.weixin.payment.service.WxPaymentService;
import com.mizhousoft.weixin.payment.util.PemUtils;

/**
 * 支付服务
 *
 * @version
 */
public class WxPaymentServiceImpl implements WxPaymentService
{
	private RestClientService restClientService;

	private WxPayCredential credential;

	private WxPayValidator validator;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMchId()
	{
		if (null != credential)
		{
			return credential.getMerchantId();
		}
		else
		{
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderCreateResult createOrder(WxPayOrderCreateRequest request) throws WXException
	{
		String canonicalUrl = "/v3/pay/transactions/app";

		try
		{
			String body = JSONUtils.toJSONString(request);

			RestResponse restResp = executeRequest(body, canonicalUrl, HttpConstants.HTTP_METHOD_POST);

			WxPayOrderCreateResponse response = JSONUtils.parse(restResp.getBody(), WxPayOrderCreateResponse.class);

			String prepayId = response.getPrepayId();

			return buildOrderCreateResult(prepayId, request);
		}
		catch (JSONException e)
		{
			throw new WXException("Create order failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderQueryResponse queryOrder(String transactionId, String outTradeNo) throws WXException
	{
		return null;
	}

	private RestResponse executeRequest(String body, String canonicalUrl, String httpMethod) throws WXException
	{
		Map<String, String> headerMap = new HashMap<>(3);
		headerMap.put(HttpConstants.ACCEPT, HttpConstants.HTTP_MEDIA_JSON);
		headerMap.put(HttpConstants.CONTENT_TYPE, HttpConstants.HTTP_MEDIA_JSON);

		String authorization = credential.getAuthorization(canonicalUrl, httpMethod, body);
		headerMap.put(HttpConstants.AUTHORIZATION, authorization);

		String requestPath = ENDPOINT + canonicalUrl;
		RestResponse restResp = restClientService.postJSON(requestPath, body, headerMap);

		if (HttpStatus.OK.value() != restResp.getStatusCode())
		{
			throw new WXException("Request failed, body is " + restResp.getBody() + ", status code is " + restResp.getStatusCode());
		}

		if (!validator.validate(restResp.getHeaders(), restResp.getBody()))
		{
			String requestId = restResp.getHeaders().get(HttpConstants.REQUEST_ID);

			throw new WXException(String.format(
			        "Validate response failed,the WechatPay signature is incorrect.%n" + "Request-ID[%s], responseBody[%.1024s]", requestId,
			        restResp.getBody()));
		}

		return restResp;
	}

	private WxPayOrderCreateResult buildOrderCreateResult(String prepayId, WxPayOrderCreateRequest request) throws WXException
	{
		long timestamp = Instant.now().getEpochSecond();
		String nonceStr = RandomGenerator.genHexString(16, false);

		String message = request.getAppId() + "\n" + timestamp + "\n" + nonceStr + "\n" + prepayId + "\n";

		String sign = credential.sign(message);

		WxPayOrderCreateResult response = new WxPayOrderCreateResult();
		response.setAppId(request.getAppId());
		response.setPartnerId(credential.getMerchantId());
		response.setPrepayId(prepayId);
		response.setPackageValue("Sign=WXPay");
		response.setNonceStr(nonceStr);
		response.setTimeStamp(String.valueOf(timestamp));
		response.setSign(sign);

		return response;
	}

	public void init(WxPayConfig config, RestClientService restClientService) throws WXException
	{
		PrivateKey privateKey = PemUtils.loadPrivateKeyFromPath(config.getPrivateKeyPath());
		X509Certificate certificate = PemUtils.loadX509FromPath(config.getCertFilePath());

		this.restClientService = restClientService;
		this.validator = new WxPayValidatorImpl(certificate);
		this.credential = new WxPayCredentialImpl(config.getMchId(), config.getCertSerialNumber(), privateKey);
	}

}
