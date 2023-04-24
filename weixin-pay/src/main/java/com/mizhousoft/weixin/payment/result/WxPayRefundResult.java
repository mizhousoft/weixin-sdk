package com.mizhousoft.weixin.payment.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 退款结果
 *
 */
public class WxPayRefundResult
{
	/**
	 * <pre>
	 * 字段名：微信支付退款号
	 * 变量名：refund_id
	 * 是否必填：是
	 * 类型：string[1, 32]
	 * 描述：
	 *  微信支付退款号
	 *  示例值：50000000382019052709732678859
	 * </pre>
	 */
	@JsonProperty(value = "refund_id")
	private String refundId;

	/**
	 * <pre>
	 * 字段名：商户退款单号
	 * 变量名：out_refund_no
	 * 是否必填：是
	 * 类型：string[1, 64]
	 * 描述：
	 *  商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
	 *  示例值：1217752501201407033233368018
	 * </pre>
	 */
	@JsonProperty(value = "out_refund_no")
	private String outRefundNo;

	/**
	 * <pre>
	 * 字段名：微信支付订单号
	 * 变量名：transaction_id
	 * 是否必填：是
	 * 类型：string[1, 32]
	 * 描述：
	 *  微信支付交易订单号
	 *  示例值：1217752501201407033233368018
	 * </pre>
	 */
	@JsonProperty(value = "transaction_id")
	private String transactionId;

	/**
	 * <pre>
	 * 字段名：商户订单号
	 * 变量名：out_trade_no
	 * 是否必填：是
	 * 类型：string[1, 32]
	 * 描述：
	 *  原支付交易对应的商户订单号
	 *  示例值：1217752501201407033233368018
	 * </pre>
	 */
	@JsonProperty(value = "out_trade_no")
	private String outTradeNo;

	/**
	 * <pre>
	 * 字段名：退款渠道
	 * 变量名：channel
	 * 是否必填：是
	 * 类型：string[1, 16]
	 * 描述：
	 *  枚举值：
	 *  ORIGINAL—原路退款
	 *  BALANCE—退回到余额
	 *  OTHER_BALANCE—原账户异常退到其他余额账户
	 *  OTHER_BANKCARD—原银行卡异常退到其他银行卡
	 *  示例值：ORIGINAL
	 * </pre>
	 */
	@JsonProperty(value = "channel")
	private String channel;

	/**
	 * <pre>
	 * 字段名：退款入账账户
	 * 变量名：user_received_account
	 * 是否必填：是
	 * 类型：string[1, 64]
	 * 描述：
	 *  取当前退款单的退款入账方，有以下几种情况：
	 *  1）退回银行卡：{银行名称}{卡类型}{卡尾号}
	 *  2）退回支付用户零钱:支付用户零钱
	 *  3）退还商户:商户基本账户商户结算银行账户
	 *  4）退回支付用户零钱通:支付用户零钱通
	 *  示例值：招商银行信用卡0403
	 * </pre>
	 */
	@JsonProperty(value = "user_received_account")
	private String userReceivedAccount;

	/**
	 * <pre>
	 * 字段名：退款成功时间
	 * 变量名：success_time
	 * 是否必填：是
	 * 类型：string[1, 64]
	 * 描述：
	 *  退款成功时间，当退款状态为退款成功时有返回。
	 *  示例值：2020-12-01T16:18:12+08:00
	 * </pre>
	 */
	@JsonProperty(value = "success_time")
	private String successTime;

	/**
	 * <pre>
	 * 字段名：退款创建时间
	 * 变量名：create_time
	 * 是否必填：是
	 * 类型：string[1, 64]
	 * 描述：
	 *  退款受理时间
	 *  示例值：2020-12-01T16:18:12+08:00
	 * </pre>
	 */
	@JsonProperty(value = "create_time")
	private String createTime;

