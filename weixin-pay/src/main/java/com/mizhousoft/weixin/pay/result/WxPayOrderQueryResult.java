package com.mizhousoft.weixin.pay.result;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 订单查询结果
 *
 * @version
 */
@XmlRootElement(name = "xml")
public class WxPayOrderQueryResult extends WxBasePayResult
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

	// 交易状态
	@XmlElement(name = "trade_state")
	private String tradeState;

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

	// 交易状态描述
	@XmlElement(name = "trade_state_desc")
	private String tradeStateDesc;

	// 代金券类型.
	// 订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
	@XmlElement(name = "coupon_type_0")
	private String couponType0;

	// 单个代金券支付金额.
	// 单个代金券支付金额, $n为下标，从0开始编号
	@XmlElement(name = "coupon_fee_0")
	private Integer couponFee0;

	// 代金券ID.
	// 代金券ID, $n为下标，从0开始编号
	@XmlElement(name = "coupon_id_0")
	private String couponId0;

	// 代金券类型.
	// 订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
	@XmlElement(name = "coupon_type_1")
	private String couponType1;

	// 单个代金券支付金额.
	// 单个代金券支付金额, $n为下标，从0开始编号
	@XmlElement(name = "coupon_fee_1")
	private Integer couponFee1;

	// 代金券ID.
	// 代金券ID, $n为下标，从0开始编号
	@XmlElement(name = "coupon_id_1")
	private String couponId1;

	// 代金券类型.
	// 订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
	@XmlElement(name = "coupon_type_2")
	private String couponType2;

	// 单个代金券支付金额.
	// 单个代金券支付金额, $n为下标，从0开始编号
	@XmlElement(name = "coupon_fee_2")
	private Integer couponFee2;

	// 代金券ID.
	// 代金券ID, $n为下标，从0开始编号
	@XmlElement(name = "coupon_id_2")
	private String couponId2;

	// 代金券类型.
	// 订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
	@XmlElement(name = "coupon_type_3")
	private String couponType3;

	// 单个代金券支付金额.
	// 单个代金券支付金额, $n为下标，从0开始编号
	@XmlElement(name = "coupon_fee_3")
	private Integer couponFee3;

	// 代金券ID.
	// 代金券ID, $n为下标，从0开始编号
	@XmlElement(name = "coupon_id_3")
	private String couponId3;

	// 代金券类型.
	// 订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_$0
	@XmlElement(name = "coupon_type_4")
	private String couponType4;

	// 单个代金券支付金额.
	// 单个代金券支付金额, $n为下标，从0开始编号
	@XmlElement(name = "coupon_fee_4")
	private Integer couponFee4;

	// 代金券ID.
	// 代金券ID, $n为下标，从0开始编号
	@XmlElement(name = "coupon_id_4")
	private String couponId4;

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
	 * 获取tradeState
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTradeState()
	{
		return tradeState;
	}

	/**
	 * 设置tradeState
	 * 
	 * @param tradeState
	 */
	public void setTradeState(String tradeState)
	{
		this.tradeState = tradeState;
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

	/**
	 * 获取tradeStateDesc
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTradeStateDesc()
	{
		return tradeStateDesc;
	}

	/**
	 * 设置tradeStateDesc
	 * 
	 * @param tradeStateDesc
	 */
	public void setTradeStateDesc(String tradeStateDesc)
	{
		this.tradeStateDesc = tradeStateDesc;
	}

	/**
	 * 获取couponType0
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponType0()
	{
		return couponType0;
	}

	/**
	 * 设置couponType0
	 * 
	 * @param couponType0
	 */
	public void setCouponType0(String couponType0)
	{
		this.couponType0 = couponType0;
	}

	/**
	 * 获取couponFee0
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCouponFee0()
	{
		return couponFee0;
	}

	/**
	 * 设置couponFee0
	 * 
	 * @param couponFee0
	 */
	public void setCouponFee0(Integer couponFee0)
	{
		this.couponFee0 = couponFee0;
	}

	/**
	 * 获取couponId0
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponId0()
	{
		return couponId0;
	}

	/**
	 * 设置couponId0
	 * 
	 * @param couponId0
	 */
	public void setCouponId0(String couponId0)
	{
		this.couponId0 = couponId0;
	}

	/**
	 * 获取couponType1
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponType1()
	{
		return couponType1;
	}

	/**
	 * 设置couponType1
	 * 
	 * @param couponType1
	 */
	public void setCouponType1(String couponType1)
	{
		this.couponType1 = couponType1;
	}

	/**
	 * 获取couponFee1
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCouponFee1()
	{
		return couponFee1;
	}

	/**
	 * 设置couponFee1
	 * 
	 * @param couponFee1
	 */
	public void setCouponFee1(Integer couponFee1)
	{
		this.couponFee1 = couponFee1;
	}

	/**
	 * 获取couponId1
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponId1()
	{
		return couponId1;
	}

	/**
	 * 设置couponId1
	 * 
	 * @param couponId1
	 */
	public void setCouponId1(String couponId1)
	{
		this.couponId1 = couponId1;
	}

	/**
	 * 获取couponType2
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponType2()
	{
		return couponType2;
	}

	/**
	 * 设置couponType2
	 * 
	 * @param couponType2
	 */
	public void setCouponType2(String couponType2)
	{
		this.couponType2 = couponType2;
	}

	/**
	 * 获取couponFee2
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCouponFee2()
	{
		return couponFee2;
	}

	/**
	 * 设置couponFee2
	 * 
	 * @param couponFee2
	 */
	public void setCouponFee2(Integer couponFee2)
	{
		this.couponFee2 = couponFee2;
	}

	/**
	 * 获取couponId2
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponId2()
	{
		return couponId2;
	}

	/**
	 * 设置couponId2
	 * 
	 * @param couponId2
	 */
	public void setCouponId2(String couponId2)
	{
		this.couponId2 = couponId2;
	}

	/**
	 * 获取couponType3
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponType3()
	{
		return couponType3;
	}

	/**
	 * 设置couponType3
	 * 
	 * @param couponType3
	 */
	public void setCouponType3(String couponType3)
	{
		this.couponType3 = couponType3;
	}

	/**
	 * 获取couponFee3
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCouponFee3()
	{
		return couponFee3;
	}

	/**
	 * 设置couponFee3
	 * 
	 * @param couponFee3
	 */
	public void setCouponFee3(Integer couponFee3)
	{
		this.couponFee3 = couponFee3;
	}

	/**
	 * 获取couponId3
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponId3()
	{
		return couponId3;
	}

	/**
	 * 设置couponId3
	 * 
	 * @param couponId3
	 */
	public void setCouponId3(String couponId3)
	{
		this.couponId3 = couponId3;
	}

	/**
	 * 获取couponType4
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponType4()
	{
		return couponType4;
	}

	/**
	 * 设置couponType4
	 * 
	 * @param couponType4
	 */
	public void setCouponType4(String couponType4)
	{
		this.couponType4 = couponType4;
	}

	/**
	 * 获取couponFee4
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getCouponFee4()
	{
		return couponFee4;
	}

	/**
	 * 设置couponFee4
	 * 
	 * @param couponFee4
	 */
	public void setCouponFee4(Integer couponFee4)
	{
		this.couponFee4 = couponFee4;
	}

	/**
	 * 获取couponId4
	 * 
	 * @return
	 */
	@XmlTransient
	public String getCouponId4()
	{
		return couponId4;
	}

	/**
	 * 设置couponId4
	 * 
	 * @param couponId4
	 */
	public void setCouponId4(String couponId4)
	{
		this.couponId4 = couponId4;
	}
}
