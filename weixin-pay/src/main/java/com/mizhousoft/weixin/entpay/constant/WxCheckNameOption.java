package com.mizhousoft.weixin.entpay.constant;

/**
 * 校验用户姓名选项，企业付款时使用.
 *
 * 
 */
public interface WxCheckNameOption
{
	// 不校验真实姓名
	public static final String NO_CHECK = "NO_CHECK";

	// 强校验真实姓名
	public static final String FORCE_CHECK = "FORCE_CHECK";
}
