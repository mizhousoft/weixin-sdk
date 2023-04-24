package com.mizhousoft.weixin.cipher;

import java.util.Map;

import com.mizhousoft.weixin.common.WXException;

/**
 * 验证器
 *
 */
public interface WxPayVerifier
{
	/**
	 * 验证返回是否合法
	 * 
	 * @param headers
	 * @param body
	 * @return
	 * @throws WXException
	 */
	boolean validate(Map<String, String> headers, String body) throws WXException;

	/**
	 * 验证是否合法
	 * 
	 * @param serialNumber
	 * @param bytes
	 * @param signature
	 * @return
	 * @throws WXException
	 */
	boolean verify(String serialNumber, byte[] bytes, String signature) throws WXException;
}
