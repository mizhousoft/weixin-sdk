package com.mizhousoft.weixin.payment.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 订单请求
 *
 * @version
 */
public class WxPayOrderCreateRequest
{
	/**
	 * <pre>
	 * 字段名：应用ID
	 * 变量名：appid
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  由微信生成的应用ID，全局唯一。请求统一下单接口时请注意APPID的应用属性，例如公众号场景下，需使用应用属性为公众号的APPID
	 *  示例值：wxd678efh567hg6787
	 * </pre>
	 */
	@JsonProperty(value = "appid")
	protected String appId;

	/**
	 * <pre>
	 * 字段名：直连商户号
	 * 变量名：mchid
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  直连商户的商户号，由微信支付生成并下发。
	 *  示例值：1230000109
	 * </pre>
	 */
	@JsonProperty(value = "mchid")
	protected String mchId;

	/**
	 * <pre>
	 * 字段名：商品描述
	 * 变量名：description
	 * 是否必填：是
	 * 类型：string[1,127]
	 * 描述：
	 *  商品描述
	 *  示例值：Image形象店-深圳腾大-QQ公仔
	 * </pre>
	 */
	@JsonProperty(value = "description")
	protected String description;

	/**
	 * <pre>
	 * 字段名：商户订单号
	 * 变量名：out_trade_no
	 * 是否必填：是
	 * 类型：string[6,32]
	 * 描述：
	 *  商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一
	 *  示例值：1217752501201407033233368018
	 * </pre>
	 */
	@JsonProperty(value = "out_trade_no")
	protected String outTradeNo;

	/**
	 * <pre>
	 * 字段名：交易结束时间
	 * 变量名：time_expire
	 * 是否必填：是
	 * 类型：string[1,64]
	 * 描述：
	 *  订单失效时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
	 *  示例值：2018-06-08T10:34:56+08:00
	 * </pre>
	 */
	@JsonProperty(value = "time_expire")
	protected String timeExpire;

	/**
	 * <pre>
	 * 字段名：附加数据
	 * 变量名：attach
	 * 是否必填：否
	 * 类型：string[1,128]
	 * 描述：
	 *  附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
	 *  示例值：自定义数据
	 * </pre>
	 */
	@JsonProperty(value = "attach")
	protected String attach;

	/**
	 * <pre>
	 * 字段名：通知地址
	 * 变量名：notify_url
	 * 是否必填：是
	 * 类型：string[1,256]
	 * 描述：
	 *  通知URL必须为直接可访问的URL，不允许携带查询串，要求必须为https地址。
	 *  格式：URL
	 *  示例值：https://www.weixin.qq.com/wxpay/pay.php
	 * </pre>
	 */
	@JsonProperty(value = "notify_url")
	private String notifyUrl;

	/**
	 * <pre>
	 * 字段名：订单优惠标记
	 * 变量名：goods_tag
	 * 是否必填：否
	 * 类型：string[1,256]
	 * 描述：
	 *  订单优惠标记
	 *  示例值：WXG
	 * </pre>
	 */
	@JsonProperty(value = "goods_tag")
	private String goodsTag;

	/**
	 * <pre>
	 * 字段名：电子发票入口开放标识
	 * 变量名：support_fapiao
	 * 是否必填：否
	 * 类型：boolean
	 * 描述：传入true时，支付成功消息和支付详情页将出现开票入口。需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效。
	 * </pre>
	 */
	@JsonProperty(value = "support_fapiao")
	private Boolean supportFapiao;

	/**
	 * <pre>
	 * 字段名：订单金额
	 * 变量名：amount
	 * 是否必填：是
	 * 类型：object
	 * 描述：
	 *  订单金额信息
	 * </pre>
	 */
	@JsonProperty(value = "amount")
	private Amount amount;

	/**
	 * <pre>
	 * 字段名：支付者
	 * 变量名：payer
	 * 是否必填：是
	 * 类型：object
	 * 描述：
	 *  支付者信息
	 * </pre>
	 */
	@JsonProperty(value = "payer")
	private Payer payer;

	/**
	 * <pre>
	 * 字段名：优惠功能
	 * 变量名：detail
	 * 是否必填：否
	 * 类型：object
	 * 描述：
	 *  优惠功能
	 * </pre>
	 */
	@JsonProperty(value = "detail")
	private Discount discount;

	/**
	 * <pre>
	 * 字段名：场景信息
	 * 变量名：scene_info
	 * 是否必填：否
	 * 类型：object
	 * 描述：
	 *  支付场景描述
	 * </pre>
	 */
	@JsonProperty(value = "scene_info")
	private SceneInfo sceneInfo;

