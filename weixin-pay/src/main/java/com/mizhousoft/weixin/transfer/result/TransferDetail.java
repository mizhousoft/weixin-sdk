package com.mizhousoft.weixin.transfer.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO
 *
 * @version
 */
public class TransferDetail
{
	/**
	 * <pre>
	 * 字段名：微信明细单号
	 * 变量名：detail_id
	 * 是否必填：是
	 * 类型：string[1,64]
	 * 描述：
	 *  微信支付系统内部区分转账批次单下不同转账明细单的唯一标识
	 * 示例值：1040000071100999991182020050700019500100
	 * </pre>
	 */
	@JsonProperty(value = "detail_id")
	private String detailId;

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
	 * 字段名：明细状态
	 * 变量名：detail_status
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  枚举值：
	 * PROCESSING：转账中。正在处理中，转账结果尚未明确
	 * SUCCESS：转账成功
	 * FAIL：转账失败。需要确认失败原因后，再决定是否重新发起对该笔明细单的转账（并非整个转账批次单）
	 * 示例值：SUCCESS
	 * </pre>
	 */
	@JsonProperty(value = "detail_status")
	private String detailStatus;

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
