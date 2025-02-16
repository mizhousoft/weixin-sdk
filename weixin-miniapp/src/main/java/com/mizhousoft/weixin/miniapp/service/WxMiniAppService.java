package com.mizhousoft.weixin.miniapp.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.miniapp.model.WxJscode2SessionResult;

/**
 * 微信小程序服务
 *
 */
public interface WxMiniAppService
{
	// auth.code2Session
	String JSCODE_TO_SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

	/**
	 * 获取微信APP ID
	 * 
	 * @return
	 */
	String getAppId();

	/**
	 * 获取登录后的session信息
	 * 
	 * @param jsCode
	 * @return
	 * @throws WXException
	 */
	WxJscode2SessionResult jsCode2Session(String jsCode) throws WXException;

	/**
	 * 校验签名
	 * 
	 * @param timeStamp
	 * @param nonce
	 * @param signature
	 * @return
	 */
	boolean checkSignature(String timeStamp, String nonce, String signature);

	/**
	 * 解密数据
	 * 
	 * @param msgSignature
	 * @param timeStamp
	 * @param nonce
	 * @param postData
	 * @return
	 * @throws WXException
	 */
	String decryptMsg(String msgSignature, String timeStamp, String nonce, String postData) throws WXException;

	/**
	 * 加密消息
	 * 
	 * @param replyMsg
	 * @return
	 * @throws WXException
	 */
	String encryptMsg(String replyMsg) throws WXException;
}
