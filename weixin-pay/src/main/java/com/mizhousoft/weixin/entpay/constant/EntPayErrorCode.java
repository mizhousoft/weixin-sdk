package com.mizhousoft.weixin.entpay.constant;

/**
 * 企业支付错误码
 *
 * @version
 */
public interface EntPayErrorCode
{
	// 没有该接口权限
	String NO_AUTH = "NO_AUTH";

	// 金额超限
	String AMOUNT_LIMIT = "AMOUNT_LIMIT";

	// 参数错误
	String PARAM_ERROR = "PARAM_ERROR";

	// Openid错误
	String OPENID_ERROR = "OPENID_ERROR";

	// 付款错误
	String SEND_FAILED = "SEND_FAILED";

	// 余额不足
	String NOTENOUGH = "NOTENOUGH";

	// 系统繁忙，请稍后再试。
	String SYSTEMERROR = "SYSTEMERROR";

	// 姓名校验出错
	String NAME_MISMATCH = "NAME_MISMATCH";

	// 签名错误
	String SIGN_ERROR = "SIGN_ERROR";

	// Post内容出错
	String XML_ERROR = "XML_ERROR";

	// 两次请求参数不一致
	String FATAL_ERROR = "FATAL_ERROR";

	// 超过频率限制，请稍后再试。
	String FREQ_LIMIT = "FREQ_LIMIT";

	// 已经达到今日付款总额上限/已达到付款给此用户额度上限
	String MONEY_LIMIT = "MONEY_LIMIT";

	// 商户API证书校验出错
	String CA_ERROR = "CA_ERROR";

	// 无法给未实名用户付款
	String V2_ACCOUNT_SIMPLE_BAN = "V2_ACCOUNT_SIMPLE_BAN";

	// 请求参数中包含非utf8编码字符
	String PARAM_IS_NOT_UTF8 = "PARAM_IS_NOT_UTF8";

	// 该用户今日付款次数超过限制,如有需要请进入【微信支付商户平台-产品中心-企业付款到零钱-产品设置】进行修改
	String ENDNUM_LIMIT = "ENDNUM_LIMIT";

	// 收款账户不在收款账户列表
	String RECV_ACCOUNT_NOT_ALLOWED = "RECV_ACCOUNT_NOT_ALLOWED";

	// 本商户号未配置API发起能力
	String PAY_CHANNEL_NOT_ALLOWED = "PAY_CHANNEL_NOT_ALLOWED";
}
