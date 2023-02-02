package com.mizhousoft.weixin.mp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.menu.ButtonMenu;
import com.mizhousoft.weixin.mp.domain.menu.WxMpMenu;
import com.mizhousoft.weixin.mp.domain.menu.WxMpMenuBody;

/**
 * WxMpMenuServiceImpl Test
 *
 * @version
 */
public class WxMpMenuServiceImplTest extends BaseWxMpServiceText
{
	@Test
	public void getMenus() throws WXException
	{
		WxMpMenuBody menu = wxMpService.getWxMpMenuService().getMenus();

		System.out.println(menu);
	}

	@Test
	public void createMenu() throws WXException
	{
		ButtonMenu buttonMenu = new ButtonMenu();
		buttonMenu.setType("view");
		buttonMenu.setName("汽修资料");
		buttonMenu.setUrl("https://saas.mizhousoft.com/home");

		List<ButtonMenu> buttons = new ArrayList<>(2);
		buttons.add(buttonMenu);

		WxMpMenu menu = new WxMpMenu();
		menu.setButtons(buttons);

		wxMpService.getWxMpMenuService().createMenu(menu);
	}
}