	/**
	 * <pre>
	 * 字段名：退款状态
	 * 变量名：status
	 * 是否必填：是
	 * 类型：string[1, 32]
	 * 描述：
	 *  退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。
	 *  枚举值：
	 *  SUCCESS：退款成功
	 *  CLOSED：退款关闭
	 *  PROCESSING：退款处理中
	 *  ABNORMAL：退款异常
	 *  示例值：SUCCESS
	 * </pre>
	 */
	@JsonProperty(value = "status")
	private String status;

	/**
	 * <pre>
	 * 字段名：资金账户
	 * 变量名：funds_account
	 * 是否必填：否
	 * 类型：string[1, 32]
	 * 描述：
	 *  退款所使用资金对应的资金账户类型
	 *  枚举值：
	 *  UNSETTLED : 未结算资金
	 *  AVAILABLE : 可用余额
	 *  UNAVAILABLE : 不可用余额
	 *  OPERATION : 运营户
	 *  BASIC : 基本账户（含可用余额和不可用余额）
	 *  示例值：UNSETTLED
	 * </pre>
	 */
	@JsonProperty(value = "funds_account")
	private String fundsAccount;

	/**
	 * <pre>
	 * 字段名：金额信息
	 * 变量名：amount
	 * 是否必填：是
	 * 类型：object
	 * 描述：
	 *  金额详细信息
	 * </pre>
	 */
	@JsonProperty(value = "amount")
	private Amount amount;

	/**
	 * <pre>
	 * 字段名：优惠退款信息
	 * 变量名：promotion_detail
	 * 是否必填：否
	 * 类型：array
	 * 描述：
	 *  优惠退款信息
	 * </pre>
	 */
	@JsonProperty(value = "promotion_detail")
	private List<PromotionDetail> promotionDetail;

	public static class Amount
	{
		/**
		 * <pre>
		 * 字段名：订单金额
		 * 变量名：total
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  订单总金额，单位为分
		 *  示例值：100
		 * </pre>
		 */
		@JsonProperty(value = "total")
		private Integer total;

		/**
		 * <pre>
		 * 字段名：退款金额
		 * 变量名：refund
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  退款标价金额，单位为分，可以做部分退款
		 *  示例值：100
		 * </pre>
		 */
		@JsonProperty(value = "refund")
		private Integer refund;

		/**
		 * <pre>
		 * 字段名：退款出资账户及金额
		 * 变量名：from
		 * 是否必填：否
		 * 类型：array
		 * 描述：
		 *  退款出资的账户类型及金额信息
		 * </pre>
		 */
		@JsonProperty(value = "from")
		private List<From> from;

		/**
		 * <pre>
		 * 字段名：用户支付金额
		 * 变量名：payer_total
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  现金支付金额，单位为分，只能为整数
		 *  示例值：90
		 * </pre>
		 */
		@JsonProperty(value = "payer_total")
		private Integer payerTotal;

		/**
		 * <pre>
		 * 字段名：用户退款金额
		 * 变量名：payer_refund
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  退款给用户的金额，不包含所有优惠券金额
		 *  示例值：90
		 * </pre>
		 */
		@JsonProperty(value = "payer_refund")
		private Integer payerRefund;

		/**
		 * <pre>
		 * 字段名：应结退款金额
		 * 变量名：settlement_refund
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  去掉非充值代金券退款金额后的退款金额，单位为分，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
		 *  示例值：100
		 * </pre>
		 */
		@JsonProperty(value = "settlement_refund")
		private Integer settlementRefund;

		/**
		 * <pre>
		 * 字段名：应结订单金额
		 * 变量名：settlement_total
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  应结订单金额=订单金额-免充值代金券金额，应结订单金额<=订单金额，单位为分
		 *  示例值：100
		 * </pre>
		 */
		@JsonProperty(value = "settlement_total")
		private Integer settlementTotal;

		/**
		 * <pre>
		 * 字段名：优惠退款金额
		 * 变量名：discount_refund
		 * 是否必填：否
		 * 类型：int
		 * 描述：
		 *  优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠，单位为分
		 *  示例值：10
		 * </pre>
		 */
		@JsonProperty(value = "discount_refund")
		private Integer discountRefund;

