package com.mizhousoft.weixin.pay.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.lang.JAXBUtils;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.WXSignException;
import com.mizhousoft.weixin.common.WXSystemErrorException;
import com.mizhousoft.weixin.common.WxFrequencyLimitedException;
import com.mizhousoft.weixin.pay.config.WxPayConfig;
import com.mizhousoft.weixin.pay.constant.WxPayResultCode;
import com.mizhousoft.weixin.pay.constant.WxPayTradeType;
import com.mizhousoft.weixin.pay.converter.WxPayOrderCloseRequestConverter;
import com.mizhousoft.weixin.pay.converter.WxPayOrderQueryRequestConverter;
import com.mizhousoft.weixin.pay.converter.WxPayRefundQueryRequestConverter;
import com.mizhousoft.weixin.pay.converter.WxPayRefundRequestConverter;
import com.mizhousoft.weixin.pay.converter.WxPayUnifiedOrderRequestConverter;
import com.mizhousoft.weixin.pay.internal.WxPayOrderCloseRequest;
import com.mizhousoft.weixin.pay.internal.WxPayOrderQueryRequest;
import com.mizhousoft.weixin.pay.internal.WxPayRefundQueryRequest;
import com.mizhousoft.weixin.pay.internal.WxPayRefundRequest;
import com.mizhousoft.weixin.pay.internal.WxPayUnifiedOrderRequest;
import com.mizhousoft.weixin.pay.notify.WxPayOrderNotifyResult;
import com.mizhousoft.weixin.pay.notify.WxPayRefundNotifyResult;
import com.mizhousoft.weixin.pay.notify.WxPayRefundReqInfo;
import com.mizhousoft.weixin.pay.request.IPayOrderQueryRequest;
import com.mizhousoft.weixin.pay.request.IPayUnifiedOrderRequest;
import com.mizhousoft.weixin.pay.request.IWxPayRefundQueryRequest;
import com.mizhousoft.weixin.pay.request.IWxPayRefundRequest;
import com.mizhousoft.weixin.pay.result.WxPayOrderCloseResult;
import com.mizhousoft.weixin.pay.result.WxPayOrderCreateResult;
import com.mizhousoft.weixin.pay.result.WxPayOrderQueryResult;
import com.mizhousoft.weixin.pay.result.WxPayRefundQueryResult;
import com.mizhousoft.weixin.pay.result.WxPayRefundResult;
import com.mizhousoft.weixin.pay.result.WxPayUnifiedOrderResult;
import com.mizhousoft.weixin.pay.service.WxPayService;
import com.mizhousoft.weixin.pay.util.WxPaySignUtils;

/**
 * 微信支付服务
 *
 * @version
 */
public class WxPayServiceImpl implements WxPayService
{
	private static final Logger LOG = LoggerFactory.getLogger(WxPayServiceImpl.class);

	private RestClientService restClientService;

