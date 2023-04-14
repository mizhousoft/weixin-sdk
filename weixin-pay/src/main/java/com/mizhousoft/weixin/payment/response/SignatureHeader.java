package com.mizhousoft.weixin.payment.response;

/**
 * SignatureHeader
 *
 * @version
 */
public class SignatureHeader
{
	/**
	 * 时间戳
	 */
	private String timeStamp;

	/**
	 * 随机串
	 */
	private String nonce;

	/**
	 * 已签名字符串
	 */
	private String signature;

	/**
	 * 证书序列号
	 */
	private String serial;

	/**
	 * 获取timeStamp
	 * 
	 * @return
	 */
	public String getTimeStamp()
	{
		return timeStamp;
	}

	/**
	 * 设置timeStamp
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(String timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	/**
	 * 获取nonce
	 * 
	 * @return
	 */
	public String getNonce()
	{
		return nonce;
	}

	/**
	 * 设置nonce
	 * 
	 * @param nonce
	 */
	public void setNonce(String nonce)
	{
		this.nonce = nonce;
	}

	/**
	 * 获取signature
	 * 
	 * @return
	 */
	public String getSignature()
	{
		return signature;
	}

	/**
	 * 设置signature
	 * 
	 * @param signature
	 */
	public void setSignature(String signature)
	{
		this.signature = signature;
	}

	/**
	 * 获取serial
	 * 
	 * @return
	 */
	public String getSerial()
	{
		return serial;
	}

	/**
	 * 设置serial
	 * 
	 * @param serial
	 */
	public void setSerial(String serial)
	{
		this.serial = serial;
	}
}
