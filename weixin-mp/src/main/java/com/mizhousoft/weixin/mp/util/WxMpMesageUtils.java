package com.mizhousoft.weixin.mp.util;

import com.mizhousoft.weixin.mp.request.MpRequestMessage;

/**
 * 消息工具类
 *
 * @version
 */
public abstract class WxMpMesageUtils
{
	public static final String EVENT_MSG_TYPE = "event";

	public static final String SUBSCRIBE_EVENT = "subscribe";

	public static final String UNSUBSCRIBE_EVENT = "unsubscribe";

	public static boolean isSubscribeMessage(MpRequestMessage message)
	{
		if (EVENT_MSG_TYPE.equals(message.getMsgType()) && SUBSCRIBE_EVENT.equals(message.getEvent()))
		{
			return true;
		}

		return false;
	}

	public static boolean isUnsubscribeMessage(MpRequestMessage message)
	{
		if (EVENT_MSG_TYPE.equals(message.getMsgType()) && UNSUBSCRIBE_EVENT.equals(message.getEvent()))
		{
			return true;
		}

		return false;
	}
}
