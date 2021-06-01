package com.mizhousoft.weixin.pay.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 支付请求基类
 *
 * @version
 */
public abstract class WxBasePayRequest
{
	// 应用ID
	@XmlElement(name = "appid")
	protected String appid;

	// 商户号
	@XmlElement(name = "mch_id")
	protected String mchId;

	// 随机字符串
	@XmlElement(name = "nonce_str")
	protected String nonceStr;

	// 签名
	@XmlElement(name = "sign")
	protected String sign;

	// 签名类型
	@XmlElement(name = "sign_type")
	protected String signType;

	/**
	 * 获取可以忽略的签名参数
	 * 
	 * @return
	 */
	public String[] getIgnoredParamsForSign()
	{
		return new String[0];
	}

	/**
	 * 获取appid
	 * 
	 * @return
	 */
	@XmlTransient
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
	 * 获取mchId
	 * 
	 * @return
	 */
	@XmlTransient
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
	 * 获取nonceStr
	 * 
	 * @return
	 */
	@XmlTransient
	public String getNonceStr()
	{
		return nonceStr;
	}

	/**
	 * 设置nonceStr
	 * 
	 * @param nonceStr
	 */
	public void setNonceStr(String nonceStr)
	{
		this.nonceStr = nonceStr;
	}

	/**
	 * 获取sign
	 * 
	 * @return
	 */
	@XmlTransient
	public String getSign()
	{
		return sign;
	}

	/**
	 * 设置sign
	 * 
	 * @param sign
	 */
	public void setSign(String sign)
	{
		this.sign = sign;
	}

	/**
	 * 获取signType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getSignType()
	{
		return signType;
	}

	/**
	 * 设置signType
	 * 
	 * @param signType
	 */
	public void setSignType(String signType)
	{
		this.signType = signType;
	}
}
