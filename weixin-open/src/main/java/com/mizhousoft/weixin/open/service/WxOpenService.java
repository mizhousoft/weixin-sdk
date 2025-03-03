package com.mizhousoft.weixin.open.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.open.model.WxOAuth2AccessToken;
import com.mizhousoft.weixin.open.model.WxOpenUser;

/**
 * 微信开放服务
 *
 */
public interface WxOpenService
{
	String OUTH2_CUST_CONNECT_CODE_URL = "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s&href=%s#wechat_redirect";

	String OUTH2_CONNECT_CODE_URL = "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";

	String OUTH2_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s";

	String OUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

	/**
	 * 获取微信APP ID
	 * 
	 * @return
	 */
	String getAppId();

	/**
	 * 构建二维码URL
	 * 
	 * @param redirectUrl
	 * @param state
	 * @param isCustomStyle
	 * @return
	 */
	String buildConnectCodeUrl(String redirectUrl, String state, boolean isCustomStyle);

	/**
	 * 根据code获取WxMpOAuth2AccessToken
	 * 
	 * @param code
	 * @return
	 * @throws WXException
	 */
	WxOAuth2AccessToken oauth2getAccessToken(String code) throws WXException;

	/**
	 * 获取用户信息
	 * 
	 * @param oAuth2AccessToken
	 * @param lang
	 * @return
	 * @throws WXException
	 */
	WxOpenUser oauth2getUserInfo(WxOAuth2AccessToken oAuth2AccessToken, String lang) throws WXException;

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
