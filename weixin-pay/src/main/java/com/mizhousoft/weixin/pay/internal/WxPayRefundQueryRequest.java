package com.mizhousoft.weixin.pay.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 退款查询请求
 *
 * @version
 */
@XmlRootElement(name = "xml")
public class WxPayRefundQueryRequest extends WxBasePayRequest
{
	// 微信订单号
	@XmlElement(name = "transaction_id")
	private String transactionId;

	// 商户订单号
	// transaction_id、out_trade_no二选一，如果同时存在优先级：transaction_id> out_trade_no
	@XmlElement(name = "out_trade_no")
	private String outTradeNo;

	// 商户退款单号
	// 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	@XmlElement(name = "out_refund_no")
	private String outRefundNo;

	// 微信退款单号
	@XmlElement(name = "refund_id")
	private String refundId;

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

	/**
	 * 获取outRefundNo
	 * 
	 * @return
	 */
	@XmlTransient
	public String getOutRefundNo()
	{
		return outRefundNo;
	}

	/**
	 * 设置outRefundNo
	 * 
	 * @param outRefundNo
	 */
	public void setOutRefundNo(String outRefundNo)
	{
		this.outRefundNo = outRefundNo;
	}

	/**
	 * 获取refundId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getRefundId()
	{
		return refundId;
	}

	/**
	 * 设置refundId
	 * 
	 * @param refundId
	 */
	public void setRefundId(String refundId)
	{
		this.refundId = refundId;
	}
}
