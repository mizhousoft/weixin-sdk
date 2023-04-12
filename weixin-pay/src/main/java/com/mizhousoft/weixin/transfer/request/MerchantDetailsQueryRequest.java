package com.mizhousoft.weixin.transfer.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO
 *
 * @version
 */
public class MerchantDetailsQueryRequest
{
	/**
	 * <pre>
	 * 字段名：商家明细单号
	 * 变量名：out_detail_no
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 * path商户系统内部区分转账批次单下不同转账明细单的唯一标识，要求此参数只能由数字、大小写字母组成
	 * 示例值：x23zy545Bd5436
	 * </pre>
	 */
	@JsonProperty(value = "out_detail_no")
	private String outDetailNo;

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
	 * 获取outDetailNo
	 * 
	 * @return
	 */
	public String getOutDetailNo()
	{
		return outDetailNo;
	}

	/**
	 * 设置outDetailNo
	 * 
	 * @param outDetailNo
	 */
	public void setOutDetailNo(String outDetailNo)
	{
		this.outDetailNo = outDetailNo;
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
}
