package com.mizhousoft.weixin.mp.service.impl;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.WxError;
import com.mizhousoft.weixin.mp.domain.menu.WxMpMenu;
import com.mizhousoft.weixin.mp.domain.menu.WxMpMenuBody;
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
	public String createMenu(WxMpMenu menu) throws WXException
	{
		try
		{
			String body = JSONUtils.toJSONString(menu);

			String accessToken = wxMpService.getAccessToken();

			String url = API_URL_PREFIX + "/create";
			url = url + "?access_token=" + accessToken;

			String data = wxMpService.getRestClientService().postForObject(url, body, String.class);

			WxError result = JSONUtils.parse(data, WxError.class);

			if (!"ok".equals(result.getErrorMsg()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return null;
		}
		catch (JSONException e)
		{
			throw new WXException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpMenuBody getMenus() throws WXException
	{
		String url = API_URL_PREFIX + "/create";

		String accessToken = wxMpService.getAccessToken();

		url = url + "?access_token=" + accessToken;

		WxMpMenuBody data = wxMpService.getRestClientService().getForObject(url, WxMpMenuBody.class);

		return data;
	}

}
