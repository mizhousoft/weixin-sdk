package com.mizhousoft.weixin.mp.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.request.MpRequestMessage;
import com.mizhousoft.weixin.mp.response.MpResponseMessage;

/**
 * 消息路由
 *
 * @version
 */
public interface WxMpMessageRouter
{
	/**
	 * 路由
	 * 
	 * @param wxMessage
	 * @return
	 * @throws WXException
	 */
	MpResponseMessage route(MpRequestMessage wxMessage) throws WXException;
}