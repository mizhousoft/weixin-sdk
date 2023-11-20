package com.mizhousoft.weixin.payment.service.impl;

import java.time.Instant;

import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.cipher.CipherService;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.SignatureHeader;
import com.mizhousoft.weixin.payment.WxPayConfig;
import com.mizhousoft.weixin.payment.request.WxPayOrderCreateRequest;
import com.mizhousoft.weixin.payment.request.WxPayRefundRequest;
import com.mizhousoft.weixin.payment.response.OriginNotifyResponse;
import com.mizhousoft.weixin.payment.response.WxPayOrderCreateResponse;
import com.mizhousoft.weixin.payment.result.WxPayOrderCreateResult;
import com.mizhousoft.weixin.payment.result.WxPayOrderQueryResult;
import com.mizhousoft.weixin.payment.result.WxPayRefundNotifyResult;
import com.mizhousoft.weixin.payment.result.WxPayRefundResult;
import com.mizhousoft.weixin.payment.service.WxPayConfigService;
import com.mizhousoft.weixin.payment.service.WxPayHttpClient;
import com.mizhousoft.weixin.payment.service.WxPaymentService;

import kong.unirest.core.HttpResponse;

/**
 * 支付服务
 *
 */
public class WxPaymentServiceImpl implements WxPaymentService
{
	private WxPayConfigService configService;

