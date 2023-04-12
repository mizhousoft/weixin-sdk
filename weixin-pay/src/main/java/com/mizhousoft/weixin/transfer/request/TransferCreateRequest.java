package com.mizhousoft.weixin.transfer.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 创建请求
 *
 * @version
 */
public class TransferCreateRequest
{
	/**
	 * <pre>
	 * 字段名：直连商户的appid
	 * 变量名：appid
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  申请商户号的appid或商户号绑定的appid（企业号corpid即为此appid）
	 * 示例值：wxf636efh567hg4356
	 * </pre>
	 */
	@JsonProperty(value = "appid")
	private String appid;

	/**
	 * <pre>
	 * 字段名：商家批次单号
	 * 变量名：out_batch_no
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  path商户系统内部的商家批次单号，要求此参数只能由数字、大小写字母组成，在商户系统内部唯一
	 * 示例值：plfk2020042013
	 * </pre>
	 */
	@JsonProperty(value = "out_batch_no")
	private String outBatchNo;

	/**
	 * <pre>
	 * 字段名：批次名称
	 * 变量名：batch_name
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  该笔批量转账的名称
	 * 示例值：2019年1月深圳分部报销单
	 * </pre>
	 */
	@JsonProperty(value = "batch_name")
	private String batchName;

	/**
	 * <pre>
	 * 字段名：批次备注
	 * 变量名：batch_remark
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  转账说明，UTF8编码，最多允许32个字符
	 * 示例值：2019年1月深圳分部报销单
	 * </pre>
	 */
	@JsonProperty(value = "batch_remark")
	private String batchRemark;

	/**
	 * <pre>
	 * 字段名：转账总金额
	 * 变量名：total_amount
	 * 是否必填：是
	 * 类型：int
	 * 描述：
	 *  转账金额单位为分
	 * 示例值：4000000
	 * </pre>
	 */
	@JsonProperty(value = "total_amount")
	private Integer totalAmount;

	/**
	 * <pre>
	 * 字段名：转账总笔数
	 * 变量名：total_num
	 * 是否必填：是
	 * 类型：int
	 * 描述：
	 *  一个转账批次单最多发起三千笔转账
	 * 示例值：200
	 * </pre>
	 */
	@JsonProperty(value = "total_num")
	private Integer totalNum;

	/**
	 * <pre>
	 * 字段名：转账明细单列表
	 * 变量名：transfer_detail_list
	 * 是否必填：否
	 * 类型：array
	 * 描述：
	 *  body发起批量转账的明细列表，最多三千笔
	 * </pre>
	 */
	@JsonProperty(value = "transfer_detail_list")
	private List<TransferDetailList> transferDetailList;

	/**
	 * 获取appid
	 * 
	 * @return
	 */
	public String getAppid()
	{
		return appid;
	}

	/**
	 * 设置appid
	 * 
	 * @param appid
	 */
	public void setAppid(String appid)
	{
		this.appid = appid;
	}

	/**
	 * 获取outBatchNo
	 * 
	 * @return
	 */
	public String getOutBatchNo()
	{
		return outBatchNo;
	}

	/**
	 * 设置outBatchNo
	 * 
	 * @param outBatchNo
	 */
	public void setOutBatchNo(String outBatchNo)
	{
		this.outBatchNo = outBatchNo;
	}

	/**
	 * 获取batchName
	 * 
	 * @return
	 */
	public String getBatchName()
	{
		return batchName;
	}

	/**
	 * 设置batchName
	 * 
	 * @param batchName
	 */
	public void setBatchName(String batchName)
	{
		this.batchName = batchName;
	}

	/**
	 * 获取batchRemark
	 * 
	 * @return
	 */
	public String getBatchRemark()
	{
		return batchRemark;
	}

	/**
	 * 设置batchRemark
	 * 
	 * @param batchRemark
	 */
	public void setBatchRemark(String batchRemark)
	{
		this.batchRemark = batchRemark;
	}

	/**
	 * 获取totalAmount
	 * 
	 * @return
	 */
	public Integer getTotalAmount()
	{
		return totalAmount;
	}

	/**
	 * 设置totalAmount
	 * 
	 * @param totalAmount
	 */
	public void setTotalAmount(Integer totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	/**
	 * 获取totalNum
	 * 
	 * @return
	 */
	public Integer getTotalNum()
	{
		return totalNum;
	}

	/**
	 * 设置totalNum
	 * 
	 * @param totalNum
	 */
	public void setTotalNum(Integer totalNum)
	{
		this.totalNum = totalNum;
	}

	/**
	 * 获取transferDetailList
	 * 
	 * @return
	 */
	public List<TransferDetailList> getTransferDetailList()
	{
		return transferDetailList;
	}

	/**
	 * 设置transferDetailList
	 * 
	 * @param transferDetailList
	 */
	public void setTransferDetailList(List<TransferDetailList> transferDetailList)
	{
		this.transferDetailList = transferDetailList;
	}
}
