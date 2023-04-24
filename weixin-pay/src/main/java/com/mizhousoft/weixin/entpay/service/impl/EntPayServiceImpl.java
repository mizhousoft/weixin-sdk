package com.mizhousoft.weixin.entpay.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.lang.JAXBUtils;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.entpay.converter.EntPayQueryRequestConverter;
import com.mizhousoft.weixin.entpay.converter.EntPayRequestConverter;
import com.mizhousoft.weixin.entpay.internal.EntPayQueryRequest;
import com.mizhousoft.weixin.entpay.internal.EntPayRequest;
import com.mizhousoft.weixin.entpay.request.IEntPayQueryRequest;
import com.mizhousoft.weixin.entpay.request.IEntPayRequest;
import com.mizhousoft.weixin.entpay.result.EntPayQueryResult;
import com.mizhousoft.weixin.entpay.result.EntPayResult;
import com.mizhousoft.weixin.entpay.service.EntPayService;
import com.mizhousoft.weixin.pay.config.WxPayConfig;

/**
 * 企业支付服务
 *
 * 
 */
public class EntPayServiceImpl implements EntPayService
{
	private static final Logger LOG = LoggerFactory.getLogger(EntPayServiceImpl.class);

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
	public EntPayResult entPay(IEntPayRequest request) throws WXException
	{
		EntPayRequest wxreq = EntPayRequestConverter.convert(request, wxPayConfig);

		String body = JAXBUtils.beanToXml(wxreq, EntPayRequest.class);

		String url = ENT_PAY_ENDPOINT + "/mmpaymkttransfers/promotion/transfers";

		LOG.debug("Weixin transfer request data is {}.", body);

		String response = restClientService.postForObject(url, body, String.class);

		LOG.debug("Weixin transfer response data is {}.", response);

		EntPayResult result = JAXBUtils.xmlToBean(response, EntPayResult.class);

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntPayQueryResult queryEntPay(IEntPayQueryRequest request) throws WXException
	{
		EntPayQueryRequest wxreq = EntPayQueryRequestConverter.convert(request, wxPayConfig);

		String body = JAXBUtils.beanToXml(wxreq, EntPayQueryRequest.class);

		String url = ENT_PAY_ENDPOINT + "/mmpaymkttransfers/gettransferinfo";

		LOG.debug("Weixin query transfer request data is {}.", body);

		String response = restClientService.postForObject(url, body, String.class);

		LOG.debug("Weixin query transfer response data is {}.", response);

		EntPayQueryResult result = JAXBUtils.xmlToBean(response, EntPayQueryResult.class);

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
