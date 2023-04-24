package com.mizhousoft.weixin.pay.constant;

/**
 * 退款渠道.
 *
 * 
 */
public abstract class WxPayRefundChannel
{
	// 原路退款.
	public static final String ORIGINAL = "ORIGINAL";

	// 退回到余额.
	public static final String BALANCE = "BALANCE";

	// 原账户异常退到其他余额账户.
	public static final String OTHER_BALANCE = "OTHER_BALANCE";

	// 原银行卡异常退到其他银行卡.
	public static final String OTHER_BANKCARD = "OTHER_BANKCARD";
}
