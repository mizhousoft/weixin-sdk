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
}
