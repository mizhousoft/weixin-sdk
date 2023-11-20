package com.mizhousoft.weixin.payment.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.WxPayConfig;

import kong.unirest.core.HttpResponse;

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
	HttpResponse<String> get(String canonicalUrl, boolean withSerial, WxPayConfig payConfig) throws WXException;

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
	HttpResponse<String> post(String body, String canonicalUrl, boolean withSerial, WxPayConfig payConfig) throws WXException;
}
