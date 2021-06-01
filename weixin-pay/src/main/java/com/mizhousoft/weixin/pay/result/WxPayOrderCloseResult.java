package com.mizhousoft.weixin.pay.result;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 订单关闭结果
 *
 * @version
 */
@XmlRootElement(name = "xml")
public class WxPayOrderCloseResult extends WxBasePayResult
{
	@XmlElement(name = "result_msg")
	private String resultMsg;

	/**
	 * 获取resultMsg
	 * 
	 * @return
	 */
	@XmlTransient
	public String getResultMsg()
	{
		return resultMsg;
	}

	/**
	 * 设置resultMsg
	 * 
	 * @param resultMsg
	 */
	public void setResultMsg(String resultMsg)
	{
		this.resultMsg = resultMsg;
	}
}
