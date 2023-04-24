package com.mizhousoft.weixin.pay.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 订单查询请求
 *
 * 
 */
@XmlRootElement(name = "xml")
public class WxPayOrderQueryRequest extends WxBasePayRequest
{
	@XmlElement(name = "transaction_id")
	private String transactionId;

	@XmlElement(name = "out_trade_no")
	private String outTradeNo;

	/**
	 * 获取transactionId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTransactionId()
	{
		return transactionId;
	}

	/**
	 * 设置transactionId
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
	}

	/**
	 * 获取outTradeNo
	 * 
	 * @return
	 */
	@XmlTransient
	public String getOutTradeNo()
	{
		return outTradeNo;
	}

	/**
	 * 设置outTradeNo
	 * 
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo)
	{
		this.outTradeNo = outTradeNo;
	}
}
