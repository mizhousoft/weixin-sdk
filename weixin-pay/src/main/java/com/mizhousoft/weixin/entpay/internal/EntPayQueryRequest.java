package com.mizhousoft.weixin.entpay.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mizhousoft.weixin.pay.internal.WxBasePayRequest;

/**
 * 企业查询请求
 *
 * 
 */
@XmlRootElement(name = "xml")
public class EntPayQueryRequest extends WxBasePayRequest
{
	// 商户订单号
	@XmlElement(name = "partner_trade_no")
	private String partnerTradeNo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getIgnoredParamsForSign()
	{
		return new String[] { "sign_type" };
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
}
