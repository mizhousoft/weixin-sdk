package com.mizhousoft.weixin.cipher;

import com.mizhousoft.weixin.common.WXException;

/**
 * 签名
 *
 */
public interface Signer
{
	/**
	 * 签名
	 * 
	 * @param message
	 * @return
	 * @throws WXException
	 */
	String sign(String message) throws WXException;
}
