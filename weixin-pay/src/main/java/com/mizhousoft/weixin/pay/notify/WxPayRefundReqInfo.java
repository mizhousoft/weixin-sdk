package com.mizhousoft.weixin.pay.notify;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 退款请求信息
 *
 * 
 */
@XmlRootElement(name = "root")
public class WxPayRefundReqInfo
{
	// 微信订单号
	@XmlElement(name = "transaction_id")
	private String transactionId;

	// 商户订单号
	@XmlElement(name = "out_trade_no")
	private String outTradeNo;

	// 微信退款单号
	@XmlElement(name = "refund_id")
	private String refundId;

	// 商户退款单号
	// 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	@XmlElement(name = "out_refund_no")
	private String outRefundNo;

	// 订单金额，单位为分
	@XmlElement(name = "total_fee")
	private Integer totalFee;

	// 应结订单金额
	// 应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
	@XmlElement(name = "settlement_total_fee")
	private Integer settlementTotalFee;

	// 申请退款金额，单位为分
	@XmlElement(name = "refund_fee")
	private Integer refundFee;

	// 退款金额
	// 退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
	@XmlElement(name = "settlement_refund_fee")
	private Integer settlementRefundFee;

	// 退款状态
	// SUCCESS-退款成功，CHANGE-退款异常，REFUNDCLOSE—退款关闭
	@XmlElement(name = "refund_status")
	private String refundStatus;

	// 资金退款至用户帐号的时间，格式2017-12-15 09:46:01
	@XmlElement(name = "success_time")
	private String successTime;

	// 退款入账账户
	// 取当前退款单的退款入账方，1）退回银行卡：{银行名称}{卡类型}{卡尾号}，2）退回支付用户零钱:支付用户零钱 ，3）退还商户: 商户基本账户，商户结算银行账户，4）退回支付用户零钱通:
	// 支付用户零钱通
	@XmlElement(name = "refund_recv_accout")
	private String refundRecvAccout;

	// 退款资金来源
	// REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户
	// REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
	@XmlElement(name = "refund_account")
	private String refundAccount;

	// 退款发起来源
	// API接口 VENDOR_PLATFORM商户平台
	@XmlElement(name = "refund_request_source")
	private String refundRequestSource;

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
	 * 获取settlementTotalFee
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getSettlementTotalFee()
	{
		return settlementTotalFee;
	}

	/**
	 * 设置settlementTotalFee
	 * 
	 * @param settlementTotalFee
	 */
	public void setSettlementTotalFee(Integer settlementTotalFee)
	{
		this.settlementTotalFee = settlementTotalFee;
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
	 * 获取settlementRefundFee
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getSettlementRefundFee()
	{
		return settlementRefundFee;
	}

	/**
	 * 设置settlementRefundFee
	 * 
	 * @param settlementRefundFee
	 */
	public void setSettlementRefundFee(Integer settlementRefundFee)
	{
		this.settlementRefundFee = settlementRefundFee;
	}

	/**
	 * 获取refundStatus
	 * 
	 * @return
	 */
	@XmlTransient
	public String getRefundStatus()
	{
		return refundStatus;
	}

	/**
	 * 设置refundStatus
	 * 
	 * @param refundStatus
	 */
	public void setRefundStatus(String refundStatus)
	{
		this.refundStatus = refundStatus;
	}

	/**
	 * 获取successTime
	 * 
	 * @return
	 */
	@XmlTransient
	public String getSuccessTime()
	{
		return successTime;
	}

	/**
	 * 设置successTime
	 * 
	 * @param successTime
	 */
	public void setSuccessTime(String successTime)
	{
		this.successTime = successTime;
	}

	/**
	 * 获取refundRecvAccout
	 * 
	 * @return
	 */
	@XmlTransient
	public String getRefundRecvAccout()
	{
		return refundRecvAccout;
	}

	/**
	 * 设置refundRecvAccout
	 * 
	 * @param refundRecvAccout
	 */
	public void setRefundRecvAccout(String refundRecvAccout)
	{
		this.refundRecvAccout = refundRecvAccout;
	}

	/**
	 * 获取refundAccount
	 * 
	 * @return
	 */
	@XmlTransient
	public String getRefundAccount()
	{
		return refundAccount;
	}

	/**
	 * 设置refundAccount
	 * 
	 * @param refundAccount
	 */
	public void setRefundAccount(String refundAccount)
	{
		this.refundAccount = refundAccount;
	}

	/**
	 * 获取refundRequestSource
	 * 
	 * @return
	 */
	@XmlTransient
	public String getRefundRequestSource()
	{
		return refundRequestSource;
	}

	/**
	 * 设置refundRequestSource
	 * 
	 * @param refundRequestSource
	 */
	public void setRefundRequestSource(String refundRequestSource)
	{
		this.refundRequestSource = refundRequestSource;
	}
}
