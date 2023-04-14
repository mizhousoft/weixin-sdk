package com.mizhousoft.weixin.payment.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.RestResponse;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.WXSystemErrorException;
import com.mizhousoft.weixin.common.WxFrequencyLimitedException;
import com.mizhousoft.weixin.payment.WxPayConfig;
import com.mizhousoft.weixin.payment.constant.HttpConstants;
import com.mizhousoft.weixin.payment.constant.TradeTypeEnum;
import com.mizhousoft.weixin.payment.request.WxPayOrderCreateRequest;
import com.mizhousoft.weixin.payment.response.OriginNotifyResponse;
import com.mizhousoft.weixin.payment.response.SignatureHeader;
import com.mizhousoft.weixin.payment.response.WxPayOrderCreateResponse;
import com.mizhousoft.weixin.payment.result.WxPayOrderCreateResult;
import com.mizhousoft.weixin.payment.result.WxPayOrderQueryResult;
import com.mizhousoft.weixin.payment.service.WxPayCredential;
import com.mizhousoft.weixin.payment.service.WxPayValidator;
import com.mizhousoft.weixin.payment.service.WxPaymentService;
import com.mizhousoft.weixin.payment.util.AESUtils;
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
	public WxPayOrderCreateResult createOrder(TradeTypeEnum tradeType, WxPayOrderCreateRequest request) throws WXException
	{
		if (StringUtils.isBlank(request.getMchId()))
		{
			request.setMchId(credential.getMerchantId());
		}

		if (StringUtils.isBlank(request.getNotifyUrl()))
		{
			request.setNotifyUrl(credential.getPayNotifyUrl());
		}

		try
		{
			String canonicalUrl = tradeType.getPartnerUrl();
			String body = JSONUtils.toJSONString(request);

			RestResponse restResp = executeRequest(body, canonicalUrl, HttpConstants.HTTP_METHOD_POST);

			WxPayOrderCreateResponse response = JSONUtils.parse(restResp.getBody(), WxPayOrderCreateResponse.class);

			String prepayId = response.getPrepayId();

			return buildOrderCreateResult(prepayId, request);
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderQueryResult queryOrderByTransactionId(String transactionId) throws WXException
	{
		String mchId = credential.getMerchantId();
		String canonicalUrl = String.format("/v3/pay/transactions/id/%s?mchid=%s", transactionId, mchId);

		RestResponse restResp = executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET);

		try
		{
			WxPayOrderQueryResult response = JSONUtils.parse(restResp.getBody(), WxPayOrderQueryResult.class);

			return response;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderQueryResult queryOrderByOutTradeNo(String outTradeNo) throws WXException
	{
		String mchId = credential.getMerchantId();
		String canonicalUrl = String.format("/v3/pay/transactions/out-trade-no/%s?mchid=%s", outTradeNo, mchId);

		RestResponse restResp = executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET);

		try
		{
			WxPayOrderQueryResult response = JSONUtils.parse(restResp.getBody(), WxPayOrderQueryResult.class);

			return response;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderQueryResult parsePayOrderNotifyResult(String notifyData, SignatureHeader header) throws WXException
	{
		String beforeSign = String.format("%s\n%s\n%s\n", header.getTimeStamp(), header.getNonce(), notifyData);
		if (!validator.verify(beforeSign.getBytes(StandardCharsets.UTF_8), beforeSign))
		{
			throw new WXException("Request invalid.");
		}

		try
		{
			OriginNotifyResponse response = JSONUtils.parse(notifyData, OriginNotifyResponse.class);
			OriginNotifyResponse.Resource resource = response.getResource();
			String cipherText = resource.getCiphertext();
			String associatedData = resource.getAssociatedData();
			String nonce = resource.getNonce();
			String apiV3Key = credential.getAPIV3key();

			String result = AESUtils.decryptToString(associatedData, nonce, cipherText, apiV3Key);

			WxPayOrderQueryResult queryResult = JSONUtils.parse(result, WxPayOrderQueryResult.class);

			return queryResult;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	private RestResponse executeRequest(String body, String canonicalUrl, String httpMethod) throws WXException
	{
		Map<String, String> headerMap = new HashMap<>(3);
		headerMap.put(HttpConstants.ACCEPT, HttpConstants.HTTP_MEDIA_JSON);
		headerMap.put(HttpConstants.CONTENT_TYPE, HttpConstants.HTTP_MEDIA_JSON);

		String authorization = credential.getAuthorization(canonicalUrl, httpMethod, body);
		headerMap.put(HttpConstants.AUTHORIZATION, authorization);

		String requestPath = ENDPOINT + canonicalUrl;

		RestResponse restResp = null;
		if (HttpConstants.HTTP_METHOD_POST.equals(httpMethod))
		{
			restResp = restClientService.postJSON(requestPath, body, headerMap);
		}
		else
		{
			restResp = restClientService.get(requestPath, headerMap);
		}

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

		if (HttpStatus.OK.value() != restResp.getStatusCode() && HttpStatus.NO_CONTENT.value() != restResp.getStatusCode())
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
		this.credential = new WxPayCredentialImpl(config, privateKey);
	}
}