		/**
		 * <pre>
		 * 字段名：币类型
		 * 变量名：currency
		 * 是否必填：是
		 * 类型：string[1, 16]
		 * 描述：
		 *  符合ISO 4217标准的三位字母代码，目前只支持人民币：CNY。
		 *  示例值：CNY
		 * </pre>
		 */
		@JsonProperty(value = "currency")
		private String currency;

		/**
		 * 获取total
		 * 
		 * @return
		 */
		public Integer getTotal()
		{
			return total;
		}

		/**
		 * 设置total
		 * 
		 * @param total
		 */
		public void setTotal(Integer total)
		{
			this.total = total;
		}

		/**
		 * 获取refund
		 * 
		 * @return
		 */
		public Integer getRefund()
		{
			return refund;
		}

		/**
		 * 设置refund
		 * 
		 * @param refund
		 */
		public void setRefund(Integer refund)
		{
			this.refund = refund;
		}

		/**
		 * 获取from
		 * 
		 * @return
		 */
		public List<From> getFrom()
		{
			return from;
		}

		/**
		 * 设置from
		 * 
		 * @param from
		 */
		public void setFrom(List<From> from)
		{
			this.from = from;
		}

		/**
		 * 获取payerTotal
		 * 
		 * @return
		 */
		public Integer getPayerTotal()
		{
			return payerTotal;
		}

		/**
		 * 设置payerTotal
		 * 
		 * @param payerTotal
		 */
		public void setPayerTotal(Integer payerTotal)
		{
			this.payerTotal = payerTotal;
		}

		/**
		 * 获取payerRefund
		 * 
		 * @return
		 */
		public Integer getPayerRefund()
		{
			return payerRefund;
		}

		/**
		 * 设置payerRefund
		 * 
		 * @param payerRefund
		 */
		public void setPayerRefund(Integer payerRefund)
		{
			this.payerRefund = payerRefund;
		}

		/**
		 * 获取settlementRefund
		 * 
		 * @return
		 */
		public Integer getSettlementRefund()
		{
			return settlementRefund;
		}

		/**
		 * 设置settlementRefund
		 * 
		 * @param settlementRefund
		 */
		public void setSettlementRefund(Integer settlementRefund)
		{
			this.settlementRefund = settlementRefund;
		}

		/**
		 * 获取settlementTotal
		 * 
		 * @return
		 */
		public Integer getSettlementTotal()
		{
			return settlementTotal;
		}

		/**
		 * 设置settlementTotal
		 * 
		 * @param settlementTotal
		 */
		public void setSettlementTotal(Integer settlementTotal)
		{
			this.settlementTotal = settlementTotal;
		}

		/**
		 * 获取discountRefund
		 * 
		 * @return
		 */
		public Integer getDiscountRefund()
		{
			return discountRefund;
		}

		/**
		 * 设置discountRefund
		 * 
		 * @param discountRefund
		 */
		public void setDiscountRefund(Integer discountRefund)
		{
			this.discountRefund = discountRefund;
		}

		/**
		 * 获取currency
		 * 
		 * @return
		 */
		public String getCurrency()
		{
			return currency;
		}

		/**
		 * 设置currency
		 * 
		 * @param currency
		 */
		public void setCurrency(String currency)
		{
			this.currency = currency;
		}
	}

	public static class PromotionDetail
	{
		/**
		 * <pre>
		 * 字段名：券ID
		 * 变量名：promotion_id
		 * 是否必填：是
		 * 类型：string[1, 32]
		 * 描述：
		 *  券或者立减优惠id
		 *  示例值：109519
		 * </pre>
		 */
		@JsonProperty(value = "promotion_id")
		private String promotionId;

		/**
		 * <pre>
		 * 字段名：优惠范围
		 * 变量名：scope
		 * 是否必填：是
		 * 类型：string[1, 32]
		 * 描述：
		 *  枚举值：
		 *  GLOBAL：全场代金券
		 *  SINGLE：单品优惠
		 *  示例值：SINGLE
		 * </pre>
		 */
		@JsonProperty(value = "scope")
		private String scope;

