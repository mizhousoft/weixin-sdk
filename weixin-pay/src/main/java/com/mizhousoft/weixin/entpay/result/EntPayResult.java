package com.mizhousoft.weixin.entpay.result;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mizhousoft.weixin.pay.result.WxBasePayResult;

/**
 * 企业支付结果
 *
 * @version
 */
@XmlRootElement(name = "xml")
public class EntPayResult extends WxBasePayResult
{
	// 商户号
	@XmlElement(name = "mchid")
	private String mchId;

	// 商户appid
	@XmlElement(name = "mch_appid")
	private String mchAppid;

	// 设备号
	@XmlElement(name = "device_info")
	private String deviceInfo;

	// 商户订单号
	@XmlElement(name = "partner_trade_no")
	private String partnerTradeNo;

	// 微信订单号
	@XmlElement(name = "payment_no")
	private String paymentNo;

	// 微信支付成功时间
	@XmlElement(name = "payment_time")
	private String paymentTime;

	/**
	 * 获取mchId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getMchId()
	{
		return mchId;
	}

	/**
	 * 设置mchId
	 * 
	 * @param mchId
	 */
	public void setMchId(String mchId)
	{
		this.mchId = mchId;
	}

	/**
	 * 获取mchAppid
	 * 
	 * @return
	 */
	@XmlTransient
	public String getMchAppid()
	{
		return mchAppid;
	}

	/**
	 * 设置mchAppid
	 * 
	 * @param mchAppid
	 */
	public void setMchAppid(String mchAppid)
	{
		this.mchAppid = mchAppid;
	}

	/**
	 * 获取deviceInfo
	 * 
	 * @return
	 */
	@XmlTransient
	public String getDeviceInfo()
	{
		return deviceInfo;
	}

	/**
	 * 设置deviceInfo
	 * 
	 * @param deviceInfo
	 */
	public void setDeviceInfo(String deviceInfo)
	{
		this.deviceInfo = deviceInfo;
	}

	/**
	 * 获取partnerTradeNo
	 * 
	 * @return
	 */
	@XmlTransient
	public String getPartnerTradeNo()
	{
		return partnerTradeNo;
	}

	/**
	 * 设置partnerTradeNo
	 * 
	 * @param partnerTradeNo
	 */
	public void setPartnerTradeNo(String partnerTradeNo)
	{
		this.partnerTradeNo = partnerTradeNo;
	}

	/**
	 * 获取paymentNo
	 * 
	 * @return
	 */
	@XmlTransient
	public String getPaymentNo()
	{
		return paymentNo;
	}

	/**
	 * 设置paymentNo
	 * 
	 * @param paymentNo
	 */
	public void setPaymentNo(String paymentNo)
	{
		this.paymentNo = paymentNo;
	}

	/**
	 * 获取paymentTime
	 * 
	 * @return
	 */
	@XmlTransient
	public String getPaymentTime()
	{
		return paymentTime;
	}

	/**
	 * 设置paymentTime
	 * 
	 * @param paymentTime
	 */
	public void setPaymentTime(String paymentTime)
	{
		this.paymentTime = paymentTime;
	}
}
