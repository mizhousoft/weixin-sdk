package com.mizhousoft.weixin.entpay.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mizhousoft.weixin.pay.internal.WxBasePayRequest;

/**
 * 企业支付请求
 *
 * 
 */
@XmlRootElement(name = "xml")
public class EntPayRequest extends WxBasePayRequest
{
	// 商户账号appid
	// 申请商户号的appid或商户号绑定的appid
	@XmlElement(name = "mch_appid")
	private String mchAppId;

	// 商户号
	// 微信支付分配的商户号
	@XmlElement(name = "mchid")
	private String mchId;

	// 设备号
	@XmlElement(name = "device_info")
	private String deviceInfo;

	// 商户订单号
	@XmlElement(name = "partner_trade_no")
	private String partnerTradeNo;

	// 用户openid
	@XmlElement(name = "openid")
	private String openid;

	// 校验用户姓名选项
	@XmlElement(name = "check_name")
	private String checkName;

	// 收款用户姓名
	@XmlElement(name = "re_user_name")
	private String reUserName;

	// 金额
	@XmlElement(name = "amount")
	private Integer amount;

	// 企业付款备注
	@XmlElement(name = "desc")
	private String description;

	// Ip地址
	@XmlElement(name = "spbill_create_ip")
	private String spbillCreateIp;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getIgnoredParamsForSign()
	{
		return new String[] { "sign_type" };
	}

	/**
	 * 获取mchAppId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getMchAppId()
	{
		return mchAppId;
	}

	/**
	 * 设置mchAppId
	 * 
	 * @param mchAppId
	 */
	public void setMchAppId(String mchAppId)
	{
		this.mchAppId = mchAppId;
	}

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
	 * 获取openid
	 * 
	 * @return
	 */
	@XmlTransient
	public String getOpenid()
	{
		return openid;
	}

	/**
	 * 设置openid
	 * 
	 * @param openid
	 */
	public void setOpenid(String openid)
	{
		this.openid = openid;
	}

	/**
	 * 获取checkName
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCheckName()
	{
		return checkName;
	}

	/**
	 * 设置checkName
	 * 
	 * @param checkName
	 */
	public void setCheckName(String checkName)
	{
		this.checkName = checkName;
	}

	/**
	 * 获取reUserName
	 * 
	 * @return
	 */
	@XmlTransient
	public String getReUserName()
	{
		return reUserName;
	}

	/**
	 * 设置reUserName
	 * 
	 * @param reUserName
	 */
	public void setReUserName(String reUserName)
	{
		this.reUserName = reUserName;
	}

	/**
	 * 获取amount
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getAmount()
	{
		return amount;
	}

	/**
	 * 设置amount
	 * 
	 * @param amount
	 */
	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	/**
	 * 获取description
	 * 
	 * @return
	 */
	@XmlTransient
	public String getDescription()
	{
		return description;
	}

	/**
	 * 设置description
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * 获取spbillCreateIp
	 * 
	 * @return
	 */
	@XmlTransient
	public String getSpbillCreateIp()
	{
		return spbillCreateIp;
	}

	/**
	 * 设置spbillCreateIp
	 * 
	 * @param spbillCreateIp
	 */
	public void setSpbillCreateIp(String spbillCreateIp)
	{
		this.spbillCreateIp = spbillCreateIp;
	}
}
