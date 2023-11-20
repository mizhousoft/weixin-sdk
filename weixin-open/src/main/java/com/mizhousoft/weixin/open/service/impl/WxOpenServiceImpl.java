package com.mizhousoft.weixin.open.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.util.WxUtils;
import com.mizhousoft.weixin.open.config.WxOpenConfig;
import com.mizhousoft.weixin.open.model.WxOAuth2AccessToken;
import com.mizhousoft.weixin.open.model.WxOpenUser;
import com.mizhousoft.weixin.open.service.WxOpenService;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 微信开放服务
 *
 */
public class WxOpenServiceImpl implements WxOpenService
{
	private static final Logger LOG = LoggerFactory.getLogger(WxOpenServiceImpl.class);

	// 配置
	private WxOpenConfig config;

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
			return String.format(OUTH2_CUST_CONNECT_CODE_URL, config.getAppId(), WxUtils.encodeUrl(redirectUrl), state, WxUtils.encodeUrl(
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

		try
		{
			String responseContent = Unirest.get(url).asString().getBody();

			return JSONUtils.parse(responseContent, WxOAuth2AccessToken.class);
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
	 * {@inheritDoc}
	 */
	@Override
	public WxOpenUser oauth2getUserInfo(WxOAuth2AccessToken oAuth2AccessToken, String lang) throws WXException
	{
		if (lang == null)
		{
			lang = "zh_CN";
		}

		String url = String.format(OUTH2_USERINFO_URL, oAuth2AccessToken.getAccessToken(), oAuth2AccessToken.getOpenId(), lang);

		try
		{
			String data = Unirest.get(url).asString().getBody();

			LOG.debug("WxOpenUser data is {}.", data);

			return JSONUtils.parse(data, WxOpenUser.class);
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
	public void setConfig(WxOpenConfig config)
	{
		this.config = config;
	}
}
