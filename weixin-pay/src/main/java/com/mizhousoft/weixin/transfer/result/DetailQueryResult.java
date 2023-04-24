package com.mizhousoft.weixin.transfer.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 明细查询结果
 *
 */
public class DetailQueryResult
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
	private String mchId;

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
	 * 类型：string[1,64]
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
	private String appId;

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
	 * 字段名：明细状态
	 * 变量名：detail_status
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  枚举值：
	 * PROCESSING:转账中。正在处理中，转账结果尚未明确
	 * SUCCESS:转账成功
	 * FAIL:转账失败。需要确认失败原因后，再决定是否重新发起对该笔明细单的转账（并非整个转账批次单）
	 * 示例值：SUCCESS
	 * </pre>
	 */
	@JsonProperty(value = "detail_status")
	private String detailStatus;

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
	 * 字段名：明细失败原因
	 * 变量名：fail_reason
	 * 是否必填：否
	 * 类型：string[1,64]
	 * 描述：
	 *  如果转账失败则有失败原因
	 * ACCOUNT_FROZEN：账户冻结
	 * REAL_NAME_CHECK_FAIL：用户未实名
	 * NAME_NOT_CORRECT：用户姓名校验失败
	 * OPENID_INVALID：Openid校验失败
	 * TRANSFER_QUOTA_EXCEED：超过用户单笔收款额度
	 * DAY_RECEIVED_QUOTA_EXCEED：超过用户单日收款额度
	 * MONTH_RECEIVED_QUOTA_EXCEED：超过用户单月收款额度
	 * DAY_RECEIVED_COUNT_EXCEED：超过用户单日收款次数
	 * PRODUCT_AUTH_CHECK_FAIL：产品权限校验失败
	 * OVERDUE_CLOSE：转账关闭
	 * ID_CARD_NOT_CORRECT：用户身份证校验失败
	 * ACCOUNT_NOT_EXIST：用户账户不存在
	 * TRANSFER_RISK：转账存在风险
	 * REALNAME_ACCOUNT_RECEIVED_QUOTA_EXCEED：用户账户收款受限，请引导用户在微信支付查看详情
	 * RECEIVE_ACCOUNT_NOT_PERMMIT：未配置该用户为转账收款人
	 * PAYER_ACCOUNT_ABNORMAL：商户账户付款受限，可前往商户平台-违约记录获取解除功能限制指引
	 * PAYEE_ACCOUNT_ABNORMAL：用户账户收款异常，请引导用户完善其在微信支付的身份信息以继续收款
	 * 示例值：ACCOUNT_FROZEN
	 * </pre>
	 */
	@JsonProperty(value = "fail_reason")
	private String failReason;

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
	private String openId;

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
	 * <pre>
	 * 字段名：转账发起时间
	 * 变量名：initiate_time
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  转账发起的时间，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示北京时间2015年05月20日13点29分35秒
	 * 示例值：2015-05-20T13:29:35.120+08:00
	 * </pre>
	 */
	@JsonProperty(value = "initiate_time")
	private String initiateTime;

	/**
	 * <pre>
	 * 字段名：明细更新时间
	 * 变量名：update_time
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  明细最后一次状态变更的时间，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示北京时间2015年05月20日13点29分35秒
	 * 示例值：2015-05-20T13:29:35.120+08:00
	 * </pre>
	 */
	@JsonProperty(value = "update_time")
	private String updateTime;

	/**
	 * 获取mchId
	 * @return
	 */
	public String getMchId()
	{
		return mchId;
	}

	/**
	 * 设置mchId
	 * @param mchId
	 */
	public void setMchId(String mchId)
	{
		this.mchId = mchId;
	}

	/**
	 * 获取outBatchNo
	 * @return
	 */
	public String getOutBatchNo()
	{
		return outBatchNo;
	}

	/**
	 * 设置outBatchNo
	 * @param outBatchNo
	 */
	public void setOutBatchNo(String outBatchNo)
	{
		this.outBatchNo = outBatchNo;
	}

	/**
	 * 获取batchId
	 * @return
	 */
	public String getBatchId()
	{
		return batchId;
	}

	/**
	 * 设置batchId
	 * @param batchId
	 */
	public void setBatchId(String batchId)
	{
		this.batchId = batchId;
	}

	/**
	 * 获取appId
	 * @return
	 */
	public String getAppId()
	{
		return appId;
	}

	/**
	 * 设置appId
	 * @param appId
	 */
	public void setAppId(String appId)
	{
		this.appId = appId;
	}

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
	 * 获取detailId
	 * @return
	 */
	public String getDetailId()
	{
		return detailId;
	}

	/**
	 * 设置detailId
	 * @param detailId
	 */
	public void setDetailId(String detailId)
	{
		this.detailId = detailId;
	}

	/**
	 * 获取detailStatus
	 * @return
	 */
	public String getDetailStatus()
	{
		return detailStatus;
	}

	/**
	 * 设置detailStatus
	 * @param detailStatus
	 */
	public void setDetailStatus(String detailStatus)
	{
		this.detailStatus = detailStatus;
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
	 * 获取failReason
	 * @return
	 */
	public String getFailReason()
	{
		return failReason;
	}

	/**
	 * 设置failReason
	 * @param failReason
	 */
	public void setFailReason(String failReason)
	{
		this.failReason = failReason;
	}

	/**
	 * 获取openId
	 * @return
	 */
	public String getOpenId()
	{
		return openId;
	}

	/**
	 * 设置openId
	 * @param openId
	 */
	public void setOpenId(String openId)
	{
		this.openId = openId;
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

	/**
	 * 获取initiateTime
	 * @return
	 */
	public String getInitiateTime()
	{
		return initiateTime;
	}

	/**
	 * 设置initiateTime
	 * @param initiateTime
	 */
	public void setInitiateTime(String initiateTime)
	{
		this.initiateTime = initiateTime;
	}

	/**
	 * 获取updateTime
	 * @return
	 */
	public String getUpdateTime()
	{
		return updateTime;
	}

	/**
	 * 设置updateTime
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime)
	{
		this.updateTime = updateTime;
	}
}
