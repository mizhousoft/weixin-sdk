package com.mizhousoft.weixin.payment.response;

/**
 * 通知响应
 *
 * @version
 */
public class WxPayNotifyResponse
{
	/**
	 * 返回状态码
	 */
	private String code;

	/**
	 * 返回信息
	 */
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