		/**
		 * <pre>
		 * 字段名：优惠类型
		 * 变量名：type
		 * 是否必填：是
		 * 类型：string[1, 32]
		 * 描述：
		 *  枚举值：
		 *  COUPON：代金券，需要走结算资金的充值型代金券
		 *  DISCOUNT：优惠券，不走结算资金的免充值型优惠券
		 *  示例值：DISCOUNT
		 * </pre>
		 */
		@JsonProperty(value = "type")
		private String type;

		/**
		 * <pre>
		 * 字段名：优惠券面额
		 * 变量名：amount
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  用户享受优惠的金额（优惠券面额=微信出资金额+商家出资金额+其他出资方金额 ），单位为分
		 *  示例值：5
		 * </pre>
		 */
		@JsonProperty(value = "amount")
		private Integer amount;

		/**
		 * <pre>
		 * 字段名：优惠退款金额
		 * 变量名：refund_amount
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  优惠退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为用户支付的现金，说明详见代金券或立减优惠，单位为分
		 *  示例值：100
		 * </pre>
		 */
		@JsonProperty(value = "refund_amount")
		private Integer refundAmount;

		/**
		 * <pre>
		 * 字段名：商品列表
		 * 变量名：goods_detail
		 * 是否必填：否
		 * 类型：array
		 * 描述：
		 *  优惠商品发生退款时返回商品信息
		 * </pre>
		 */
		@JsonProperty(value = "goods_detail")
		private List<GoodsDetail> goodsDetail;

		/**
		 * 获取promotionId
		 * 
		 * @return
		 */
		public String getPromotionId()
		{
			return promotionId;
		}

		/**
		 * 设置promotionId
		 * 
		 * @param promotionId
		 */
		public void setPromotionId(String promotionId)
		{
			this.promotionId = promotionId;
		}

		/**
		 * 获取scope
		 * 
		 * @return
		 */
		public String getScope()
		{
			return scope;
		}

		/**
		 * 设置scope
		 * 
		 * @param scope
		 */
		public void setScope(String scope)
		{
			this.scope = scope;
		}

		/**
		 * 获取type
		 * 
		 * @return
		 */
		public String getType()
		{
			return type;
		}

		/**
		 * 设置type
		 * 
		 * @param type
		 */
		public void setType(String type)
		{
			this.type = type;
		}

		/**
		 * 获取amount
		 * 
		 * @return
		 */
		public Integer getAmount()
		{
			return amount;
		}

		/**
		 * 设置amount
		 * 
		 * @param amount
		 */
		public void setAmount(Integer amount)
		{
			this.amount = amount;
		}

		/**
		 * 获取refundAmount
		 * 
		 * @return
		 */
		public Integer getRefundAmount()
		{
			return refundAmount;
		}

		/**
		 * 设置refundAmount
		 * 
		 * @param refundAmount
		 */
		public void setRefundAmount(Integer refundAmount)
		{
			this.refundAmount = refundAmount;
		}

		/**
		 * 获取goodsDetail
		 * 
		 * @return
		 */
		public List<GoodsDetail> getGoodsDetail()
		{
			return goodsDetail;
		}

		/**
		 * 设置goodsDetail
		 * 
		 * @param goodsDetail
		 */
		public void setGoodsDetail(List<GoodsDetail> goodsDetail)
		{
			this.goodsDetail = goodsDetail;
		}
	}

	public static class From
	{
		/**
		 * <pre>
		 * 字段名：出资账户类型
		 * 变量名：account
		 * 是否必填：是
		 * 类型：string[1, 32]
		 * 描述：
		 *  下面枚举值多选一。
		 *  枚举值：
		 *  AVAILABLE : 可用余额
		 *  UNAVAILABLE : 不可用余额
		 *  示例值：AVAILABLE
		 * </pre>
		 */
		@JsonProperty(value = "account")
		private String account;

		/**
		 * <pre>
		 * 字段名：出资金额
		 * 变量名：amount
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  对应账户出资金额
		 *  示例值：444
		 * </pre>
		 */
		@JsonProperty(value = "amount")
		private Integer amount;