	/**
	 * <pre>
	 * 字段名：结算信息
	 * 变量名：settle_info
	 * 是否必填：否
	 * 类型：Object
	 * 描述：结算信息
	 * </pre>
	 */
	@JsonProperty(value = "settle_info")
	private SettleInfo settleInfo;

	public static class Payer
	{
		/**
		 * <pre>
		 * 字段名：用户标识
		 * 变量名：openid
		 * 是否必填：是
		 * 类型：string[1,128]
		 * 描述：
		 *  用户在直连商户appid下的唯一标识。
		 *  示例值：oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
		 * </pre>
		 */
		@JsonProperty(value = "openid")
		private String openId;

		/**
		 * 获取openId
		 * 
		 * @return
		 */
		public String getOpenId()
		{
			return openId;
		}

		/**
		 * 设置openId
		 * 
		 * @param openId
		 */
		public void setOpenId(String openId)
		{
			this.openId = openId;
		}
	}

	public static class Amount
	{
		/**
		 * <pre>
		 * 字段名：总金额
		 * 变量名：total
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  订单总金额，单位为分。
		 *  示例值：100
		 * </pre>
		 */
		@JsonProperty(value = "total")
		private Integer total;

		/**
		 * <pre>
		 * 字段名：币类型
		 * 变量名：currency
		 * 是否必填：否
		 * 类型：string[1,16]
		 * 描述：
		 *  CNY：人民币，境内商户号仅支持人民币。
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

	public static class SettleInfo
	{
		/**
		 * <pre>
		 * 字段名：是否指定分账
		 * 变量名：profit_sharing
		 * 是否必填：否
		 * 类型：boolean
		 * 描述：
		 *  是否指定分账
		 *  示例值：false
		 * </pre>
		 */
		@JsonProperty(value = "profit_sharing")
		private Boolean profitSharing;

		/**
		 * 获取profitSharing
		 * 
		 * @return
		 */
		public Boolean getProfitSharing()
		{
			return profitSharing;
		}

		/**
		 * 设置profitSharing
		 * 
		 * @param profitSharing
		 */
		public void setProfitSharing(Boolean profitSharing)
		{
			this.profitSharing = profitSharing;
		}
	}

	public static class SceneInfo
	{
		/**
		 * <pre>
		 * 字段名：用户终端IP
		 * 变量名：payer_client_ip
		 * 是否必填：是
		 * 类型：string[1,45]
		 * 描述：
		 *  用户的客户端IP，支持IPv4和IPv6两种格式的IP地址。
		 *  示例值：14.23.150.211
		 * </pre>
		 */
		@JsonProperty(value = "payer_client_ip")
		private String payerClientIp;

		/**
		 * <pre>
		 * 字段名：商户端设备号
		 * 变量名：device_id
		 * 是否必填：否
		 * 类型：string[1,32]
		 * 描述：
		 *  商户端设备号（门店号或收银设备ID）。
		 *  示例值：013467007045764
		 * </pre>
		 */
		@JsonProperty(value = "device_id")
		private String deviceId;

		/**
		 * <pre>
		 * 字段名：商户门店信息
		 * 变量名：store_info
		 * 是否必填：否
		 * 类型：object
		 * 描述：
		 *  商户门店信息
		 * </pre>
		 */
		@JsonProperty(value = "store_info")
		private StoreInfo storeInfo;

		/**
		 * <pre>
		 * 字段名：H5场景信息
		 * 变量名：h5_info
		 * 是否必填：否(H5支付必填)
		 * 类型：object
		 * 描述：
		 *  H5场景信息
		 * </pre>
		 */
		@JsonProperty(value = "h5_info")
		private H5Info h5Info;

		/**
		 * 获取payerClientIp
		 * 
		 * @return
		 */
		public String getPayerClientIp()
		{
			return payerClientIp;
		}

		/**
		 * 设置payerClientIp
		 * 
		 * @param payerClientIp
		 */
		public void setPayerClientIp(String payerClientIp)
		{
			this.payerClientIp = payerClientIp;
		}

		/**
		 * 获取deviceId
		 * 
		 * @return
		 */
		public String getDeviceId()
		{
			return deviceId;
		}

		/**
		 * 设置deviceId
		 * 
		 * @param deviceId
		 */
		public void setDeviceId(String deviceId)
		{
			this.deviceId = deviceId;
		}

		/**
		 * 获取storeInfo
		 * 
		 * @return
		 */
		public StoreInfo getStoreInfo()
		{
			return storeInfo;
		}

