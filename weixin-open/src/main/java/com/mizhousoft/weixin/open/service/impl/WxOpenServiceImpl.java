package com.mizhousoft.weixin.open.service.impl;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.util.WxUtils;
import com.mizhousoft.weixin.mp.model.WxMpUser;
import com.mizhousoft.weixin.open.config.WxOpenConfig;
import com.mizhousoft.weixin.open.model.WxOAuth2AccessToken;
import com.mizhousoft.weixin.open.service.WxOpenService;

/**
 * 微信开放服务
 *
 * @version
 */
public class WxOpenServiceImpl implements WxOpenService
{
	// 配置
	private WxOpenConfig config;

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
	public String buildConnectCodeUrl(String redirectUrl, String state, boolean isCustomStyle)
	{
		if (isCustomStyle)
		{
			return String.format(OUTH2_CUST_CONNECT_CODE_URL, config.getAppId(), WxUtils.encodeUrl(redirectUrl), state,
			        WxUtils.encodeUrl(
			                "data:text/css;base64,LmltcG93ZXJCb3ggLnRpdGxlIHtkaXNwbGF5OiBub25lO30NCiN3eF9kZWZhdWx0X3RpcCB7ZGlzcGxheTogbm9uZX0="));
		}
		else
		{
			return String.format(OUTH2_CONNECT_CODE_URL, config.getAppId(), WxUtils.encodeUrl(redirectUrl), state);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxOAuth2AccessToken oauth2getAccessToken(String code) throws WXException
	{
		String url = String.format(OUTH2_ACCESS_TOKEN_URL, config.getAppId(), config.getAppSecret(), code);
		String responseContent = restClientService.getForObject(url, String.class);

		try
		{
			return JSONUtils.parse(responseContent, WxOAuth2AccessToken.class);
		}
		catch (JSONException e)
		{
			throw new WXException(e.getErrorCode(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpUser oauth2getUserInfo(WxOAuth2AccessToken oAuth2AccessToken, String lang) throws WXException
	{
		if (lang == null)
		{
			lang = "zh_CN";
		}

		String url = String.format(OUTH2_USERINFO_URL, oAuth2AccessToken.getAccessToken(),
		        oAuth2AccessToken.getOpenId(), lang);
		String data = restClientService.getForObject(url, String.class);

		try
		{
			return JSONUtils.parse(data, WxMpUser.class);
		}
		catch (JSONException e)
		{
			throw new WXException(e.getErrorCode(), e);
		}
	}

	/**
	 * 设置config
	 * 
	 * @param config
	 */
	public void setConfig(WxOpenConfig config)
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
