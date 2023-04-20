package com.mizhousoft.weixin.cipher;

import com.mizhousoft.weixin.common.WXException;

/**
 * 敏感信息解密器
 *
 * @version
 */
public interface PrivacyDecryptor
{
	/**
	 * 解密并转换为字符串
	 *
	 * @param ciphertext 密文
	 * @return UTF-8编码的明文
	 */
	String decrypt(String ciphertext) throws WXException;
}
