package com.mizhousoft.weixin.transfer.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 明细查询请求
 *
 * @version
 */
public class WxDetailQueryRequest
{
	/**
	 * <pre>
	 * 字段名：微信批次单号
	 * 变量名：batch_id
	 * 是否必填：是
	 * 类型：string[1,64]
	 * 描述：
	 *  path微信批次单号，微信商家转账系统返回的唯一标识
	 * 示例值：1030000071100999991182020050700019480001
	 * </pre>
	 */
	@JsonProperty(value = "batch_id")
	private String batchId;

	/**
	 * <pre>
	 * 字段名：微信明细单号
	 * 变量名：detail_id
	 * 是否必填：是
	 * 类型：string[1,64]
	 * 描述：
	 *  path微信支付系统内部区分转账批次单下不同转账明细单的唯一标识
	 * 示例值：1040000071100999991182020050700019500100
	 * </pre>
	 */
	@JsonProperty(value = "detail_id")
	private String detailId;

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
	 * 获取detailId
	 * 
	 * @return
	 */
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
}
