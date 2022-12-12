package com.mizhousoft.weixin.mp.domain.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WxMpMenus
 *
 * @version
 */
public class WxMpMenu
{
	@JsonProperty("button")
	private List<ButtonMenu> buttons;

	/**
	 * 获取buttons
	 * 
	 * @return
	 */
	public List<ButtonMenu> getButtons()
	{
		return buttons;
	}

	/**
	 * 设置buttons
	 * 
	 * @param buttons
	 */
	public void setButtons(List<ButtonMenu> buttons)
	{
		this.buttons = buttons;
	}
}
