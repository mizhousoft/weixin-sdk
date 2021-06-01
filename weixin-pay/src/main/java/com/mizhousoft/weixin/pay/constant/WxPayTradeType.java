package com.mizhousoft.weixin.pay.constant;

/**
 * 交易类型
 *
 * @version
 */
public abstract class WxPayTradeType
{
	// 原生扫码支付
	public static final String NATIVE = "NATIVE";

	// App支付
	public static final String APP = "APP";

	// 公众号支付/小程序支付
	public static final String JSAPI = "JSAPI";

	// H5支付
	public static final String MWEB = "MWEB";

	// 刷卡支付.
	// 刷卡支付有单独的支付接口，不调用统一下单接口
	public static final String MICROPAY = "MICROPAY";
}
