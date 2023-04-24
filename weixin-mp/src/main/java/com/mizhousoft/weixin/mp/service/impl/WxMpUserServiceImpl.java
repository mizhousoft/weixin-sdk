package com.mizhousoft.weixin.mp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.user.WxMpUser;
import com.mizhousoft.weixin.mp.service.WxMpService;
import com.mizhousoft.weixin.mp.service.WxMpUserService;

/**
 * 公众号用户服务
 *
 */
public class WxMpUserServiceImpl implements WxMpUserService
{
	private static final Logger LOG = LoggerFactory.getLogger(WxMpUserServiceImpl.class);

	private WxMpService wxMpService;

	/**
	 * 构造函数
	 *
	 * @param wxMpService
	 */
	public WxMpUserServiceImpl(WxMpService wxMpService)
	{
		super();
		this.wxMpService = wxMpService;
	}

	@Override
	public WxMpUser userInfo(String openid) throws WXException
	{
		return this.userInfo(openid, null);
	}

	@Override
	public WxMpUser userInfo(String openid, String lang) throws WXException
	{
		String url = API_URL_PREFIX + "/info";
		lang = lang == null ? "zh_CN" : lang;

		String accessToken = wxMpService.getAccessToken();

		url = url + "?openid=" + openid + "&lang=" + lang + "&access_token=" + accessToken;
		String data = wxMpService.getRestClientService().getForObject(url, String.class);

		LOG.debug("WxMpUser data is {}.", data);

		try
		{
			return JSONUtils.parse(data, WxMpUser.class);
		}
		catch (JSONException e)
		{
			throw new WXException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}
}
