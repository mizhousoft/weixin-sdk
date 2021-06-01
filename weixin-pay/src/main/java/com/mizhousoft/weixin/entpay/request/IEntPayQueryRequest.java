package com.mizhousoft.weixin.entpay.request;

/**
 * 企业查询请求
 *
 * @version
 */
public class IEntPayQueryRequest
{
	// 商户账号appid
	private String appId;

	// 商户订单号
	private String partnerTradeNo;

	/**
	 * 获取appId
	 * 
	 * @return
	 */
	public String getAppId()
	{
		return appId;
	}

	/**
	 * 设置appId
	 * 
	 * @param appId
	 */
	public void setAppId(String appId)
	{
		this.appId = appId;
	}

	/**
	 * 获取partnerTradeNo
	 * 
	 * @return
	 */
	public String getPartnerTradeNo()
	{
		return partnerTradeNo;
	}

	/**
	 * 设置partnerTradeNo
	 * 
	 * @param partnerTradeNo
	 */
	public void setPartnerTradeNo(String partnerTradeNo)
	{
		this.partnerTradeNo = partnerTradeNo;
	}
}
