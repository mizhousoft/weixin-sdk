package com.mizhousoft.weixin.entpay.result;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mizhousoft.weixin.pay.result.WxBasePayResult;

/**
 * 企业付款查询返回结果
 *
 * 
 */
@XmlRootElement(name = "xml")
public class EntPayQueryResult extends WxBasePayResult
{
	// 商户订单号
	@XmlElement(name = "partner_trade_no")
	private String partnerTradeNo;

	// 付款单号
	@XmlElement(name = "detail_id")
	private String detailId;

	// 转账状态
	@XmlElement(name = "status")
	private String status;

	// 失败原因
	@XmlElement(name = "reason")
	private String reason;

	// 收款用户openid
	@XmlElement(name = "openid")
	private String openid;

	// 收款用户姓名
	@XmlElement(name = "transfer_name")
	private String transferName;

	// 付款金额
	@XmlElement(name = "payment_amount")
	private Integer paymentAmount;

	// 发起转账的时间
	@XmlElement(name = "transfer_time")
	private String transferTime;

	// 企业付款成功时间
	@XmlElement(name = "payment_time")
	private String paymentTime;

	// 付款描述
	@XmlElement(name = "desc")
	private String desc;

	/**
	 * 获取partnerTradeNo
	 * 
	 * @return
	 */
	@XmlTransient
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
	 * 获取detailId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getDetailId()
	{
		return detailId;
	}

	/**
	 * 设置detailId
	 * 
	 * @param detailId
	 */
	public void setDetailId(String detailId)
	{
		this.detailId = detailId;
	}

	/**
	 * 获取status
	 * 
	 * @return
	 */
	@XmlTransient
	public String getStatus()
	{
		return status;
	}

	/**
	 * 设置status
	 * 
	 * @param status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * 获取reason
	 * 
	 * @return
	 */
	@XmlTransient
	public String getReason()
	{
		return reason;
	}

	/**
	 * 设置reason
	 * 
	 * @param reason
	 */
	public void setReason(String reason)
	{
		this.reason = reason;
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
	 * 获取transferName
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTransferName()
	{
		return transferName;
	}

	/**
	 * 设置transferName
	 * 
	 * @param transferName
	 */
	public void setTransferName(String transferName)
	{
		this.transferName = transferName;
	}

	/**
	 * 获取paymentAmount
	 * 
	 * @return
	 */
	@XmlTransient
	public Integer getPaymentAmount()
	{
		return paymentAmount;
	}

	/**
	 * 设置paymentAmount
	 * 
	 * @param paymentAmount
	 */
	public void setPaymentAmount(Integer paymentAmount)
	{
		this.paymentAmount = paymentAmount;
	}

	/**
	 * 获取transferTime
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTransferTime()
	{
		return transferTime;
	}

	/**
	 * 设置transferTime
	 * 
	 * @param transferTime
	 */
	public void setTransferTime(String transferTime)
	{
		this.transferTime = transferTime;
	}

	/**
	 * 获取paymentTime
	 * 
	 * @return
	 */
	@XmlTransient
	public String getPaymentTime()
	{
		return paymentTime;
	}

	/**
	 * 设置paymentTime
	 * 
	 * @param paymentTime
	 */
	public void setPaymentTime(String paymentTime)
	{
		this.paymentTime = paymentTime;
	}

	/**
	 * 获取desc
	 * 
	 * @return
	 */
	@XmlTransient
	public String getDesc()
	{
		return desc;
	}

	/**
	 * 设置desc
	 * 
	 * @param desc
	 */
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
}
