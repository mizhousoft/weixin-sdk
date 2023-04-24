package com.mizhousoft.weixin.pay.constant;

/**
 * 交易状态
 *
 * 
 */
public abstract class WxPayTradeStatus
{
	// 支付成功
	public static final String SUCCESS = "SUCCESS";

	// 支付失败(其他原因，如银行返回失败)
	public static final String PAY_ERROR = "PAYERROR";

	// 用户支付中
	public static final String USER_PAYING = "USERPAYING";

	// 已关闭
	public static final String CLOSED = "CLOSED";

	// 未支付
	public static final String NOTPAY = "NOTPAY";

	// 转入退款
	public static final String REFUND = "REFUND";

	// 已撤销（刷卡支付）
	public static final String REVOKED = "REVOKED";
}
