package com.mizhousoft.weixin.miniapp.service.impl;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.miniapp.config.MiniAppConfig;
import com.mizhousoft.weixin.miniapp.model.WxJscode2SessionResult;
import com.mizhousoft.weixin.miniapp.service.WxMiniAppService;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 微信小程序服务
 *
 */
public class WxMiniAppServiceImpl implements WxMiniAppService
{
	// 配置
	private MiniAppConfig config;

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

		try
		{
			String responseContent = Unirest.get(url).asString().getBody();
			
			return JSONUtils.parse(responseContent, WxJscode2SessionResult.class);
		}
		catch (UnirestException e)
		{
			throw new WXException(e.getMessage(), e);
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
}
