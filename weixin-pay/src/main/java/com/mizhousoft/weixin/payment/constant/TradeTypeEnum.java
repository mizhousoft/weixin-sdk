package com.mizhousoft.weixin.payment.constant;

/**
 * 交易类型
 *
 * @version
 */
public enum TradeTypeEnum
{
	/**
	 * APP
	 */
	APP("/v3/pay/transactions/app", "/v3/combine-transactions/app"),
	/**
	 * JSAPI 或 小程序
	 */
	JSAPI("/v3/pay/transactions/jsapi", "/v3/combine-transactions/jsapi"),
	/**
	 * NATIVE
	 */
	NATIVE("/v3/pay/transactions/native", "/v3/combine-transactions/native"),
	/**
	 * H5
	 */
	H5("/v3/pay/transactions/h5", "/v3/combine-transactions/h5");

	/**
	 * 单独下单url
	 */
	private final String partnerUrl;

	/**
	 * 合并下单url
	 */
	private final String combineUrl;

	/**
	 * 构造函数
	 *
	 * @param partnerUrl
	 * @param combineUrl
	 */
	private TradeTypeEnum(String partnerUrl, String combineUrl)
	{
		this.partnerUrl = partnerUrl;
		this.combineUrl = combineUrl;
	}

	/**
	 * 获取partnerUrl
	 * 
	 * @return
	 */
	public String getPartnerUrl()
	{
		return partnerUrl;
	}

	/**
	 * 获取combineUrl
	 * 
	 * @return
	 */
	public String getCombineUrl()
	{
		return combineUrl;
	}
}
