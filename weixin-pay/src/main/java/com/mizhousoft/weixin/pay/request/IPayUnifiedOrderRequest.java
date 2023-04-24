package com.mizhousoft.weixin.pay.request;

/**
 * APP支付统一订单请求
 *
 * 
 */
public class IPayUnifiedOrderRequest
{
	// 应用APPID
	private String appId;

	// 设备号
	private String deviceInfo;

	// 商品描述
	private String body;

	// 商品详情
	private String detail;

	// 附加数据
	private String attach;

	// 商户订单号
	private String outTradeNo;

	// 总金额，单位为分
	private Integer totalFee;

	// 终端IP
	private String spbillCreateIp;

	// 交易起始时间
	private String timeStart;

	// 交易结束时间
	private String timeExpire;

	// 订单优惠标记
	private String goodsTag;

	// 交易类型
	private String tradeType;

	// 用户标识
	private String openId;

	// 微信支付异步回掉地址，如果不填写，将取配置对象中的数据填充
	private String payNotifyUrl;

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
	 * 获取body
	 * 
	 * @return
	 */
	public String getBody()
	{
		return body;
	}

	/**
	 * 设置body
	 * 
	 * @param body
	 */
	public void setBody(String body)
	{
		this.body = body;
	}

	/**
	 * 获取detail
	 * 
	 * @return
	 */
	public String getDetail()
	{
		return detail;
	}

	/**
	 * 设置detail
	 * 
	 * @param detail
	 */
	public void setDetail(String detail)
	{
		this.detail = detail;
	}

	/**
	 * 获取attach
	 * 
	 * @return
	 */
	public String getAttach()
	{
		return attach;
	}

	/**
	 * 设置attach
	 * 
	 * @param attach
	 */
	public void setAttach(String attach)
	{
		this.attach = attach;
	}

	/**
	 * 获取outTradeNo
	 * 
	 * @return
	 */
	public String getOutTradeNo()
	{
		return outTradeNo;
	}

	/**
	 * 设置outTradeNo
	 * 
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo)
	{
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 获取totalFee
	 * 
	 * @return
	 */
	public Integer getTotalFee()
	{
		return totalFee;
	}

	/**
	 * 设置totalFee
	 * 
	 * @param totalFee
	 */
	public void setTotalFee(Integer totalFee)
	{
		this.totalFee = totalFee;
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

	/**
	 * 获取timeStart
	 * 
	 * @return
	 */
	public String getTimeStart()
	{
		return timeStart;
	}

	/**
	 * 设置timeStart
	 * 
	 * @param timeStart
	 */
	public void setTimeStart(String timeStart)
	{
		this.timeStart = timeStart;
	}

	/**
	 * 获取timeExpire
	 * 
	 * @return
	 */
	public String getTimeExpire()
	{
		return timeExpire;
	}

	/**
	 * 设置timeExpire
	 * 
	 * @param timeExpire
	 */
	public void setTimeExpire(String timeExpire)
	{
		this.timeExpire = timeExpire;
	}

	/**
	 * 获取goodsTag
	 * 
	 * @return
	 */
	public String getGoodsTag()
	{
		return goodsTag;
	}

	/**
	 * 设置goodsTag
	 * 
	 * @param goodsTag
	 */
	public void setGoodsTag(String goodsTag)
	{
		this.goodsTag = goodsTag;
	}

	/**
	 * 获取tradeType
	 * 
	 * @return
	 */
	public String getTradeType()
	{
		return tradeType;
	}

	/**
	 * 设置tradeType
	 * 
	 * @param tradeType
	 */
	public void setTradeType(String tradeType)
	{
		this.tradeType = tradeType;
	}

	/**
	 * 获取openId
	 * 
	 * @return
	 */
	public String getOpenId()
	{
		return openId;
	}

	/**
	 * 设置openId
	 * 
	 * @param openId
	 */
	public void setOpenId(String openId)
	{
		this.openId = openId;
	}

	/**
	 * 获取payNotifyUrl
	 * 
	 * @return
	 */
	public String getPayNotifyUrl()
	{
		return payNotifyUrl;
	}

	/**
	 * 设置payNotifyUrl
	 * 
	 * @param payNotifyUrl
	 */
	public void setPayNotifyUrl(String payNotifyUrl)
	{
		this.payNotifyUrl = payNotifyUrl;
	}
}
