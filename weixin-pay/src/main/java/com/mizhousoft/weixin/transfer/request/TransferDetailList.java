package com.mizhousoft.weixin.transfer.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 转账明细
 *
 * @version
 */
public class TransferDetailList
{
	/**
	 * <pre>
	 * 字段名：商家明细单号
	 * 变量名：out_detail_no
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  商户系统内部区分转账批次单下不同转账明细单的唯一标识
	 * 示例值：x23zy545Bd5436
	 * </pre>
	 */
	@JsonProperty(value = "out_detail_no")
	private String outDetailNo;

	/**
	 * <pre>
	 * 字段名：转账金额
	 * 变量名：transfer_amount
	 * 是否必填：是
	 * 类型：int
	 * 描述：
	 *  转账金额单位为分
	 * 示例值：200000
	 * </pre>
	 */
	@JsonProperty(value = "transfer_amount")
	private Integer transferAmount;

	/**
	 * <pre>
	 * 字段名：转账备注
	 * 变量名：transfer_remark
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  单条转账备注（微信用户会收到该备注），UTF8编码，最多允许32个字符
	 * 示例值：2020年4月报销
	 * </pre>
	 */
	@JsonProperty(value = "transfer_remark")
	private String transferRemark;

	/**
	 * <pre>
	 * 字段名：用户在直连商户应用下的用户标示
	 * 变量名：openid
	 * 是否必填：是
	 * 类型：string[1,128]
	 * 描述：
	 *  用户在直连商户appid下的唯一标识
	 * 示例值：o-MYE42l80oelYMDE34nYD456Xoy
	 * </pre>
	 */
	@JsonProperty(value = "openid")
	private String openid;

	/**
	 * <pre>
	 * 字段名：收款用户姓名
	 * 变量名：user_name
	 * 是否必填：否
	 * 类型：string[1,1024]
	 * 描述：
	 *  1、商户转账时传入了收款用户姓名、查询时会返回收款用户姓名；
	 * 2、收款方姓名采用标准RSA算法，公钥由微信侧提供
	 * 3、 该字段需进行加密处理，加密方法详见敏感信息加密说明。(提醒：必须在HTTP头中上送Wechatpay-Serial)
	 * 示例值：757b340b45ebef5467rter35gf464344v3542sdf4t6re4tb4f54ty45t4yyry45
	 * </pre>
	 */
	@JsonProperty(value = "user_name")
	private String userName;

	/**
	 * 获取outDetailNo
	 * @return
	 */
	public String getOutDetailNo()
	{
		return outDetailNo;
	}

	/**
	 * 设置outDetailNo
	 * @param outDetailNo
	 */
	public void setOutDetailNo(String outDetailNo)
	{
		this.outDetailNo = outDetailNo;
	}

	/**
	 * 获取transferAmount
	 * @return
	 */
	public Integer getTransferAmount()
	{
		return transferAmount;
	}

	/**
	 * 设置transferAmount
	 * @param transferAmount
	 */
	public void setTransferAmount(Integer transferAmount)
	{
		this.transferAmount = transferAmount;
	}

	/**
	 * 获取transferRemark
	 * @return
	 */
	public String getTransferRemark()
	{
		return transferRemark;
	}

	/**
	 * 设置transferRemark
	 * @param transferRemark
	 */
	public void setTransferRemark(String transferRemark)
	{
		this.transferRemark = transferRemark;
	}

	/**
	 * 获取openid
	 * @return
	 */
	public String getOpenid()
	{
		return openid;
	}

	/**
	 * 设置openid
	 * @param openid
	 */
	public void setOpenid(String openid)
	{
		this.openid = openid;
	}

	/**
	 * 获取userName
	 * @return
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * 设置userName
	 * @param userName
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}
