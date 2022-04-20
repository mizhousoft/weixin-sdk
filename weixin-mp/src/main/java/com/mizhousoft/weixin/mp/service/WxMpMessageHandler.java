package com.mizhousoft.weixin.mp.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.message.MpRequestMessage;
import com.mizhousoft.weixin.mp.domain.message.MpResponseMessage;

/**
 * 消息处理器
 *
 * @version
 */
public interface WxMpMessageHandler
{
	/**
	 * 是否匹配
	 * 
	 * @param wxMessage
	 * @return
	 */
	boolean match(MpRequestMessage wxMessage);

	/**
	 * 是否支持异步
	 * 
	 * @param wxMessage
	 * @return
	 */
	boolean supportAsync(MpRequestMessage wxMessage);

	/**
	 * 处理
	 * 
	 * @param wxMessage
	 * @return
	 * @throws WXException
	 */
	MpResponseMessage handle(MpRequestMessage wxMessage) throws WXException;
}
