package com.mizhousoft.weixin.pay.result;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 退款代金券信息
 *
 * @version
 */
public class WxPayRefundCouponInfo
{
	// 退款代金券ID
	@XmlElement(name = "coupon_refund_id")
	private String couponRefundId;

	// 单个退款代金券支付金额
	// 代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金
	@XmlElement(name = "coupon_refund_fee")
	private Integer couponRefundFee;

	// 代金券类型, 订单使用代金券时有返回（取值：CASH、NO_CASH）
	// CASH--充值代金券
	// NO_CASH---非充值代金券
	@XmlElement(name = "coupon_type")
	private String couponType;

	/**
	 * 获取couponRefundId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponRefundId()
	{
		return couponRefundId;
	}

	/**
	 * 设置couponRefundId
	 * 
	 * @param couponRefundId
	 */
	public void setCouponRefundId(String couponRefundId)
	{
		this.couponRefundId = couponRefundId;
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
	 * 获取couponType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponType()
	{
		return couponType;
	}

	/**
	 * 设置couponType
	 * 
	 * @param couponType
	 */
	public void setCouponType(String couponType)
	{
		this.couponType = couponType;
	}
}
