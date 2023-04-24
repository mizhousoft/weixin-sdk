package com.mizhousoft.weixin.pay.util;

import com.mizhousoft.commons.lang.JAXBUtils;
import com.mizhousoft.weixin.pay.notify.WxPayNotifyResponse;

/**
 * WxPayNotifyResponse构建器
 *
 * 
 */
public class WxPayNotifyResponseBuilder
{
	private transient static final String FAIL = "FAIL";

	private transient static final String SUCCESS = "SUCCESS";

	public static String fail(String msg)
	{
		WxPayNotifyResponse response = new WxPayNotifyResponse();
		response.setReturnCode(FAIL);
		response.setReturnMsg(msg);

		return JAXBUtils.beanToXml(response, WxPayNotifyResponse.class);
	}

	public static String success()
	{
		WxPayNotifyResponse response = new WxPayNotifyResponse();
		response.setReturnCode(SUCCESS);
		response.setReturnMsg("OK");

		return JAXBUtils.beanToXml(response, WxPayNotifyResponse.class);
	}
}