	private WxPayHttpClient httpClient;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderCreateResult createAppOrder(WxPayOrderCreateRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(request.getMchId());

		String canonicalUrl = "/v3/pay/transactions/app";

		WxPayOrderCreateResponse response = createUnifiedOrder(payConfig, canonicalUrl, request);

		String prepayId = response.getPrepayId();

		long timestamp = Instant.now().getEpochSecond();
		String nonceStr = RandomGenerator.genHexString(16, false);

		String message = request.getAppId() + "\n" + timestamp + "\n" + nonceStr + "\n" + prepayId + "\n";
		String sign = payConfig.getCipherService().sign(message);

		WxPayOrderCreateResult result = new WxPayOrderCreateResult();
		result.setAppId(request.getAppId());
		result.setPartnerId(payConfig.getMchId());
		result.setPrepayId(prepayId);
		result.setPackageValue("Sign=WXPay");
		result.setNonceStr(nonceStr);
		result.setTimeStamp(String.valueOf(timestamp));
		result.setSign(sign);

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderCreateResult createJSAPIOrder(WxPayOrderCreateRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(request.getMchId());

		String canonicalUrl = "/v3/pay/transactions/jsapi";

		WxPayOrderCreateResponse response = createUnifiedOrder(payConfig, canonicalUrl, request);

		String prepayId = response.getPrepayId();
		String packageValue = "prepay_id=" + prepayId;

		long timestamp = Instant.now().getEpochSecond();
		String nonceStr = RandomGenerator.genHexString(16, false);

		String message = request.getAppId() + "\n" + timestamp + "\n" + nonceStr + "\n" + packageValue + "\n";
		String sign = payConfig.getCipherService().sign(message);

		WxPayOrderCreateResult result = new WxPayOrderCreateResult();
		result.setAppId(request.getAppId());
		result.setPackageValue(packageValue);
		result.setNonceStr(nonceStr);
		result.setTimeStamp(String.valueOf(timestamp));
		result.setSign(sign);
		result.setSignType("RSA");

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String createH5Order(WxPayOrderCreateRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(request.getMchId());

		String canonicalUrl = "/v3/pay/transactions/h5";

		WxPayOrderCreateResponse response = createUnifiedOrder(payConfig, canonicalUrl, request);

		return response.getH5Url();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String createNativeOrder(WxPayOrderCreateRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(request.getMchId());

		String canonicalUrl = "/v3/pay/transactions/native";

		WxPayOrderCreateResponse response = createUnifiedOrder(payConfig, canonicalUrl, request);

		return response.getCodeUrl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderQueryResult queryOrderByTransactionId(String mchId, String transactionId) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);

		String canonicalUrl = String.format("/v3/pay/transactions/id/%s?mchid=%s", transactionId, mchId);

		HttpResponse<String> httpResp = httpClient.get(canonicalUrl, false, payConfig);

		try
		{
			WxPayOrderQueryResult response = JSONUtils.parse(httpResp.getBody(), WxPayOrderQueryResult.class);

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
	public WxPayOrderQueryResult queryOrderByOutTradeNo(String mchId, String outTradeNo) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);

		String canonicalUrl = String.format("/v3/pay/transactions/out-trade-no/%s?mchid=%s", outTradeNo, mchId);

		HttpResponse<String> httpResp = httpClient.get(canonicalUrl, false, payConfig);

		try
		{
			WxPayOrderQueryResult response = JSONUtils.parse(httpResp.getBody(), WxPayOrderQueryResult.class);

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
	public WxPayOrderQueryResult parsePayOrderNotifyResult(String mchId, String notifyData, SignatureHeader header) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);
		CipherService cipherService = payConfig.getCipherService();

		String beforeSign = String.format("%s\n%s\n%s\n", header.getTimeStamp(), header.getNonce(), notifyData);
		if (!cipherService.verify(header.getSerialNumber(), beforeSign, header.getSignature()))
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

			String result = cipherService.decryptResult(associatedData, nonce, cipherText);

			WxPayOrderQueryResult queryResult = JSONUtils.parse(result, WxPayOrderQueryResult.class);

			return queryResult;
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
	public WxPayRefundResult refund(String mchId, WxPayRefundRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);

		if (StringUtils.isBlank(request.getNotifyUrl()))
		{
			request.setNotifyUrl(payConfig.getRefundNotifyUrl());
		}

		String canonicalUrl = "/v3/refund/domestic/refunds";

		try
		{
			String body = JSONUtils.toJSONString(request);

			HttpResponse<String> httpResp = httpClient.post(body, canonicalUrl, false, payConfig);

			WxPayRefundResult result = JSONUtils.parse(httpResp.getBody(), WxPayRefundResult.class);

			return result;
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
	public WxPayRefundResult refundQuery(String mchId, String outRefundNo) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);

		String canonicalUrl = String.format("/v3/refund/domestic/refunds/%s", outRefundNo);

		HttpResponse<String> httpResp = httpClient.get(canonicalUrl, false, payConfig);

		try
		{
			WxPayRefundResult response = JSONUtils.parse(httpResp.getBody(), WxPayRefundResult.class);

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
	public WxPayRefundNotifyResult parseRefundNotifyResult(String mchId, String notifyData, SignatureHeader header) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);
		CipherService cipherService = payConfig.getCipherService();

		String beforeSign = String.format("%s\n%s\n%s\n", header.getTimeStamp(), header.getNonce(), notifyData);
		if (!cipherService.verify(header.getSerialNumber(), beforeSign, header.getSignature()))
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

			String result = cipherService.decryptResult(associatedData, nonce, cipherText);

			WxPayRefundNotifyResult refundResult = JSONUtils.parse(result, WxPayRefundNotifyResult.class);

			return refundResult;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	private WxPayOrderCreateResponse createUnifiedOrder(WxPayConfig payConfig, String canonicalUrl, WxPayOrderCreateRequest request)
	        throws WXException
	{
		if (StringUtils.isBlank(request.getMchId()))
		{
			request.setMchId(payConfig.getMchId());
		}

		if (StringUtils.isBlank(request.getNotifyUrl()))
		{
			request.setNotifyUrl(payConfig.getPayNotifyUrl());
		}

		try
		{
			String body = JSONUtils.toJSONString(request);

			HttpResponse<String> httpResp = httpClient.post(body, canonicalUrl, false, payConfig);

			WxPayOrderCreateResponse response = JSONUtils.parse(httpResp.getBody(), WxPayOrderCreateResponse.class);

			return response;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	/**
	 * 设置configService
	 * 
	 * @param configService
	 */
	public void setConfigService(WxPayConfigService configService)
	{
		this.configService = configService;
	}

	/**
	 * 设置httpClient
	 * 
	 * @param httpClient
	 */
	public void setHttpClient(WxPayHttpClient httpClient)
	{
		this.httpClient = httpClient;
	}
}