		/**
		 * 设置storeInfo
		 * 
		 * @param storeInfo
		 */
		public void setStoreInfo(StoreInfo storeInfo)
		{
			this.storeInfo = storeInfo;
		}

		/**
		 * 获取h5Info
		 * 
		 * @return
		 */
		public H5Info getH5Info()
		{
			return h5Info;
		}

		/**
		 * 设置h5Info
		 * 
		 * @param h5Info
		 */
		public void setH5Info(H5Info h5Info)
		{
			this.h5Info = h5Info;
		}
	}

	public static class StoreInfo
	{
		/**
		 * <pre>
		 * 字段名：门店编号
		 * 变量名：id
		 * 是否必填：是
		 * 类型：string[1,32]
		 * 描述：
		 *  商户侧门店编号
		 *  示例值：0001
		 * </pre>
		 */
		@JsonProperty(value = "id")
		private String id;

		/**
		 * <pre>
		 * 字段名：门店名称
		 * 变量名：name
		 * 是否必填：否
		 * 类型：string[1,256]
		 * 描述：
		 *  商户侧门店名称
		 *  示例值：腾讯大厦分店
		 * </pre>
		 */
		@JsonProperty(value = "name")
		private String name;

		/**
		 * <pre>
		 * 字段名：地区编码
		 * 变量名：area_code
		 * 是否必填：否
		 * 类型：string[1,32]
		 * 描述： 地区编码, <a href=
		"https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/ecommerce/applyments/chapter4_1.shtml">详细请见省市区编号对照表</a>。
		 * 示例值：440305
		 * </pre>
		 */
		@JsonProperty(value = "area_code")
		private String areaCode;

		/**
		 * <pre>
		 * 字段名：详细地址
		 * 变量名：address
		 * 是否必填：是
		 * 类型：string[1,512]
		 * 描述：
		 *  详细的商户门店地址
		 *  示例值：广东省深圳市南山区科技中一道10000号
		 * </pre>
		 */
		@JsonProperty(value = "address")
		private String address;

		/**
		 * 获取id
		 * 
		 * @return
		 */
		public String getId()
		{
			return id;
		}

		/**
		 * 设置id
		 * 
		 * @param id
		 */
		public void setId(String id)
		{
			this.id = id;
		}

		/**
		 * 获取name
		 * 
		 * @return
		 */
		public String getName()
		{
			return name;
		}

		/**
		 * 设置name
		 * 
		 * @param name
		 */
		public void setName(String name)
		{
			this.name = name;
		}

		/**
		 * 获取areaCode
		 * 
		 * @return
		 */
		public String getAreaCode()
		{
			return areaCode;
		}

		/**
		 * 设置areaCode
		 * 
		 * @param areaCode
		 */
		public void setAreaCode(String areaCode)
		{
			this.areaCode = areaCode;
		}

		/**
		 * 获取address
		 * 
		 * @return
		 */
		public String getAddress()
		{
			return address;
		}

		/**
		 * 设置address
		 * 
		 * @param address
		 */
		public void setAddress(String address)
		{
			this.address = address;
		}
	}

	public static class H5Info
	{
		/**
		 * <pre>
		 * 字段名：场景类型
		 * 变量名：type
		 * 是否必填：是
		 * 类型：string[1,32]
		 * 描述：
		 *  场景类型
		 *  示例值：iOS, Android, Wap
		 * </pre>
		 */
		@JsonProperty(value = "type")
		private String type;

		/**
		 * <pre>
		 * 字段名：应用名称
		 * 变量名：app_name
		 * 是否必填：否
		 * 类型：string[1,64]
		 * 描述：
		 *  应用名称
		 *  示例值：王者荣耀
		 * </pre>
		 */
		@JsonProperty(value = "app_name")
		private String appName;

		/**
		 * <pre>
		 * 字段名：网站URL
		 * 变量名：app_url
		 * 是否必填：否
		 * 类型：string[1,128]
		 * 描述：
		 *  网站URL
		 *  示例值：https://pay.qq.com
		 * </pre>
		 */
		@JsonProperty(value = "app_url")
		private String appUrl;

		/**
		 * <pre>
		 * 字段名：iOS平台BundleID
		 * 变量名：bundle_id
		 * 是否必填：否
		 * 类型：string[1,128]
		 * 描述：
		 *  iOS平台BundleID
		 *  示例值：com.tencent.wzryiOS
		 * </pre>
		 */
		@JsonProperty(value = "bundle_id")
		private String bundleId;

