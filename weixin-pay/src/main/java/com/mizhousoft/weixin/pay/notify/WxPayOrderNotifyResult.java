package com.mizhousoft.weixin.pay.notify;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mizhousoft.weixin.pay.result.WxBasePayResult;

/**
 * 支付结果通用通知
 *
 * @version
 */
@XmlRootElement(name = "xml")
public class WxPayOrderNotifyResult extends WxBasePayResult
{
	// 微信支付分配的终端设备号
	@XmlElement(name = "device_info")
	private String deviceInfo;

	// 用户在商户appid下的唯一标识
	@XmlElement(name = "openid")
	private String openid;

	// 用户是否关注公众账号，Y-关注，N-未关注
	@XmlElement(name = "is_subscribe")
	private String isSubscribe;

	// 调用接口提交的交易类型
	@XmlElement(name = "trade_type")
	private String tradeType;

	// 付款银行
	@XmlElement(name = "bank_type")
	private String bankType;

	// 总金额
	@XmlElement(name = "total_fee")
	private Integer totalFee;

	// 应结订单金额
	@XmlElement(name = "settlement_total_fee")
	private Integer settlementTotalFee;

	// 货币种类
	@XmlElement(name = "fee_type")
	private String feeType;

	// 现金支付金额
	@XmlElement(name = "cash_fee")
	private Integer cashFee;

	// 现金支付货币类型
	@XmlElement(name = "cash_fee_type")
	private String cashFeeType;

	// 代金券金额
	@XmlElement(name = "coupon_fee")
	private Integer couponFee;

	// 代金券使用数量
	@XmlElement(name = "coupon_count")
	private Integer couponCount;

	// 微信支付订单号
	@XmlElement(name = "transaction_id")
	private String transactionId;

	// 商户订单号
	@XmlElement(name = "out_trade_no")
	private String outTradeNo;

	// 附加数据
	@XmlElement(name = "attach")
	private String attach;

	// 支付完成时间
	@XmlElement(name = "time_end")
	private String timeEnd;

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
	 * 获取openid
	 * 
	 * @return
	 */
	@XmlTransient
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
	 * 获取isSubscribe
	 * 
	 * @return
	 */
	@XmlTransient
	public String getIsSubscribe()
	{
		return isSubscribe;
	}

	/**
	 * 设置isSubscribe
	 * 
	 * @param isSubscribe
	 */
	public void setIsSubscribe(String isSubscribe)
	{
		this.isSubscribe = isSubscribe;
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
	 * 获取bankType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getBankType()
	{
		return bankType;
	}

	/**
	 * 设置bankType
	 * 
	 * @param bankType
	 */
	public void setBankType(String bankType)
	{
		this.bankType = bankType;
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
	 * 获取settlementTotalFee
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getSettlementTotalFee()
	{
		return settlementTotalFee;
	}

	/**
	 * 设置settlementTotalFee
	 * 
	 * @param settlementTotalFee
	 */
	public void setSettlementTotalFee(Integer settlementTotalFee)
	{
		this.settlementTotalFee = settlementTotalFee;
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
	 * 获取cashFee
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCashFee()
	{
		return cashFee;
	}

	/**
	 * 设置cashFee
	 * 
	 * @param cashFee
	 */
	public void setCashFee(Integer cashFee)
	{
		this.cashFee = cashFee;
	}

	/**
	 * 获取cashFeeType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCashFeeType()
	{
		return cashFeeType;
	}

	/**
	 * 设置cashFeeType
	 * 
	 * @param cashFeeType
	 */
	public void setCashFeeType(String cashFeeType)
	{
		this.cashFeeType = cashFeeType;
	}

	/**
	 * 获取couponFee
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCouponFee()
	{
		return couponFee;
	}

	/**
	 * 设置couponFee
	 * 
	 * @param couponFee
	 */
	public void setCouponFee(Integer couponFee)
	{
		this.couponFee = couponFee;
	}

	/**
	 * 获取couponCount
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCouponCount()
	{
		return couponCount;
	}

	/**
	 * 设置couponCount
	 * 
	 * @param couponCount
	 */
	public void setCouponCount(Integer couponCount)
	{
		this.couponCount = couponCount;
	}

	/**
	 * 获取transactionId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTransactionId()
	{
		return transactionId;
	}

	/**
	 * 设置transactionId
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
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
	 * 获取timeEnd
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTimeEnd()
	{
		return timeEnd;
	}

	/**
	 * 设置timeEnd
	 * 
	 * @param timeEnd
	 */
	public void setTimeEnd(String timeEnd)
	{
		this.timeEnd = timeEnd;
	}
}
