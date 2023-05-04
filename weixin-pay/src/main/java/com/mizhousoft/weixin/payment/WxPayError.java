package com.mizhousoft.weixin.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 通知响应
 *
 */
public class WxPayError
{
	/**
	 * 返回状态码
	 */
	@JsonProperty(value = "code")
	private String code;

	/**
	 * 返回信息
	 */
	@JsonProperty(value = "message")
	private String message;

	/**
	 * 获取code
	 * 
	 * @return
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * 设置code
	 * 
	 * @param code
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * 获取message
	 * 
	 * @return
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * 设置message
	 * 
	 * @param message
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
}