		/**
		 * <pre>
		 * 字段名：Android平台PackageName
		 * 变量名：package_name
		 * 是否必填：否
		 * 类型：string[1,128]
		 * 描述：
		 *  Android平台PackageName
		 *  示例值：com.tencent.tmgp.sgame
		 * </pre>
		 */
		@JsonProperty(value = "package_name")
		private String packageName;

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
		 * 获取appName
		 * 
		 * @return
		 */
		public String getAppName()
		{
			return appName;
		}

		/**
		 * 设置appName
		 * 
		 * @param appName
		 */
		public void setAppName(String appName)
		{
			this.appName = appName;
		}

		/**
		 * 获取appUrl
		 * 
		 * @return
		 */
		public String getAppUrl()
		{
			return appUrl;
		}

		/**
		 * 设置appUrl
		 * 
		 * @param appUrl
		 */
		public void setAppUrl(String appUrl)
		{
			this.appUrl = appUrl;
		}

		/**
		 * 获取bundleId
		 * 
		 * @return
		 */
		public String getBundleId()
		{
			return bundleId;
		}

		/**
		 * 设置bundleId
		 * 
		 * @param bundleId
		 */
		public void setBundleId(String bundleId)
		{
			this.bundleId = bundleId;
		}

		/**
		 * 获取packageName
		 * 
		 * @return
		 */
		public String getPackageName()
		{
			return packageName;
		}

		/**
		 * 设置packageName
		 * 
		 * @param packageName
		 */
		public void setPackageName(String packageName)
		{
			this.packageName = packageName;
		}
	}

	public static class Discount
	{
		/**
		 * <pre>
		 * 字段名：订单原价
		 * 变量名：cost_price
		 * 是否必填：否
		 * 类型：int
		 * 描述：
		 *  1、商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的交易金额。
		 *  2、当订单原价与支付金额不相等，则不享受优惠。
		 *  3、该字段主要用于防止同一张小票分多次支付，以享受多次优惠的情况，正常支付订单不必上传此参数。
		 *  示例值：608800
		 * </pre>
		 */
		@JsonProperty(value = "cost_price")
		private Integer costPrice;

		/**
		 * <pre>
		 * 字段名：商品小票ID
		 * 变量名：invoice_id
		 * 是否必填：否
		 * 类型：string[1,32]
		 * 描述：
		 *  商品小票ID
		 *  示例值：微信123
		 * </pre>
		 */
		@JsonProperty(value = "invoice_id")
		private String invoiceId;

		/**
		 * <pre>
		 * 字段名：单品列表
		 * 变量名：goods_detail
		 * 是否必填：否
		 * 类型：array
		 * 描述：
		 *  单品列表信息
		 *  条目个数限制：【1，6000】
		 * </pre>
		 */
		@JsonProperty(value = "goods_detail")
		private List<GoodsDetail> goodsDetails;

		/**
		 * 获取costPrice
		 * 
		 * @return
		 */
		public Integer getCostPrice()
		{
			return costPrice;
		}

		/**
		 * 设置costPrice
		 * 
		 * @param costPrice
		 */
		public void setCostPrice(Integer costPrice)
		{
			this.costPrice = costPrice;
		}

		/**
		 * 获取invoiceId
		 * 
		 * @return
		 */
		public String getInvoiceId()
		{
			return invoiceId;
		}

		/**
		 * 设置invoiceId
		 * 
		 * @param invoiceId
		 */
		public void setInvoiceId(String invoiceId)
		{
			this.invoiceId = invoiceId;
		}

		/**
		 * 获取goodsDetails
		 * 
		 * @return
		 */
		public List<GoodsDetail> getGoodsDetails()
		{
			return goodsDetails;
		}

		/**
		 * 设置goodsDetails
		 * 
		 * @param goodsDetails
		 */
		public void setGoodsDetails(List<GoodsDetail> goodsDetails)
		{
			this.goodsDetails = goodsDetails;
		}
	}

	public static class GoodsDetail
	{
		/**
		 * <pre>
		 * 字段名：商户侧商品编码
		 * 变量名：merchant_goods_id
		 * 是否必填：是
		 * 类型：string[1,32]
		 * 描述：
		 *  由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。
		 *  示例值：商品编码
		 * </pre>
		 */
		@JsonProperty(value = "merchant_goods_id")
		private String merchantGoodsId;

		/**
		 * <pre>
		 * 字段名：微信侧商品编码
		 * 变量名：wechatpay_goods_id
		 * 是否必填：否
		 * 类型：string[1,32]
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
		 * 类型：string[1,256]
		 * 描述：
		 *  商品的实际名称
		 *  示例值：iPhoneX 256G
		 * </pre>
		 */
		@JsonProperty(value = "goods_name")
		private String goodsName;

