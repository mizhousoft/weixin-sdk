package com.mizhousoft.weixin.pay.result;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 统一订单结果
 *
 * @version
 */
@XmlRootElement(name = "xml")
public class WxPayUnifiedOrderResult extends WxBasePayResult
{
	// 预支付交易会话标识
	@XmlElement(name = "prepay_id")
	private String prepayId;

	// 交易类型
	@XmlElement(name = "trade_type")
	private String tradeType;

	// 支付跳转链接
	@XmlElement(name = "mweb_url")
	private String mwebUrl;

	/**
	 * 获取prepayId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getPrepayId()
	{
		return prepayId;
	}

	/**
	 * 设置prepayId
	 * 
	 * @param prepayId
	 */
	public void setPrepayId(String prepayId)
	{
		this.prepayId = prepayId;
	}

	/**
	 * 获取tradeType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTradeType()
	{
		return tradeType;
	}

	/**
	 * 设置tradeType
	 * 
	 * @param tradeType
	 */
	public void setTradeType(String tradeType)
	{
		this.tradeType = tradeType;
	}

	/**
	 * 获取mwebUrl
	 * 
	 * @return
	 */
	@XmlTransient
	public String getMwebUrl()
	{
		return mwebUrl;
	}

	/**
	 * 设置mwebUrl
	 * 
	 * @param mwebUrl
	 */
	public void setMwebUrl(String mwebUrl)
	{
		this.mwebUrl = mwebUrl;
	}
}
