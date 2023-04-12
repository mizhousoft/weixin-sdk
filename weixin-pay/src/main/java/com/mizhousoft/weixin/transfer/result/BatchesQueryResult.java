package com.mizhousoft.weixin.transfer.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO
 *
 * @version
 */
public class BatchesQueryResult
{
	/**
	 * <pre>
	 * 字段名：最大资源条数
	 * 变量名：limit
	 * 是否必填：否
	 * 类型：int
	 * 描述：
	 *  query该次请求可返回的最大资源（转账明细单）条数，最小20条，最大100条，不传则默认20条。不足20条按实际条数返回
	 * 示例值：20
	 * </pre>
	 */
	@JsonProperty(value = "limit")
	private Integer limit;

	/**
	 * <pre>
	 * 字段名：请求资源起始位置
	 * 变量名：transfer_batch
	 * 是否必填：否
	 * 类型：int
	 * 描述：
	 *  query该次请求资源（转账明细单）的起始位置，从0开始，转账明细单列表为空时不返回
	 * 示例值：1
	 * </pre>
	 */
	@JsonProperty(value = "offset")
	private Integer offset;

	/**
	 * <pre>
	 * 字段名：转账批次单
	 * 变量名：transfer_batch
	 * 是否必填：是
	 * 类型：object
	 * 描述：
	 *  转账批次单基本信息
	 * </pre>
	 */
	@JsonProperty(value = "transfer_batch")
	private TransferBatch transferBatch;

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
	private List<TransferDetail> transferDetailList;

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
	 * 获取transferBatch
	 * 
	 * @return
	 */
	public TransferBatch getTransferBatch()
	{
		return transferBatch;
	}

	/**
	 * 设置transferBatch
	 * 
	 * @param transferBatch
	 */
	public void setTransferBatch(TransferBatch transferBatch)
	{
		this.transferBatch = transferBatch;
	}

	/**
	 * 获取transferDetailList
	 * 
	 * @return
	 */
	public List<TransferDetail> getTransferDetailList()
	{
		return transferDetailList;
	}

	/**
	 * 设置transferDetailList
	 * 
	 * @param transferDetailList
	 */
	public void setTransferDetailList(List<TransferDetail> transferDetailList)
	{
		this.transferDetailList = transferDetailList;
	}
}
