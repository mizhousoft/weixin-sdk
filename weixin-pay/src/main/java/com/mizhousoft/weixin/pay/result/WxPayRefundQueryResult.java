package com.mizhousoft.weixin.pay.result;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 退款查询返回结果
 *
 * @version
 */
@XmlRootElement(name = "xml")
public class WxPayRefundQueryResult extends WxBasePayResult
{
	// 微信订单号
	@XmlElement(name = "transaction_id")
	private String transactionId;

	// 商户订单号
	@XmlElement(name = "out_trade_no")
	private String outTradeNo;

	// 订单总金额，单位为分，只能为整数，详见支付金额
	@XmlElement(name = "total_fee")
	private Integer totalFee;

	// 应结订单金额
	// 应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
	@XmlElement(name = "settlement_total_fee")
	private Integer settlementTotalFee;

	// 货币种类
	// 订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
	@XmlElement(name = "fee_type")
	private String feeType;

	// 现金支付金额
	// 现金支付金额，单位为分，只能为整数，详见支付金额
	@XmlElement(name = "cash_fee")
	private Integer cashFee;

	// 退款笔数
	// 退款记录数
	@XmlElement(name = "refund_count")
	private Integer refundCount;

	// 退款记录
	private List<WxRefundRecord> refundRecords;

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
	 * 获取refundCount
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getRefundCount()
	{
		return refundCount;
	}

	/**
	 * 设置refundCount
	 * 
	 * @param refundCount
	 */
	public void setRefundCount(Integer refundCount)
	{
		this.refundCount = refundCount;
	}

	/**
	 * 获取refundRecords
	 * 
	 * @return
	 */
	public List<WxRefundRecord> getRefundRecords()
	{
		return refundRecords;
	}

	/**
	 * 设置refundRecords
	 * 
	 * @param refundRecords
	 */
	public void setRefundRecords(List<WxRefundRecord> refundRecords)
	{
		this.refundRecords = refundRecords;
	}
}
