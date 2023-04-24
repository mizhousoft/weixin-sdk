package com.mizhousoft.weixin.pay.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 统一订单请求
 *
 * 
 */
@XmlRootElement(name = "xml")
public class WxPayUnifiedOrderRequest extends WxBasePayRequest
{
	// 设备号
	@XmlElement(name = "device_info")
	private String deviceInfo;

	// 商品描述
	@XmlElement(name = "body")
	private String body;

	// 商品详情
	@XmlElement(name = "detail")
	private String detail;

	// 附加数据
	@XmlElement(name = "attach")
	private String attach;

	// 商户订单号
	@XmlElement(name = "out_trade_no")
	private String outTradeNo;

	// 货币类型
	@XmlElement(name = "fee_type")
	private String feeType;

	// 总金额
	@XmlElement(name = "total_fee")
	private Integer totalFee;

	// 终端IP
	@XmlElement(name = "spbill_create_ip")
	private String spbillCreateIp;

	// 交易起始时间
	@XmlElement(name = "time_start")
	private String timeStart;

	// 交易结束时间
	@XmlElement(name = "time_expire")
	private String timeExpire;

	// 订单优惠标记
	@XmlElement(name = "goods_tag")
	private String goodsTag;

	// 通知地址
	@XmlElement(name = "notify_url")
	private String notifyUrl;

	// 交易类型
	@XmlElement(name = "trade_type")
	private String tradeType;

	// 指定支付方式
	@XmlElement(name = "limit_pay")
	private String limitPay;

	// 开发票入口开放标识
	@XmlElement(name = "receipt")
	private String receipt;

	// 用户标识
	@XmlElement(name = "openid")
	private String openId;

	/**
	 * 获取deviceInfo
	 * 
	 * @return
	 */
	@XmlTransient
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
	@XmlTransient
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
	@XmlTransient
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
	@XmlTransient
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
	@XmlTransient
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
	 * 获取feeType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getFeeType()
	{
		return feeType;
	}

	/**
	 * 设置feeType
	 * 
	 * @param feeType
	 */
	public void setFeeType(String feeType)
	{
		this.feeType = feeType;
	}

	/**
	 * 获取totalFee
	 * 
	 * @return
	 */
	@XmlTransient
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
	@XmlTransient
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
	@XmlTransient
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
	@XmlTransient
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
	@XmlTransient
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
	 * 获取notifyUrl
	 * 
	 * @return
	 */
	@XmlTransient
	public String getNotifyUrl()
	{
		return notifyUrl;
	}

	/**
	 * 设置notifyUrl
	 * 
	 * @param notifyUrl
	 */
	public void setNotifyUrl(String notifyUrl)
	{
		this.notifyUrl = notifyUrl;
	}

	/**
	 * 获取tradeType
	 * 
	 * @return
	 */
	@XmlTransient
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
	 * 获取limitPay
	 * 
	 * @return
	 */
	@XmlTransient
	public String getLimitPay()
	{
		return limitPay;
	}

	/**
	 * 设置limitPay
	 * 
	 * @param limitPay
	 */
	public void setLimitPay(String limitPay)
	{
		this.limitPay = limitPay;
	}

	/**
	 * 获取receipt
	 * 
	 * @return
	 */
	@XmlTransient
	public String getReceipt()
	{
		return receipt;
	}

	/**
	 * 设置receipt
	 * 
	 * @param receipt
	 */
	public void setReceipt(String receipt)
	{
		this.receipt = receipt;
	}

	/**
	 * 获取openId
	 * 
	 * @return
	 */
	@XmlTransient
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
}
