package com.mizhousoft.weixin.transfer.constant;

/**
 * 错误码
 *
 */
public class WxTransferErrorCode
{
	public static class Transfer
	{
		/**
		 * 系统错误
		 */
		public static final String SYSTEM_ERROR = "SYSTEM_ERROR";

		/**
		 * 商户号和appid没有绑定关系
		 */
		public static final String APPID_MCHID_NOT_MATCH = "APPID_MCHID_NOT_MATCH";

		/**
		 * 参数错误
		 */
		public static final String PARAM_ERROR = "PARAM_ERROR";

		/**
		 * 请求参数符合参数格式，但不符合业务规则
		 */
		public static final String INVALID_REQUEST = "INVALID_REQUEST";

		/**
		 * 商户信息不合法
		 */
		public static final String NO_AUTH = "NO_AUTH";

		/**
		 * 资金不足
		 */
		public static final String NOT_ENOUGH = "NOT_ENOUGH";

		/**
		 * 商户账户付款受限
		 */
		public static final String ACCOUNTERROR = "ACCOUNTERROR";

		/**
		 * 超出商户单日转账额度
		 */
		public static final String QUOTA_EXCEED = "QUOTA_EXCEED";

		/**
		 * 频率超限
		 */
		public static final String FREQUENCY_LIMITED = "FREQUENCY_LIMITED";
	}
}
