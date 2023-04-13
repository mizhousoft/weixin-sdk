package com.mizhousoft.weixin.payment.service;

import com.mizhousoft.weixin.common.WXException;

/**
 * 凭证
 *
 * @version
 */
public interface WxPayCredential
{
	/**
	 * 获取认证类型
	 *
	 * @return 认证类型
	 */
	String getSchema();

	/**
	 * 获取商户号
	 *
	 * @return 商户号
	 */
	String getMerchantId();

	/**
	 * 签名
	 * 
	 * @param message
	 * @return
	 * @throws WXException
	 */
	String sign(String message) throws WXException;

	/**
	 * 获取认证信息
	 * 
	 * @param canonicalUrl
	 * @param httpMethod
	 * @param body
	 * @return
	 * @throws WXException
	 */
	String getAuthorization(String canonicalUrl, String httpMethod, String body) throws WXException;
}