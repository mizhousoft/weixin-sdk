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
	 * 获取REST服务
	 * 
	 * @return
	 */
	RestClientService getRestClientService();
}
