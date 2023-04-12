package com.mizhousoft.weixin.transfer.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 批次查询请求
 *
 * @version
 */
public class WxBatchesQueryRequest
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
	 * 字段名：是否查询转账明细单
	 * 变量名：need_query_detail
	 * 是否必填：是
	 * 类型：boolean
	 * 描述：
	 *  query枚举值：
	 * true：是；
	 * false：否，默认否。
	 * 商户可选择是否查询指定状态的转账明细单，当转账批次单状态为“FINISHED”（已完成）时，才会返回满足条件的转账明细单
	 * 示例值：true
	 * </pre>
	 */
	@JsonProperty(value = "need_query_detail")
	private Boolean needQueryDetail;

	/**
	 * <pre>
	 * 字段名：请求资源起始位置
	 * 变量名：offset
	 * 是否必填：否
	 * 类型：int
	 * 描述：
	 *  query该次请求资源的起始位置，从0开始，默认值为0
	 * </pre>
	 */
	@JsonProperty(value = "offset")
	private Integer offset;

	/**
	 * <pre>
	 * 字段名：最大资源条数
	 * 变量名：limit
	 * 是否必填：否
	 * 类型：int
	 * 描述：
	 *  query该次请求可返回的最大明细条数，最小20条，最大100条，不传则默认20条。不足20条按实际条数返回
	 * 示例值：20
	 * </pre>
	 */
	@JsonProperty(value = "limit")
	private Integer limit;

	/**
	 * <pre>
	 * 字段名：明细状态
	 * 变量名：detail_status
	 * 是否必填：否
	 * 类型：string[1,32]
	 * 描述：
	 *  query查询指定状态的转账明细单，当need_query_detail为true时，该字段必填
	 * ALL:全部。需要同时查询转账成功和转账失败的明细单
	 * SUCCESS:转账成功。只查询转账成功的明细单
	 * FAIL:转账失败。只查询转账失败的明细单
	 * 示例值：FAIL
	 * </pre>
	 */
	@JsonProperty(value = "detail_status")
	private String detailStatus;

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
	 * 获取needQueryDetail
	 * 
	 * @return
	 */
	public Boolean getNeedQueryDetail()
	{
		return needQueryDetail;
	}

	/**
	 * 设置needQueryDetail
	 * 
	 * @param needQueryDetail
	 */
	public void setNeedQueryDetail(Boolean needQueryDetail)
	{
		this.needQueryDetail = needQueryDetail;
	}

	/**
	 * 获取offset
	 * 
	 * @return
	 */
	public Integer getOffset()
	{
		return offset;
	}

	/**
	 * 设置offset
	 * 
	 * @param offset
	 */
	public void setOffset(Integer offset)
	{
		this.offset = offset;
	}

	/**
	 * 获取limit
	 * 
	 * @return
	 */
	public Integer getLimit()
	{
		return limit;
	}

	/**
	 * 设置limit
	 * 
	 * @param limit
	 */
	public void setLimit(Integer limit)
	{
		this.limit = limit;
	}

	/**
	 * 获取detailStatus
	 * 
	 * @return
	 */
	public String getDetailStatus()
	{
		return detailStatus;
	}

	/**
	 * 设置detailStatus
	 * 
	 * @param detailStatus
	 */
	public void setDetailStatus(String detailStatus)
	{
		this.detailStatus = detailStatus;
	}
}
