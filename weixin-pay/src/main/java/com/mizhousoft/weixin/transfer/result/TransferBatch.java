package com.mizhousoft.weixin.transfer.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO
 *
 * @version
 */
public class TransferBatch
{
	/**
	 * <pre>
	 * 字段名：商户号
	 * 变量名：mchid
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  微信支付分配的商户号
	 * 示例值：1900001109
	 * </pre>
	 */
	@JsonProperty(value = "mchid")
	private String mchid;

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
	 * 字段名：批次状态
	 * 变量名：batch_status
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  枚举值：
	 * WAIT_PAY：待付款，商户员工确认付款阶段
	 * ACCEPTED:已受理。批次已受理成功，若发起批量转账的30分钟后，转账批次单仍处于该状态，可能原因是商户账户余额不足等。商户可查询账户资金流水，若该笔转账批次单的扣款已经发生，则表示批次已经进入转账中，请再次查单确认
	 * PROCESSING:转账中。已开始处理批次内的转账明细单
	 * FINISHED：已完成。批次内的所有转账明细单都已处理完成
	 * CLOSED：已关闭。可查询具体的批次关闭原因确认
	 * 示例值：ACCEPTED
	 * </pre>
	 */
	@JsonProperty(value = "batch_status")
	private String batchStatus;

	/**
	 * <pre>
	 * 字段名：批次类型
	 * 变量名：batch_type
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  枚举值：
	 * API：API方式发起
	 * WEB：页面方式发起
	 * 示例值：API
	 * </pre>
	 */
	@JsonProperty(value = "batch_type")
	private String batchType;

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
	 * 字段名：批次关闭原因
	 * 变量名：close_reason
	 * 是否必填：否
	 * 类型：string[1,64]
	 * 描述：
	 *  如果批次单状态为“CLOSED”（已关闭），则有关闭原因
	 * MERCHANT_REVOCATION：商户主动撤销
	 * OVERDUE_CLOSE：系统超时关闭
	 * 示例值：OVERDUE_CLOSE
	 * </pre>
	 */
	@JsonProperty(value = "close_reason")
	private String closeReason;

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
	 * <pre>
	 * 字段名：批次更新时间
	 * 变量名：update_time
	 * 是否必填：否
	 * 类型：string[1,32]
	 * 描述：
	 *  批次最近一次状态变更的时间，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示北京时间2015年05月20日13点29分35秒
	 * 示例值：2015-05-20T13:29:35.120+08:00
	 * </pre>
	 */
	@JsonProperty(value = "update_time")
	private String updateTime;

	/**
	 * <pre>
	 * 字段名：转账成功金额
	 * 变量名：success_amount
	 * 是否必填：否
	 * 类型：int
	 * 描述：
	 *  转账成功的金额，单位为分。当批次状态为“PROCESSING”（转账中）时，转账成功金额随时可能变化
	 * 示例值：3900000
	 * </pre>
	 */
	@JsonProperty(value = "success_amount")
	private Integer successAmount;

	/**
	 * <pre>
	 * 字段名：转账成功笔数
	 * 变量名：success_num
	 * 是否必填：否
	 * 类型：int
	 * 描述：
	 *  转账成功的笔数。当批次状态为“PROCESSING”（转账中）时，转账成功笔数随时可能变化
	 * 示例值：199
	 * </pre>
	 */
	@JsonProperty(value = "success_num")
	private Integer successNum;

	/**
	 * <pre>
	 * 字段名：转账失败金额
	 * 变量名：fail_amount
	 * 是否必填：否
	 * 类型：int
	 * 描述：
	 *  转账失败的金额，单位为分
	 * 示例值：100000
	 * </pre>
	 */
	@JsonProperty(value = "fail_amount")
	private Integer failAmount;

	/**
	 * <pre>
	 * 字段名：转账失败笔数
	 * 变量名：fail_num
	 * 是否必填：否
	 * 类型：int
	 * 描述：
	 *  转账失败的笔数
	 * 示例值：1
	 * </pre>
	 */
	@JsonProperty(value = "fail_num")
	private Integer failNum;

	/**
	 * 获取mchid
	 * 
	 * @return
	 */
	public String getMchid()
	{
		return mchid;
	}

	/**
	 * 设置mchid
	 * 
	 * @param mchid
	 */
	public void setMchid(String mchid)
	{
		this.mchid = mchid;
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
	 * 获取batchStatus
	 * 
	 * @return
	 */
	public String getBatchStatus()
	{
		return batchStatus;
	}

	/**
	 * 设置batchStatus
	 * 
	 * @param batchStatus
	 */
	public void setBatchStatus(String batchStatus)
	{
		this.batchStatus = batchStatus;
	}

	/**
	 * 获取batchType
	 * 
	 * @return
	 */
	public String getBatchType()
	{
		return batchType;
	}

	/**
	 * 设置batchType
	 * 
	 * @param batchType
	 */
	public void setBatchType(String batchType)
	{
		this.batchType = batchType;
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
	 * 获取closeReason
	 * 
	 * @return
	 */
	public String getCloseReason()
	{
		return closeReason;
	}

	/**
	 * 设置closeReason
	 * 
	 * @param closeReason
	 */
	public void setCloseReason(String closeReason)
	{
		this.closeReason = closeReason;
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

	/**
	 * 获取updateTime
	 * 
	 * @return
	 */
	public String getUpdateTime()
	{
		return updateTime;
	}

	/**
	 * 设置updateTime
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime)
	{
		this.updateTime = updateTime;
	}

	/**
	 * 获取successAmount
	 * 
	 * @return
	 */
	public Integer getSuccessAmount()
	{
		return successAmount;
	}

	/**
	 * 设置successAmount
	 * 
	 * @param successAmount
	 */
	public void setSuccessAmount(Integer successAmount)
	{
		this.successAmount = successAmount;
	}

	/**
	 * 获取successNum
	 * 
	 * @return
	 */
	public Integer getSuccessNum()
	{
		return successNum;
	}

	/**
	 * 设置successNum
	 * 
	 * @param successNum
	 */
	public void setSuccessNum(Integer successNum)
	{
		this.successNum = successNum;
	}

	/**
	 * 获取failAmount
	 * 
	 * @return
	 */
	public Integer getFailAmount()
	{
		return failAmount;
	}

	/**
	 * 设置failAmount
	 * 
	 * @param failAmount
	 */
	public void setFailAmount(Integer failAmount)
	{
		this.failAmount = failAmount;
	}

	/**
	 * 获取failNum
	 * 
	 * @return
	 */
	public Integer getFailNum()
	{
		return failNum;
	}

	/**
	 * 设置failNum
	 * 
	 * @param failNum
	 */
	public void setFailNum(Integer failNum)
	{
		this.failNum = failNum;
	}
}