		/**
		 * 获取account
		 * 
		 * @return
		 */
		public String getAccount()
		{
			return account;
		}

		/**
		 * 设置account
		 * 
		 * @param account
		 */
		public void setAccount(String account)
		{
			this.account = account;
		}

		/**
		 * 获取amount
		 * 
		 * @return
		 */
		public Integer getAmount()
		{
			return amount;
		}

		/**
		 * 设置amount
		 * 
		 * @param amount
		 */
		public void setAmount(Integer amount)
		{
			this.amount = amount;
		}
	}

	public static class GoodsDetail
	{
		/**
		 * <pre>
		 * 字段名：商户侧商品编码
		 * 变量名：merchant_goods_id
		 * 是否必填：是
		 * 类型：string[1, 32]
		 * 描述：
		 *  由半角的大小写字母、数字、中划线、下划线中的一种或几种组成
		 *  示例值：1217752501201407033233368018
		 * </pre>
		 */
		@JsonProperty(value = "merchant_goods_id")
		private String merchantGoodsId;

		/**
		 * <pre>
		 * 字段名：微信侧商品编码
		 * 变量名：wechatpay_goods_id
		 * 是否必填：否
		 * 类型：string[1, 32]
		 * 描述：
		 *  微信支付定义的统一商品编号（没有可不传）
		 *  示例值：1001
		 * </pre>
		 */
		@JsonProperty(value = "wechatpay_goods_id")
		private String wechatpayGoodsId;

		/**
		 * <pre>
		 * 字段名：商品名称
		 * 变量名：goods_name
		 * 是否必填：否
		 * 类型：string[1, 256]
		 * 描述：
		 *  商品的实际名称
		 *  示例值：iPhone6s 16G
		 * </pre>
		 */
		@JsonProperty(value = "goods_name")
		private String goodsName;

		/**
		 * <pre>
		 * 字段名：商品单价
		 * 变量名：unit_price
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  商品单价金额，单位为分
		 *  示例值：528800
		 * </pre>
		 */
		@JsonProperty(value = "unit_price")
		private Integer unitPrice;

		/**
		 * <pre>
		 * 字段名：商品退款金额
		 * 变量名：refund_amount
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  商品退款金额，单位为分
		 *  示例值：528800
		 * </pre>
		 */
		@JsonProperty(value = "refund_amount")
		private Integer refundAmount;

		/**
		 * <pre>
		 * 字段名：商品退货数量
		 * 变量名：refund_quantity
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  单品的退款数量，单位为分
		 *  示例值：1
		 * </pre>
		 */
		@JsonProperty(value = "refund_quantity")
		private Integer refundQuantity;

		/**
		 * 获取merchantGoodsId
		 * 
		 * @return
		 */
		public String getMerchantGoodsId()
		{
			return merchantGoodsId;
		}

		/**
		 * 设置merchantGoodsId
		 * 
		 * @param merchantGoodsId
		 */
		public void setMerchantGoodsId(String merchantGoodsId)
		{
			this.merchantGoodsId = merchantGoodsId;
		}

		/**
		 * 获取wechatpayGoodsId
		 * 
		 * @return
		 */
		public String getWechatpayGoodsId()
		{
			return wechatpayGoodsId;
		}

		/**
		 * 设置wechatpayGoodsId
		 * 
		 * @param wechatpayGoodsId
		 */
		public void setWechatpayGoodsId(String wechatpayGoodsId)
		{
			this.wechatpayGoodsId = wechatpayGoodsId;
		}

		/**
		 * 获取goodsName
		 * 
		 * @return
		 */
		public String getGoodsName()
		{
			return goodsName;
		}

		/**
		 * 设置goodsName
		 * 
		 * @param goodsName
		 */
		public void setGoodsName(String goodsName)
		{
			this.goodsName = goodsName;
		}

		/**
		 * 获取unitPrice
		 * 
		 * @return
		 */
		public Integer getUnitPrice()
		{
			return unitPrice;
		}

