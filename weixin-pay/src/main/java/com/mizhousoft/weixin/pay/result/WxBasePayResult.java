package com.mizhousoft.weixin.pay.result;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 支付结果
 *
 * 
 */
public abstract class WxBasePayResult
{
	// 返回状态码
	@XmlElement(name = "return_code")
	private String returnCode;

	// 返回信息
	@XmlElement(name = "return_msg")
	private String returnMsg;

	// 业务结果
	@XmlElement(name = "result_code")
	private String resultCode;

	// 错误代码
	@XmlElement(name = "err_code")
	private String errCode;

	// 错误代码描述
	@XmlElement(name = "err_code_des")
	private String errCodeDes;

	// 应用APPID
	@XmlElement(name = "appid")
	private String appid;

	// 商户号
	@XmlElement(name = "mch_id")
	private String mchId;

	// 随机字符串
	@XmlElement(name = "nonce_str")
	private String nonceStr;

	// 签名
	@XmlElement(name = "sign")
	private String sign;

	/**
	 * 获取returnCode
	 * 
	 * @return
	 */
	@XmlTransient
	public String getReturnCode()
	{
		return returnCode;
	}

	/**
	 * 设置returnCode
	 * 
	 * @param returnCode
	 */
	public void setReturnCode(String returnCode)
	{
		this.returnCode = returnCode;
	}

	/**
	 * 获取returnMsg
	 * 
	 * @return
	 */
	@XmlTransient
	public String getReturnMsg()
	{
		return returnMsg;
	}

	/**
	 * 设置returnMsg
	 * 
	 * @param returnMsg
	 */
	public void setReturnMsg(String returnMsg)
	{
		this.returnMsg = returnMsg;
	}

	/**
	 * 获取resultCode
	 * 
	 * @return
	 */
	@XmlTransient
	public String getResultCode()
	{
		return resultCode;
	}

	/**
	 * 设置resultCode
	 * 
	 * @param resultCode
	 */
	public void setResultCode(String resultCode)
	{
		this.resultCode = resultCode;
	}

	/**
	 * 获取errCode
	 * 
	 * @return
	 */
	@XmlTransient
	public String getErrCode()
	{
		return errCode;
	}

	/**
	 * 设置errCode
	 * 
	 * @param errCode
	 */
	public void setErrCode(String errCode)
	{
		this.errCode = errCode;
	}

	/**
	 * 获取errCodeDes
	 * 
	 * @return
	 */
	@XmlTransient
	public String getErrCodeDes()
	{
		return errCodeDes;
	}

	/**
	 * 设置errCodeDes
	 * 
	 * @param errCodeDes
	 */
	public void setErrCodeDes(String errCodeDes)
	{
		this.errCodeDes = errCodeDes;
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
}
