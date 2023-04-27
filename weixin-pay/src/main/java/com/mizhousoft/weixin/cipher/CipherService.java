package com.mizhousoft.weixin.cipher;

import com.mizhousoft.weixin.common.WXException;

/**
 * 密文服务
 *
 */
public interface CipherService
{
	/**
	 * 解密结果
	 * 
	 * @param associatedData
	 * @param nonce
	 * @param ciphertext
	 * @return
	 * @throws WXException
	 */
	String decryptResult(String associatedData, String nonce, String ciphertext) throws WXException;

	/**
	 * 解密并转换为字符串
	 *
	 * @param ciphertext 密文
	 * @return UTF-8编码的明文
	 */
	String decryptSensitiveField(String ciphertext) throws WXException;

	/**
	 * 加密并转换为字符串
	 * 
	 * @param plaintext
	 * @return
	 * @throws WXException
	 */
	String encryptSensitiveField(String plaintext) throws WXException;

	/**
	 * 签名
	 * 
	 * @param message
	 * @return
	 * @throws WXException
	 */
	String sign(String message) throws WXException;

	/**
	 * 验证
	 * 
	 * @param serialNumber
	 * @param message
	 * @param signature
	 * @return
	 * @throws WXException
	 */
	boolean verify(String serialNumber, String message, String signature) throws WXException;
}
