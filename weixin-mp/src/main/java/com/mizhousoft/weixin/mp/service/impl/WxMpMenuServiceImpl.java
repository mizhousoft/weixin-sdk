package com.mizhousoft.weixin.mp.service.impl;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.service.WxMpMenuService;
import com.mizhousoft.weixin.mp.service.WxMpService;

/**
 * 菜单服务
 *
 * @version
 */
public class WxMpMenuServiceImpl implements WxMpMenuService
{
	// WxMpService
	private WxMpService wxMpService;

	/**
	 * 构造函数
	 *
	 * @param wxMpService
	 */
	public WxMpMenuServiceImpl(WxMpService wxMpService)
	{
		super();
		this.wxMpService = wxMpService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMenus() throws WXException
	{
		String url = API_URL_PREFIX + "/get";

		String accessToken = wxMpService.getAccessToken();

		url = url + "?access_token=" + accessToken;
		String data = wxMpService.getRestClientService().getForObject(url, String.class);

		return data;
	}
}
