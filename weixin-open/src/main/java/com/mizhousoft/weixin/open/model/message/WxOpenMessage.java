package com.mizhousoft.weixin.open.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息
 *
 * @version
 */
public class WxOpenMessage
{
	/**
	 * 默认为：Event
	 */
	@JsonProperty("MsgType")
	private String msgType;

	/**
	 * user_info_modified：用户资料变更，
	 * user_authorization_revoke：用户撤回，
	 * user_authorization_cancellation：用户完成注销；
	 */
	@JsonProperty("Event")
	private String event;

	/**
	 * 获取msgType
	 * @return
	 */
	public String getMsgType()
	{
		return msgType;
	}

	/**
	 * 设置msgType
	 * @param msgType
	 */
	public void setMsgType(String msgType)
	{
		this.msgType = msgType;
	}

	/**
	 * 获取event
	 * @return
	 */
	public String getEvent()
	{
		return event;
	}

	/**
	 * 设置event
	 * @param event
	 */
	public void setEvent(String event)
	{
		this.event = event;
	}
}
