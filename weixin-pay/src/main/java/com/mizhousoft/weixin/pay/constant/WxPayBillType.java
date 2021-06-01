package com.mizhousoft.weixin.pay.constant;

/**
 * 账单类型
 *
 * @version
 */
public abstract class WxPayBillType
{
	// 查询红包时使用：通过商户订单号获取红包信息.
	public static final String MCHT = "MCHT";

	// 以下为下载对账单时的账单类型

	// 返回当日所有订单信息，默认值.
	public static final String ALL = "ALL";

	// 返回当日成功支付的订单.
	public static final String SUCCESS = "SUCCESS";

	// 返回当日退款订单.
	public static final String REFUND = "REFUND";

	// 返回当日充值退款订单（相比其他对账单多一栏“返还手续费”）.
	public static final String RECHARGE_REFUND = "RECHARGE_REFUND";
}
