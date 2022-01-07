package com.mizhousoft.weixin.miniapp.service.impl;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.miniapp.config.MiniAppConfig;
import com.mizhousoft.weixin.miniapp.model.WxJscode2SessionResult;
import com.mizhousoft.weixin.miniapp.service.WxMiniAppService;

/**
 * 微信小程序服务
 *
 * @version
 */
public class WxMiniAppServiceImpl implements WxMiniAppService
{
	// 配置
	private MiniAppConfig config;

	// REST服务
	private RestClientService restClientService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAppId()
	{
		return config.getAppId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxJscode2SessionResult jsCode2Session(String jsCode) throws WXException
	{
		String url = String.format(JSCODE_TO_SESSION_URL, config.getAppId(), config.getAppSecret(), jsCode);

		String responseContent = restClientService.getForObject(url, String.class);

		try
		{
			return JSONUtils.parse(responseContent, WxJscode2SessionResult.class);
		}
		catch (JSONException e)
		{
			throw new WXException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}

	/**
	 * 设置config
	 * 
	 * @param config
	 */
	public void setConfig(MiniAppConfig config)
	{
		this.config = config;
	}

	/**
	 * 设置restClientService
	 * 
	 * @param restClientService
	 */
	public void setRestClientService(RestClientService restClientService)
	{
		this.restClientService = restClientService;
	}
}
