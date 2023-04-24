package com.mizhousoft.weixin.mp.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.user.WxMpUser;

/**
 * 公众号用户服务
 *
 */
public interface WxMpUserService
{
	String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/user";

	/**
	 * 获取用户信息
	 * 
	 * @param openid
	 * @return
	 * @throws WXException
	 */
	WxMpUser userInfo(String openid) throws WXException;

	/**
	 * 获取用户信息
	 * 
	 * @param openid
	 * @param lang
	 * @return
	 * @throws WXException
	 */
	WxMpUser userInfo(String openid, String lang) throws WXException;
}
