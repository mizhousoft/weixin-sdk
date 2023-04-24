package com.mizhousoft.weixin.pay.notify;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mizhousoft.weixin.pay.result.WxBasePayResult;

/**
 * 微信退款通知结果
 *
 * 
 */
@XmlRootElement(name = "xml")
public class WxPayRefundNotifyResult extends WxBasePayResult
{
	// 加密信息
	// 加密信息请用商户秘钥进行解密
	@XmlElement(name = "req_info")
	private String reqInfoString;

	// 请求信息
	private WxPayRefundReqInfo reqInfo;

	/**
	 * 获取reqInfoString
	 * 
	 * @return
	 */
	@XmlTransient
	public String getReqInfoString()
	{
		return reqInfoString;
	}

	/**
	 * 设置reqInfoString
	 * 
	 * @param reqInfoString
	 */
	public void setReqInfoString(String reqInfoString)
	{
		this.reqInfoString = reqInfoString;
	}

	/**
	 * 获取reqInfo
	 * 
	 * @return
	 */
	public WxPayRefundReqInfo getReqInfo()
	{
		return reqInfo;
	}

	/**
	 * 设置reqInfo
	 * 
	 * @param reqInfo
	 */
	public void setReqInfo(WxPayRefundReqInfo reqInfo)
	{
		this.reqInfo = reqInfo;
	}
}