		/**
		 * <pre>
		 * 字段名：商品数量
		 * 变量名：quantity
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  用户购买的数量
		 *  示例值：1
		 * </pre>
		 */
		@JsonProperty(value = "quantity")
		private Integer quantity;

		/**
		 * <pre>
		 * 字段名：商品单价
		 * 变量名：unit_price
		 * 是否必填：是
		 * 类型：int
		 * 描述：
		 *  商品单价，单位为分
		 *  示例值：828800
		 * </pre>
		 */
		@JsonProperty(value = "unit_price")
		private Integer unitPrice;

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
		 * 获取quantity
		 * 
		 * @return
		 */
		public Integer getQuantity()
		{
			return quantity;
		}

		/**
		 * 设置quantity
		 * 
		 * @param quantity
		 */
		public void setQuantity(Integer quantity)
		{
			this.quantity = quantity;
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
	}

	/**
	 * 获取appId
	 * 
	 * @return
	 */
	public String getAppId()
	{
		return appId;
	}

	/**
	 * 设置appId
	 * 
	 * @param appId
	 */
	public void setAppId(String appId)
	{
		this.appId = appId;
	}

	/**
	 * 获取mchId
	 * 
	 * @return
	 */
	public String getMchId()
	{
		return mchId;
	}

	/**
	 * 设置mchId
	 * 
	 * @param mchId
	 */
	public void setMchId(String mchId)
	{
		this.mchId = mchId;
	}

	/**
	 * 获取description
	 * 
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * 设置description
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
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
	 * 获取timeExpire
	 * 
	 * @return
	 */
	public String getTimeExpire()
	{
		return timeExpire;
	}

	/**
	 * 设置timeExpire
	 * 
	 * @param timeExpire
	 */
	public void setTimeExpire(String timeExpire)
	{
		this.timeExpire = timeExpire;
	}

	/**
	 * 获取attach
	 * 
	 * @return
	 */
	public String getAttach()
	{
		return attach;
	}

	/**
	 * 设置attach
	 * 
	 * @param attach
	 */
	public void setAttach(String attach)
	{
		this.attach = attach;
	}

	/**
	 * 获取notifyUrl
	 * 
	 * @return
	 */
	public String getNotifyUrl()
	{
		return notifyUrl;
	}

	/**
	 * 设置notifyUrl
	 * 
	 * @param notifyUrl
	 */
	public void setNotifyUrl(String notifyUrl)
	{
		this.notifyUrl = notifyUrl;
	}

	/**
	 * 获取goodsTag
	 * 
	 * @return
	 */
	public String getGoodsTag()
	{
		return goodsTag;
	}

	/**
	 * 设置goodsTag
	 * 
	 * @param goodsTag
	 */
	public void setGoodsTag(String goodsTag)
	{
		this.goodsTag = goodsTag;
	}

	/**
	 * 获取supportFapiao
	 * 
	 * @return
	 */
	public Boolean getSupportFapiao()
	{
		return supportFapiao;
	}

	/**
	 * 设置supportFapiao
	 * 
	 * @param supportFapiao
	 */
	public void setSupportFapiao(Boolean supportFapiao)
	{
		this.supportFapiao = supportFapiao;
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
	 * 获取payer
	 * 
	 * @return
	 */
	public Payer getPayer()
	{
		return payer;
	}

	/**
	 * 设置payer
	 * 
	 * @param payer
	 */
	public void setPayer(Payer payer)
	{
		this.payer = payer;
	}

	/**
	 * 获取discount
	 * 
	 * @return
	 */
	public Discount getDiscount()
	{
		return discount;
	}

	/**
	 * 设置discount
	 * 
	 * @param discount
	 */
	public void setDiscount(Discount discount)
	{
		this.discount = discount;
	}

	/**
	 * 获取sceneInfo
	 * 
	 * @return
	 */
	public SceneInfo getSceneInfo()
	{
		return sceneInfo;
	}

	/**
	 * 设置sceneInfo
	 * 
	 * @param sceneInfo
	 */
	public void setSceneInfo(SceneInfo sceneInfo)
	{
		this.sceneInfo = sceneInfo;
	}

	/**
	 * 获取settleInfo
	 * 
	 * @return
	 */
	public SettleInfo getSettleInfo()
	{
		return settleInfo;
	}

	/**
	 * 设置settleInfo
	 * 
	 * @param settleInfo
	 */
	public void setSettleInfo(SettleInfo settleInfo)
	{
		this.settleInfo = settleInfo;
	}
}
