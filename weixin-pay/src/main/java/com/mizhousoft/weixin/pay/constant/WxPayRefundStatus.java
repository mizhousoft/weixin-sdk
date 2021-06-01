package com.mizhousoft.weixin.pay.constant;

/**
 * 退款状态
 *
 * @version
 */
public abstract class WxPayRefundStatus
{
	// 退款成功.
	public static final String SUCCESS = "SUCCESS";

	// 退款关闭.
	public static final String REFUND_CLOSE = "REFUNDCLOSE";

	// 退款处理中.
	public static final String PROCESSING = "PROCESSING";

	// 退款异常.
	// 退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。
	public static final String CHANGE = "CHANGE";
}
