package com.mizhousoft.weixin.mp.domain.template;

import com.mizhousoft.weixin.common.WxError;

/**
 * 消息结果
 *
 */
public class MpTemplateMessageResult extends WxError
{
	// 消息ID
	private String messageId;

	/**
	 * 获取messageId
	 * 
	 * @return
	 */
	public String getMessageId()
	{
		return messageId;
	}

	/**
	 * 设置messageId
	 * 
	 * @param messageId
	 */
	public void setMessageId(String messageId)
	{
		this.messageId = messageId;
	}
}