	private WxPayConfig wxPayConfig;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMchId()
	{
		return wxPayConfig.getMchId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderCreateResult createOrder(IPayUnifiedOrderRequest request) throws WXException
	{
		WxPayUnifiedOrderResult unifiedOrderResult = this.unifiedOrder(request);
		String prepayId = unifiedOrderResult.getPrepayId();
		if (StringUtils.isBlank(prepayId))
		{
			throw new WXException(unifiedOrderResult.getErrCode(), unifiedOrderResult.getErrCodeDes());
		}

		String appId = unifiedOrderResult.getAppid();
		String partnerId = unifiedOrderResult.getMchId();

		if (WxPayTradeType.MWEB.equals(request.getTradeType()))
		{
			WxPayOrderCreateResult result = new WxPayOrderCreateResult();
			result.setAppId(appId);
			result.setPartnerId(partnerId);
			result.setPrepayId(prepayId);
			result.setSignType(wxPayConfig.getSignType());
			result.setMwebUrl(unifiedOrderResult.getMwebUrl());

			return result;
		}
		else
		{
			String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
			String nonceStr = RandomGenerator.genHexString(16, false);

			Map<String, String> configMap = new HashMap<>(8);

			String packageValue = null;
			if (WxPayTradeType.JSAPI.equals(request.getTradeType()))
			{
				packageValue = "prepay_id=" + prepayId;

				configMap.put("signType", wxPayConfig.getSignType());
				configMap.put("appId", appId);
				configMap.put("timeStamp", timestamp);
				configMap.put("nonceStr", nonceStr);
			}
			else if (WxPayTradeType.APP.equals(request.getTradeType()))
			{
				packageValue = "Sign=WXPay";

				configMap.put("prepayid", prepayId);
				configMap.put("partnerid", partnerId);
				configMap.put("appid", appId);
				configMap.put("timestamp", timestamp);
				configMap.put("noncestr", nonceStr);
			}
			configMap.put("package", packageValue);

			String sign = WxPaySignUtils.createSign(configMap, wxPayConfig.getSignType(), wxPayConfig.getMchKey(), null);

			WxPayOrderCreateResult result = new WxPayOrderCreateResult();
			result.setAppId(appId);
			result.setNonceStr(nonceStr);
			result.setPackageValue(packageValue);
			result.setPartnerId(partnerId);
			result.setPrepayId(prepayId);
			result.setSign(sign);
			result.setTimeStamp(timestamp);
			result.setSignType(wxPayConfig.getSignType());

			return result;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayUnifiedOrderResult unifiedOrder(IPayUnifiedOrderRequest request) throws WXException
	{
		WxPayUnifiedOrderRequest wxreq = WxPayUnifiedOrderRequestConverter.convert(request, wxPayConfig);
		String body = JAXBUtils.beanToXml(wxreq, WxPayUnifiedOrderRequest.class);

		String url = PAY_ENDPOINT + "/pay/unifiedorder";

		LOG.debug("Unified order request data is {}.", body);

		String response = restClientService.postForObject(url, body, String.class);

		LOG.debug("Unified order response data is {}.", response);

		WxPayUnifiedOrderResult result = JAXBUtils.xmlToBean(response, WxPayUnifiedOrderResult.class);
		if (WxPayResultCode.SUCCESS.equals(result.getResultCode()) || WxPayResultCode.SUCCESS.equals(result.getResultCode()))
		{
			WxPaySignUtils.checkSign(result, wxPayConfig.getSignType(), wxPayConfig.getMchKey());
		}
		else
		{
			throw new WXException(result.getErrCode(), result.getErrCodeDes());
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderQueryResult queryOrder(String appId, String transactionId, String outTradeNo) throws WXException
	{
		IPayOrderQueryRequest request = new IPayOrderQueryRequest();
		request.setAppId(appId);
		request.setOutTradeNo(outTradeNo);
		request.setTransactionId(transactionId);

		WxPayOrderQueryRequest wxreq = WxPayOrderQueryRequestConverter.convert(request, wxPayConfig);

		String body = JAXBUtils.beanToXml(wxreq, WxPayOrderQueryRequest.class);

		String url = PAY_ENDPOINT + "/pay/orderquery";

		LOG.debug("Order query request data is {}.", body);

		String response = restClientService.postForObject(url, body, String.class);

		LOG.debug("Order query response data is {}.", response);

		WxPayOrderQueryResult result = JAXBUtils.xmlToBean(response, WxPayOrderQueryResult.class);

		if (WxPayResultCode.SUCCESS.equals(result.getReturnCode()) && WxPayResultCode.FAIL.equals(result.getResultCode()))
		{
			if (WxPayResultCode.SYSTEM_ERROR.equals(result.getErrCode()))
			{
				throw new WXSystemErrorException(result.getErrCode(), result.getErrCodeDes());
			}
			else if (WxPayResultCode.FREQUENCY_LIMITED.equals(result.getErrCode()))
			{
				throw new WxFrequencyLimitedException(result.getErrCode(), result.getErrCodeDes());
			}
		}

		WxPaySignUtils.checkSign(result, wxPayConfig.getSignType(), wxPayConfig.getMchKey());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderCloseResult closeOrder(String appId, String outTradeNo) throws WXException
	{
		WxPayOrderCloseRequest wxreq = WxPayOrderCloseRequestConverter.convert(appId, outTradeNo, wxPayConfig);

		String body = JAXBUtils.beanToXml(wxreq, WxPayOrderCloseRequest.class);

		String url = PAY_ENDPOINT + "/pay/closeorder";

		LOG.debug("Order close request data is {}.", body);

		String response = restClientService.postForObject(url, body, String.class);

		LOG.debug("Order close response data is {}.", response);

		WxPayOrderCloseResult result = JAXBUtils.xmlToBean(response, WxPayOrderCloseResult.class);

		WxPaySignUtils.checkSign(result, wxPayConfig.getSignType(), wxPayConfig.getMchKey());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayOrderNotifyResult parsePayOrderNotifyResult(String xmlData) throws WXException
	{
		LOG.debug("Order notify result data is {}.", xmlData);

		WxPayOrderNotifyResult result = JAXBUtils.xmlToBean(xmlData, WxPayOrderNotifyResult.class);

		if (WxPayResultCode.SUCCESS.equals(result.getReturnCode()) && result.getSign() == null)
		{
			throw new WXSignException("Sign wrong.");
		}

		WxPaySignUtils.checkSign(result, wxPayConfig.getSignType(), wxPayConfig.getMchKey());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayRefundResult refund(IWxPayRefundRequest request) throws WXException
	{
		WxPayRefundRequest wxRequest = WxPayRefundRequestConverter.convert(request, wxPayConfig);

		String url = PAY_ENDPOINT + "/secapi/pay/refund";

		String body = JAXBUtils.beanToXml(wxRequest, WxPayRefundRequest.class);

		LOG.debug("Order refund request data is {}.", body);

		String response = restClientService.postForObject(url, body, String.class);

		LOG.debug("Order refund response data is {}.", response);

		WxPayRefundResult result = JAXBUtils.xmlToBean(response, WxPayRefundResult.class);

		WxPaySignUtils.checkSign(result, wxPayConfig.getSignType(), wxPayConfig.getMchKey());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayRefundQueryResult refundQuery(String appId, String transactionId, String outTradeNo, String outRefundNo, String refundId)
	        throws WXException
	{
		IWxPayRefundQueryRequest request = new IWxPayRefundQueryRequest();
		request.setAppId(appId);
		request.setTransactionId(StringUtils.trimToNull(transactionId));
		request.setOutTradeNo(StringUtils.trimToNull(outTradeNo));
		request.setOutRefundNo(StringUtils.trimToNull(outRefundNo));
		request.setRefundId(StringUtils.trimToNull(refundId));

		return refundQuery(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayRefundQueryResult refundQuery(IWxPayRefundQueryRequest request) throws WXException
	{
		WxPayRefundQueryRequest wxRequest = WxPayRefundQueryRequestConverter.convert(request, wxPayConfig);

		String url = PAY_ENDPOINT + "/pay/refundquery";

		String body = JAXBUtils.beanToXml(wxRequest, WxPayRefundQueryRequest.class);

		LOG.debug("Refund query request data is {}.", body);

		String response = restClientService.postForObject(url, body, String.class);

		LOG.debug("Refund query response data is {}.", response);

		WxPayRefundQueryResult result = JAXBUtils.xmlToBean(response, WxPayRefundQueryResult.class);

		WxPaySignUtils.checkSign(result, wxPayConfig.getSignType(), wxPayConfig.getMchKey());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayRefundNotifyResult parseRefundNotifyResult(String xmlData) throws WXException
	{
		LOG.debug("Refund notify result data is {}.", xmlData);

		WxPayRefundNotifyResult result = JAXBUtils.xmlToBean(xmlData, WxPayRefundNotifyResult.class);

		if (!WxPayResultCode.SUCCESS.equals(result.getReturnCode()))
		{
			throw new WXSignException("Refund failed.");
		}

		String reqInfoString = result.getReqInfoString();

		try
		{
			final String keyMd5String = DigestUtils.md5Hex(wxPayConfig.getMchKey()).toLowerCase(Locale.US);

			SecretKeySpec key = new SecretKeySpec(keyMd5String.getBytes(StandardCharsets.UTF_8), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			String data = new String(cipher.doFinal(Base64.decodeBase64(reqInfoString)), StandardCharsets.UTF_8);

			WxPayRefundReqInfo reqInfo = JAXBUtils.xmlToBean(data, WxPayRefundReqInfo.class);
			result.setReqInfo(reqInfo);
		}
		catch (Exception e)
		{
			throw new WXException(e.getMessage(), e);
		}

		return result;
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

	/**
	 * 设置wxPayConfig
	 * 
	 * @param wxPayConfig
	 */
	public void setWxPayConfig(WxPayConfig wxPayConfig)
	{
		this.wxPayConfig = wxPayConfig;
	}
}
