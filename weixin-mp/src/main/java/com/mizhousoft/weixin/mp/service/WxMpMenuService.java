package com.mizhousoft.weixin.mp.service;

import com.mizhousoft.weixin.common.WXException;

/**
 * 菜单服务
 *
 * @version
 */
public interface WxMpMenuService
{
	String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/menu";

	/**
	 * 获取菜单
	 * 
	 * @return
	 * @throws WXException
	 */
	String getMenus() throws WXException;
}
