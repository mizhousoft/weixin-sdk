package com.mizhousoft.weixin.payment.util;

import com.mizhousoft.weixin.payment.response.WxPayNotifyResponse;

/**
 * 工具类
 *
 * @version
 */
public abstract class WxPayUtils
{
	public static WxPayNotifyResponse buildFailResponse()
	{
		WxPayNotifyResponse response = new WxPayNotifyResponse();
		response.setCode("FAIL");
		response.setMessage("Internal error");

		return response;
	}

	public static WxPayNotifyResponse buildOkResponse()
	{
		WxPayNotifyResponse response = new WxPayNotifyResponse();
		response.setCode("SUCCESS");

		return response;
	}
}
