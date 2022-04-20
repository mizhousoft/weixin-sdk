package com.mizhousoft.weixin.mp.domain.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 响应消息
 *
 * @version
 */
@XmlRootElement(name = "xml")
public class MpResponseMessage
{
	@XmlElement(name = "ToUserName")
	protected String toUserName;

	@XmlElement(name = "FromUserName")
	protected String fromUserName;

	@XmlElement(name = "CreateTime")
	protected Long createTime;

	@XmlElement(name = "MsgType")
	protected String msgType;

	@XmlElement(name = "Encrypt")
	private String encrypt;

	@XmlElement(name = "MsgSignature")
	private String msgSignature;

	@XmlElement(name = "TimeStamp")
	private String timeStamp;

	@XmlElement(name = "Nonce")
	private String nonce;

	/**
	 * 获取toUserName
	 * 
	 * @return
	 */
	@XmlTransient
	public String getToUserName()
	{
		return toUserName;
	}

	/**
	 * 设置toUserName
	 * 
	 * @param toUserName
	 */
	public void setToUserName(String toUserName)
	{
		this.toUserName = toUserName;
	}

	/**
	 * 获取fromUserName
	 * 
	 * @return
	 */
	@XmlTransient
	public String getFromUserName()
	{
		return fromUserName;
	}

	/**
	 * 设置fromUserName
	 * 
	 * @param fromUserName
	 */
	public void setFromUserName(String fromUserName)
	{
		this.fromUserName = fromUserName;
	}

	/**
	 * 获取createTime
	 * 
	 * @return
	 */
	@XmlTransient
	public Long getCreateTime()
	{
		return createTime;
	}

	/**
	 * 设置createTime
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Long createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * 获取msgType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getMsgType()
	{
		return msgType;
	}

	/**
	 * 设置msgType
	 * 
	 * @param msgType
	 */
	public void setMsgType(String msgType)
	{
		this.msgType = msgType;
	}

	/**
	 * 获取encrypt
	 * 
	 * @return
	 */
	@XmlTransient
	public String getEncrypt()
	{
		return encrypt;
	}

	/**
	 * 设置encrypt
	 * 
	 * @param encrypt
	 */
	public void setEncrypt(String encrypt)
	{
		this.encrypt = encrypt;
	}

	/**
	 * 获取msgSignature
	 * 
	 * @return
	 */
	@XmlTransient
	public String getMsgSignature()
	{
		return msgSignature;
	}

	/**
	 * 设置msgSignature
	 * 
	 * @param msgSignature
	 */
	public void setMsgSignature(String msgSignature)
	{
		this.msgSignature = msgSignature;
	}

	/**
	 * 获取timeStamp
	 * 
	 * @return
	 */
	@XmlTransient
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
	@XmlTransient
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
}
