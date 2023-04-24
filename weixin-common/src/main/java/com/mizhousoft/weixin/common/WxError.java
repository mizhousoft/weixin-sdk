package com.mizhousoft.weixin.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信错误
 *
 */
public class WxError
{
	// 错误码
	@JsonProperty("errcode")
	protected String errorCode;

	// 错误信息
	@JsonProperty("errmsg")
	protected String errorMsg;

	/**
	 * 获取errorCode
	 * 
	 * @return
	 */
	public String getErrorCode()
	{
		return errorCode;
	}

	/**
	 * 设置errorCode
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	/**
	 * 获取errorMsg
	 * 
	 * @return
	 */
	public String getErrorMsg()
	{
		return errorMsg;
	}

	/**
	 * 设置errorMsg
	 * 
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}
}
