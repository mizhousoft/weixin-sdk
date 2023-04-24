package com.mizhousoft.weixin.entpay.request;

/**
 * 企业付款请求
 *
 * 
 */
public class IEntPayRequest
{
	// 商户账号appid
	// 申请商户号的appid或商户号绑定的appid
	private String mchAppId;

	// 设备号
	private String deviceInfo;

	// 商户订单号
	private String partnerTradeNo;

	// 用户openid
	private String openid;

	// 校验用户姓名选项
	private String checkName;

	// 收款用户姓名
	private String reUserName;

	// 金额
	// 企业付款金额，单位为分
	private Integer amount;

	// 企业付款备注
	private String description;

	// Ip地址
	private String spbillCreateIp;

	/**
	 * 获取mchAppId
	 * 
	 * @return
	 */
	public String getMchAppId()
	{
		return mchAppId;
	}

	/**
	 * 设置mchAppId
	 * 
	 * @param mchAppId
	 */
	public void setMchAppId(String mchAppId)
	{
		this.mchAppId = mchAppId;
	}

	/**
	 * 获取deviceInfo
	 * 
	 * @return
	 */
	public String getDeviceInfo()
	{
		return deviceInfo;
	}

	/**
	 * 设置deviceInfo
	 * 
	 * @param deviceInfo
	 */
	public void setDeviceInfo(String deviceInfo)
	{
		this.deviceInfo = deviceInfo;
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

	/**
	 * 获取openid
	 * 
	 * @return
	 */
	public String getOpenid()
	{
		return openid;
	}

	/**
	 * 设置openid
	 * 
	 * @param openid
	 */
	public void setOpenid(String openid)
	{
		this.openid = openid;
	}

	/**
	 * 获取checkName
	 * 
	 * @return
	 */
	public String getCheckName()
	{
		return checkName;
	}

	/**
	 * 设置checkName
	 * 
	 * @param checkName
	 */
	public void setCheckName(String checkName)
	{
		this.checkName = checkName;
	}

	/**
	 * 获取reUserName
	 * 
	 * @return
	 */
	public String getReUserName()
	{
		return reUserName;
	}

	/**
	 * 设置reUserName
	 * 
	 * @param reUserName
	 */
	public void setReUserName(String reUserName)
	{
		this.reUserName = reUserName;
	}

	/**
	 * 获取amount
	 * 
	 * @return
	 */
	public Integer getAmount()
	{
		return amount;
	}

	/**
	 * 设置amount
	 * 
	 * @param amount
	 */
	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	/**
	 * 获取description
	 * 
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * 设置description
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * 获取spbillCreateIp
	 * 
	 * @return
	 */
	public String getSpbillCreateIp()
	{
		return spbillCreateIp;
	}

	/**
	 * 设置spbillCreateIp
	 * 
	 * @param spbillCreateIp
	 */
	public void setSpbillCreateIp(String spbillCreateIp)
	{
		this.spbillCreateIp = spbillCreateIp;
	}
}
