package com.mizhousoft.weixin.pay.result;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 微信支付退款结果
 *
 * 
 */
@XmlRootElement(name = "xml")
public class WxPayRefundResult extends WxBasePayResult
{
	// 微信订单号
	@XmlElement(name = "transaction_id")
	private String transactionId;

	// 商户订单号
	@XmlElement(name = "out_trade_no")
	private String outTradeNo;

	// 商户退款单号
	@XmlElement(name = "out_refund_no")
	private String outRefundNo;

	// 微信退款单号
	@XmlElement(name = "refund_id")
	private String refundId;

	// 退款金额,单位为分
	@XmlElement(name = "refund_fee")
	private Integer refundFee;

	// 应结退款金额,单位为分
	// 去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
	@XmlElement(name = "settlement_refund_fee")
	private Integer settlementRefundFee;

	// 标价金额，单位为分
	@XmlElement(name = "total_fee")
	private Integer totalFee;

	// 应结订单金额，单位为分
	// 去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
	@XmlElement(name = "settlement_total_fee")
	private Integer settlementTotalFee;

	// 标价币种
	@XmlElement(name = "fee_type")
	private String feeType;

	// 现金支付金额，单位为分
	@XmlElement(name = "cash_fee")
	private Integer cashFee;

	// 现金支付币种
	@XmlElement(name = "cash_fee_type")
	private String cashFeeType;

	// 现金退款金额，单位为分，只能为整数，详见支付金额
	@XmlElement(name = "cash_refund_fee")
	private Integer cashRefundFee;

	// 退款代金券使用数量
	@XmlElement(name = "coupon_refund_count")
	private Integer couponRefundCount;

	// 代金券退款总金额
	// 代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金
	@XmlElement(name = "coupon_refund_fee")
	private Integer couponRefundFee;

	// 退款代金券信息
	private List<WxPayRefundCouponInfo> refundCoupons;

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
	 * 获取feeType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getFeeType()
	{
		return feeType;
	}

	/**
	 * 设置feeType
	 * 
	 * @param feeType
	 */
	public void setFeeType(String feeType)
	{
		this.feeType = feeType;
	}

	/**
	 * 获取cashFee
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCashFee()
	{
		return cashFee;
	}

	/**
	 * 设置cashFee
	 * 
	 * @param cashFee
	 */
	public void setCashFee(Integer cashFee)
	{
		this.cashFee = cashFee;
	}

	/**
	 * 获取cashFeeType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCashFeeType()
	{
		return cashFeeType;
	}

	/**
	 * 设置cashFeeType
	 * 
	 * @param cashFeeType
	 */
	public void setCashFeeType(String cashFeeType)
	{
		this.cashFeeType = cashFeeType;
	}

	/**
	 * 获取cashRefundFee
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCashRefundFee()
	{
		return cashRefundFee;
	}

	/**
	 * 设置cashRefundFee
	 * 
	 * @param cashRefundFee
	 */
	public void setCashRefundFee(Integer cashRefundFee)
	{
		this.cashRefundFee = cashRefundFee;
	}

	/**
	 * 获取couponRefundCount
	 * 
	 * @return
	 */
	@XmlTransient
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
	 * 获取couponRefundFee
	 * 
	 * @return
	 */
	@XmlTransient
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
	 * 获取refundCoupons
	 * 
	 * @return
	 */
	public List<WxPayRefundCouponInfo> getRefundCoupons()
	{
		return refundCoupons;
	}

	/**
	 * 设置refundCoupons
	 * 
	 * @param refundCoupons
	 */
	public void setRefundCoupons(List<WxPayRefundCouponInfo> refundCoupons)
	{
		this.refundCoupons = refundCoupons;
	}
}
