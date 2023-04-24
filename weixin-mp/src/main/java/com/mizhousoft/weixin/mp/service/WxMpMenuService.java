package com.mizhousoft.weixin.mp.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.menu.WxMpMenu;
import com.mizhousoft.weixin.mp.domain.menu.WxMpMenuBody;

/**
 * 菜单服务
 *
 */
public interface WxMpMenuService
{
	String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/menu";

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 * @return
	 * @throws WXException
	 */
	String createMenu(WxMpMenu menu) throws WXException;

	/**
	 * 获取菜单
	 * 
	 * @return
	 * @throws WXException
	 */
	WxMpMenuBody getMenus() throws WXException;
}
