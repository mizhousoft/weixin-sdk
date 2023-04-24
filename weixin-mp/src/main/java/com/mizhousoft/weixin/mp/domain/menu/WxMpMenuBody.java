package com.mizhousoft.weixin.mp.domain.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 菜单结果
 *
 */
public class WxMpMenuBody
{
	@JsonProperty("menu")
	private WxMpMenu menu;

	/**
	 * 获取menu
	 * 
	 * @return
	 */
	public WxMpMenu getMenu()
	{
		return menu;
	}

	/**
	 * 设置menu
	 * 
	 * @param menu
	 */
	public void setMenu(WxMpMenu menu)
	{
		this.menu = menu;
	}
}
