package com.mizhousoft.weixin.cipher;

import com.mizhousoft.weixin.common.WXException;

/**
 * 加密器
 *
 */
public interface PrivacyEncryptor
{
	/**
	 * 加密并转换为字符串
	 * 
	 * @param plaintext
	 * @return
	 * @throws WXException
	 */
	String encrypt(String plaintext) throws WXException;

	/**
	 * 获取加密使用公钥所属证书的证书序列号，可设置到请求的 HTTP 头部 Wechatpay-Serial
	 *
	 * @return 证书序列号
	 */
	String getPaySerialNumber();
}
