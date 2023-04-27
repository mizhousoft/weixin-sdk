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
	RestResponse executeRequest(String body, String canonicalUrl, String httpMethod, boolean withSerial, WxPayConfig payConfig)
	        throws WXException;
}
