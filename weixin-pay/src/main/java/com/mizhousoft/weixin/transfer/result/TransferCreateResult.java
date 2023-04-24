package com.mizhousoft.weixin.transfer.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 转账创建结果
 *
 */
public class TransferCreateResult
{
	/**
	 * <pre>
	 * 字段名：商家批次单号
	 * 变量名：out_batch_no
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  商户系统内部的商家批次单号，在商户系统内部唯一
	 * 示例值：plfk2020042013
	 * </pre>
	 */
	@JsonProperty(value = "out_batch_no")
	private String outBatchNo;

	/**
	 * <pre>
	 * 字段名：微信批次单号
	 * 变量名：batch_id
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  微信批次单号，微信商家转账系统返回的唯一标识
	 * 示例值：1030000071100999991182020050700019480001
	 * </pre>
	 */
	@JsonProperty(value = "batch_id")
	private String batchId;

	/**
	 * <pre>
	 * 字段名：批次创建时间
	 * 变量名：create_time
	 * 是否必填：否
	 * 类型：string[1,32]
	 * 描述：
	 *  批次受理成功时返回，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示北京时间2015年05月20日13点29分35秒
	 * 示例值：2015-05-20T13:29:35.120+08:00
	 * </pre>
	 */
	@JsonProperty(value = "create_time")
	private String createTime;

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
	 * 获取batchId
	 * 
	 * @return
	 */
	public String getBatchId()
	{
		return batchId;
	}

	/**
	 * 设置batchId
	 * 
	 * @param batchId
	 */
	public void setBatchId(String batchId)
	{
		this.batchId = batchId;
	}

	/**
	 * 获取createTime
	 * 
	 * @return
	 */
	public String getCreateTime()
	{
		return createTime;
	}

	/**
	 * 设置createTime
	 * 
	 * @param createTime
	 */
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}
}
