package com.mizhousoft.weixin.mp.service;

import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.common.WXException;

/**
 * 微信公众号服务
 *
 * @version
 */
public interface WxMpService
{
	// 获取access_token
	String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

	/**
	 * 获取微信APP ID
	 * 
	 * @return
	 */
	String getAppId();

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

	/**
	 * 获取访问Token
	 * 
	 * @return
	 * @throws WXException
	 */
	String getAccessToken() throws WXException;

	/**
	 * 获取服务
	 * 
	 * @return
	 */
	WxMpUserService getWxMpUserService();

	/**
	 * 获取服务
	 * 
	 * @return
	 */
	WxMpMaterialService getWxMpMaterialService();

	/**
	 * 获取服务
	 * 
	 * @return
	 */
	WxMpFreePublishService getWxMpFreePublishService();

	/**
	 * 获取服务
	 * 
	 * @return
	 */
	WxMpTemplateMsgService getWxMpTemplateMsgService();

	/**
	 * 获取服务
	 * 
	 * @return
	 */
	WxMpMenuService getWxMpMenuService();

	/**
	 * 获取REST服务
	 * 
	 * @return
	 */
	RestClientService getRestClientService();
}
