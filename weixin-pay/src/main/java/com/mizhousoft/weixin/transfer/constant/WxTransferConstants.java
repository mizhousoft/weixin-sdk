package com.mizhousoft.weixin.transfer.constant;

/**
 * 转账常量
 *
 */
public class WxTransferConstants
{
	/**
	 * 状态.
	 */
	public static class TransferStatus
	{
		/**
		 * 转账成功
		 */
		public static final String SUCCESS = "SUCCESS";

		/**
		 * 转账中。正在处理中，转账结果尚未明确
		 */
		public static final String PROCESSING = "PROCESSING";

		/**
		 * 转账失败。需要确认失败原因后，再决定是否重新发起对该笔明细单的转账（并非整个转账批次单）
		 */
		public static final String FAIL = "FAIL";
	}
}
