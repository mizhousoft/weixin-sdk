package com.mizhousoft.weixin.cipher;

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
	private String serialNumber;

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
	 * 获取serialNumber
	 * 
	 * @return
	 */
	public String getSerialNumber()
	{
		return serialNumber;
	}

	/**
	 * 设置serialNumber
	 * 
	 * @param serialNumber
	 */
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"");
		if (timeStamp != null)
		{
			builder.append("timeStamp\":\"");
			builder.append(timeStamp);
			builder.append("\", \"");
		}
		if (nonce != null)
		{
			builder.append("nonce\":\"");
			builder.append(nonce);
			builder.append("\", \"");
		}
		if (signature != null)
		{
			builder.append("signature\":\"");
			builder.append(signature);
			builder.append("\", \"");
		}
		if (serialNumber != null)
		{
			builder.append("serialNumber\":\"");
			builder.append(serialNumber);
		}
		builder.append("\"}");
		return builder.toString();
	}
}
