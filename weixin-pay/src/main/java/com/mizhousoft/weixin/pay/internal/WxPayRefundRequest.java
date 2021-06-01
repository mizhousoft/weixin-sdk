package com.mizhousoft.weixin.pay.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 支付退款请求
 *
 * @version
 */
@XmlRootElement(name = "xml")
public class WxPayRefundRequest extends WxBasePayRequest
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

	// 订单金额，单位为分
	@XmlElement(name = "total_fee")
	private Integer totalFee;

	// 退款金额，单位为分
	@XmlElement(name = "refund_fee")
	private Integer refundFee;

	// 退款货币种类
	// 退款货币类型，需与支付一致，或者不填。
	@XmlElement(name = "refund_fee_type")
	private String refundFeeType;

	// 退款原因
	@XmlElement(name = "refund_desc")
	private String refundDesc;

	// 退款结果通知url
	@XmlElement(name = "notify_url")
	private String notifyUrl;

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
	 * 获取totalFee
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getTotalFee()
	{
		return totalFee;
	}

	/**
	 * 设置totalFee
	 * 
	 * @param totalFee
	 */
	public void setTotalFee(Integer totalFee)
	{
		this.totalFee = totalFee;
	}

	/**
	 * 获取refundFee
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getRefundFee()
	{
		return refundFee;
	}

	/**
	 * 设置refundFee
	 * 
	 * @param refundFee
	 */
	public void setRefundFee(Integer refundFee)
	{
		this.refundFee = refundFee;
	}

	/**
	 * 获取refundFeeType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getRefundFeeType()
	{
		return refundFeeType;
	}

	/**
	 * 设置refundFeeType
	 * 
	 * @param refundFeeType
	 */
	public void setRefundFeeType(String refundFeeType)
	{
		this.refundFeeType = refundFeeType;
	}

	/**
	 * 获取refundDesc
	 * 
	 * @return
	 */
	@XmlTransient
	public String getRefundDesc()
	{
		return refundDesc;
	}

	/**
	 * 设置refundDesc
	 * 
	 * @param refundDesc
	 */
	public void setRefundDesc(String refundDesc)
	{
		this.refundDesc = refundDesc;
	}

	/**
	 * 获取notifyUrl
	 * 
	 * @return
	 */
	@XmlTransient
	public String getNotifyUrl()
	{
		return notifyUrl;
	}

	/**
	 * 设置notifyUrl
	 * 
	 * @param notifyUrl
	 */
	public void setNotifyUrl(String notifyUrl)
	{
		this.notifyUrl = notifyUrl;
	}
}
