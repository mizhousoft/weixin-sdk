package com.mizhousoft.weixin.payment.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 订单创建响应
 *
 * @version
 */
public class WxPayOrderCreateResponse
{
	/**
	 * <pre>
	 * 字段名：预支付交易会话标识（APP支付、JSAPI支付 会返回）
	 * 变量名：prepay_id
	 * 是否必填：是
	 * 类型：string[1,64]
	 * 描述：
	 *  预支付交易会话标识。用于后续接口调用中使用，该值有效期为2小时
	 *  示例值：wx201410272009395522657a690389285100
	 * </pre>
	 */
	@JsonProperty(value = "prepay_id")
	private String prepayId;

	/**
	 * <pre>
	 * 字段名：支付跳转链接（H5支付 会返回）
	 * 变量名：h5_url
	 * 是否必填：是
	 * 类型：string[1,512]
	 * 描述：
	 *  h5_url为拉起微信支付收银台的中间页面，可通过访问该url来拉起微信客户端，完成支付，h5_url的有效期为5分钟。
	 *  示例值：https://wx.tenpay.com/cgi-bin/mmpayweb-bin/checkmweb?prepay_id=wx2016121516420242444321ca0631331346&package=1405458241
	 * </pre>
	 */
	@JsonProperty(value = "h5_url")
	private String h5Url;

	/**
	 * <pre>
	 * 字段名：二维码链接（NATIVE支付 会返回）
	 * 变量名：h5_url
	 * 是否必填：是
	 * 类型：string[1,512]
	 * 描述：
	 *  此URL用于生成支付二维码，然后提供给用户扫码支付。
	 *  注意：code_url并非固定值，使用时按照URL格式转成二维码即可。
	 *  示例值：weixin://wxpay/bizpayurl/up?pr=NwY5Mz9&groupid=00
	 * </pre>
	 */
	@JsonProperty(value = "code_url")
	private String codeUrl;

	/**
	 * 获取prepayId
	 * 
	 * @return
	 */
	public String getPrepayId()
	{
		return prepayId;
	}

	/**
	 * 设置prepayId
	 * 
	 * @param prepayId
	 */
	public void setPrepayId(String prepayId)
	{
		this.prepayId = prepayId;
	}

	/**
	 * 获取h5Url
	 * 
	 * @return
	 */
	public String getH5Url()
	{
		return h5Url;
	}

	/**
	 * 设置h5Url
	 * 
	 * @param h5Url
	 */
	public void setH5Url(String h5Url)
	{
		this.h5Url = h5Url;
	}

	/**
	 * 获取codeUrl
	 * 
	 * @return
	 */
	public String getCodeUrl()
	{
		return codeUrl;
	}

	/**
	 * 设置codeUrl
	 * 
	 * @param codeUrl
	 */
	public void setCodeUrl(String codeUrl)
	{
		this.codeUrl = codeUrl;
	}
}
