package com.mizhousoft.weixin.pay.result;

import javax.xml.bind.annotation.XmlElement;

/**
 * 退款记录
 *
 * 
 */
public class WxRefundRecord
{
	// 商户退款单号
	@XmlElement(name = "out_refund_no")
	private String outRefundNo;

	// 微信退款单号
	@XmlElement(name = "refund_id")
	private String refundId;

	// 退款渠道
	// ORIGINAL—原路退款 BALANCE—退回到余额
	// OTHER_BALANCE—原账户异常退到其他余额账户 OTHER_BANKCARD—原银行卡异常退到其他银行卡
	@XmlElement(name = "refund_channel")
	private String refundChannel;

	// 申请退款金额
	// 退款总金额,单位为分,可以做部分退款
	@XmlElement(name = "refund_fee")
	private Integer refundFee;

	// 退款金额
	// 退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
	@XmlElement(name = "settlement_refund_fee")
	private Integer settlementRefundFee;

	// 退款资金来源
	// REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户
	// REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
	@XmlElement(name = "refund_account")
	private String refundAccount;

	// 代金券退款金额
	// 代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠
	@XmlElement(name = "coupon_refund_fee")
	private Integer couponRefundFee;

	// 退款代金券使用数量
	@XmlElement(name = "coupon_refund_count")
	private Integer couponRefundCount;

	// 退款状态
	// SUCCESS—退款成功， FAIL—退款失败， PROCESSING—退款处理中， CHANGE—转入代发，
	@XmlElement(name = "refund_status")
	private String refundStatus;

	// 退款入账账户
	// 取当前退款单的退款入账方，1）退回银行卡：{银行名称}{卡类型}{卡尾号}，2）退回支付用户零钱:支付用户零钱
	@XmlElement(name = "refund_recv_accout")
	private String refundRecvAccount;

	// 退款成功时间
	// 退款成功时间，当退款状态为退款成功时有返回。$n为下标，从0开始编号
	@XmlElement(name = "refund_success_time")
	private String refundSuccessTime;

	/**
	 * 获取outRefundNo
	 * 
	 * @return
	 */
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
	 * 获取refundChannel
	 * 
	 * @return
	 */
	public String getRefundChannel()
	{
		return refundChannel;
	}

	/**
	 * 设置refundChannel
	 * 
	 * @param refundChannel
	 */
	public void setRefundChannel(String refundChannel)
	{
		this.refundChannel = refundChannel;
	}

	/**
	 * 获取refundFee
	 * 
	 * @return
	 */
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
	 * 获取refundAccount
	 * 
	 * @return
	 */
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
	 * 获取couponRefundFee
	 * 
	 * @return
	 */
	public Integer getCouponRefundFee()
	{
		return couponRefundFee;
	}

	/**
	 * 设置couponRefundFee
	 * 
	 * @param couponRefundFee
	 */
	public void setCouponRefundFee(Integer couponRefundFee)
	{
		this.couponRefundFee = couponRefundFee;
	}

	/**
	 * 获取couponRefundCount
	 * 
	 * @return
	 */
	public Integer getCouponRefundCount()
	{
		return couponRefundCount;
	}

	/**
	 * 设置couponRefundCount
	 * 
	 * @param couponRefundCount
	 */
	public void setCouponRefundCount(Integer couponRefundCount)
	{
		this.couponRefundCount = couponRefundCount;
	}

	/**
	 * 获取refundStatus
	 * 
	 * @return
	 */
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
	 * 获取refundRecvAccount
	 * 
	 * @return
	 */
	public String getRefundRecvAccount()
	{
		return refundRecvAccount;
	}

	/**
	 * 设置refundRecvAccount
	 * 
	 * @param refundRecvAccount
	 */
	public void setRefundRecvAccount(String refundRecvAccount)
	{
		this.refundRecvAccount = refundRecvAccount;
	}

	/**
	 * 获取refundSuccessTime
	 * 
	 * @return
	 */
	public String getRefundSuccessTime()
	{
		return refundSuccessTime;
	}

	/**
	 * 设置refundSuccessTime
	 * 
	 * @param refundSuccessTime
	 */
	public void setRefundSuccessTime(String refundSuccessTime)
	{
		this.refundSuccessTime = refundSuccessTime;
	}
}
