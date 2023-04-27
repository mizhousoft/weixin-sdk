package com.mizhousoft.weixin.payment.service;

import com.mizhousoft.commons.restclient.RestResponse;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.WxPayConfig;

/**
 * WxPayHttpClient
 *
 */
public interface WxPayHttpClient
{
	/**
	 * GET请求
	 * 
	 * @param canonicalUrl
	 * @param withSerial
	 * @param payConfig
	 * @return
	 * @throws WXException
	 */
	RestResponse get(String canonicalUrl, boolean withSerial, WxPayConfig payConfig) throws WXException;

	/**
	 * POST请求
	 * 
	 * @param body
	 * @param canonicalUrl
	 * @param withSerial
	 * @param payConfig
	 * @return
	 * @throws WXException
	 */
	RestResponse post(String body, String canonicalUrl, boolean withSerial, WxPayConfig payConfig) throws WXException;
}
