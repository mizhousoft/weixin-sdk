package com.mizhousoft.weixin.mp.service.impl;

import com.mizhousoft.weixin.common.WXException;

/**
 * WxMpMenuServiceImpl Test
 *
 * @version
 */
public class WxMpMenuServiceImplTest extends BaseWxMpServiceText
{
	public void getMenus() throws WXException
	{
		String menu = wxMpService.getWxMpMenuService().getMenus();

		System.out.println(menu);
	}
}