		/**
		 * 设置unitPrice
		 * 
		 * @param unitPrice
		 */
		public void setUnitPrice(Integer unitPrice)
		{
			this.unitPrice = unitPrice;
		}

		/**
		 * 获取refundAmount
		 * 
		 * @return
		 */
		public Integer getRefundAmount()
		{
			return refundAmount;
		}

		/**
		 * 设置refundAmount
		 * 
		 * @param refundAmount
		 */
		public void setRefundAmount(Integer refundAmount)
		{
			this.refundAmount = refundAmount;
		}

		/**
		 * 获取refundQuantity
		 * 
		 * @return
		 */
		public Integer getRefundQuantity()
		{
			return refundQuantity;
		}

		/**
		 * 设置refundQuantity
		 * 
		 * @param refundQuantity
		 */
		public void setRefundQuantity(Integer refundQuantity)
		{
			this.refundQuantity = refundQuantity;
		}
	}

	/**
	 * 获取refundId
	 * 
	 * @return
	 */
	public String getRefundId()
	{
		return refundId;
	}

	/**
	 * 设置refundId
	 * 
	 * @param refundId
	 */
	public void setRefundId(String refundId)
	{
		this.refundId = refundId;
	}

	/**
	 * 获取outRefundNo
	 * 
	 * @return
	 */
	public String getOutRefundNo()
	{
		return outRefundNo;
	}

	/**
	 * 设置outRefundNo
	 * 
	 * @param outRefundNo
	 */
	public void setOutRefundNo(String outRefundNo)
	{
		this.outRefundNo = outRefundNo;
	}

	/**
	 * 获取transactionId
	 * 
	 * @return
	 */
	public String getTransactionId()
	{
		return transactionId;
	}

	/**
	 * 设置transactionId
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
	}

	/**
	 * 获取outTradeNo
	 * 
	 * @return
	 */
	public String getOutTradeNo()
	{
		return outTradeNo;
	}

	/**
	 * 设置outTradeNo
	 * 
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo)
	{
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 获取channel
	 * 
	 * @return
	 */
	public String getChannel()
	{
		return channel;
	}

	/**
	 * 设置channel
	 * 
	 * @param channel
	 */
	public void setChannel(String channel)
	{
		this.channel = channel;
	}

	/**
	 * 获取userReceivedAccount
	 * 
	 * @return
	 */
	public String getUserReceivedAccount()
	{
		return userReceivedAccount;
	}

	/**
	 * 设置userReceivedAccount
	 * 
	 * @param userReceivedAccount
	 */
	public void setUserReceivedAccount(String userReceivedAccount)
	{
		this.userReceivedAccount = userReceivedAccount;
	}

	/**
	 * 获取successTime
	 * 
	 * @return
	 */
	public String getSuccessTime()
	{
		return successTime;
	}

	/**
	 * 设置successTime
	 * 
	 * @param successTime
	 */
	public void setSuccessTime(String successTime)
	{
		this.successTime = successTime;
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
	 * 获取status
	 * 
	 * @return
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * 设置status
	 * 
	 * @param status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * 获取fundsAccount
	 * 
	 * @return
	 */
	public String getFundsAccount()
	{
		return fundsAccount;
	}

	/**
	 * 设置fundsAccount
	 * 
	 * @param fundsAccount
	 */
	public void setFundsAccount(String fundsAccount)
	{
		this.fundsAccount = fundsAccount;
	}

	/**
	 * 获取amount
	 * 
	 * @return
	 */
	public Amount getAmount()
	{
		return amount;
	}

	/**
	 * 设置amount
	 * 
	 * @param amount
	 */
	public void setAmount(Amount amount)
	{
		this.amount = amount;
	}

	/**
	 * 获取promotionDetail
	 * 
	 * @return
	 */
	public List<PromotionDetail> getPromotionDetail()
	{
		return promotionDetail;
	}

	/**
	 * 设置promotionDetail
	 * 
	 * @param promotionDetail
	 */
	public void setPromotionDetail(List<PromotionDetail> promotionDetail)
	{
		this.promotionDetail = promotionDetail;
	}
}
