package com.mizhousoft.weixin.pay.notify;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 通知响应
 *
 * 
 */
@XmlRootElement(name = "xml")
public class WxPayNotifyResponse
{
	@XmlElement(name = "return_code")
	private String returnCode;

	@XmlElement(name = "return_msg")
	private String returnMsg;

	/**
	 * 获取returnCode
	 * 
	 * @return
	 */
	@XmlTransient
	public String getReturnCode()
	{
		return returnCode;
	}

	/**
	 * 设置returnCode
	 * 
	 * @param returnCode
	 */
	public void setReturnCode(String returnCode)
	{
		this.returnCode = returnCode;
	}

	/**
	 * 获取returnMsg
	 * 
	 * @return
	 */
	@XmlTransient
	public String getReturnMsg()
	{
		return returnMsg;
	}

	/**
	 * 设置returnMsg
	 * 
	 * @param returnMsg
	 */
	public void setReturnMsg(String returnMsg)
	{
		this.returnMsg = returnMsg;
	}
}
