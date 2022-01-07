package com.mizhousoft.weixin.mp.service.impl;

import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.model.WxAccessToken;
import com.mizhousoft.weixin.mp.config.WxMpConfig;
import com.mizhousoft.weixin.mp.service.WxMpMaterialService;
import com.mizhousoft.weixin.mp.service.WxMpService;
import com.mizhousoft.weixin.mp.service.WxMpUserService;

/**
 * 微信公众号服务
 *
 * @version
 */
public class WxMpServiceImpl implements WxMpService
{
	// 公众号配置
	private WxMpConfig config;

	// REST服务
	private RestClientService restClientService;

	// 访问Token
	private volatile String accessToken;

	// Token过期时间
	private volatile long expiresTime;

	// WxMpUserService
	private WxMpUserService mpUserService = new WxMpUserServiceImpl(this);

	// WxMpMaterialService
	private WxMpMaterialService materialService = new WxMpMaterialServiceImpl(this);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized String getAccessToken() throws WXException
	{
		if (isAccessTokenExpired())
		{
			String url = String.format(GET_ACCESS_TOKEN_URL, config.getAppId(), config.getAppSecret());
			String responseContent = restClientService.getForObject(url, String.class);

			try
			{
				WxAccessToken wxAccessToken = JSONUtils.parse(responseContent, WxAccessToken.class);

				if (!StringUtils.isBlank(wxAccessToken.getErrorCode()))
				{
					throw new WXException(wxAccessToken.getErrorCode(), wxAccessToken.getErrorMsg());
				}

				this.accessToken = wxAccessToken.getAccessToken();
				this.expiresTime = System.currentTimeMillis() + (wxAccessToken.getExpiresIn() - 200) * 1000L;
			}
			catch (JSONException e)
			{
				throw new WXException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
			}
		}

		return this.accessToken;
	}

	private boolean isAccessTokenExpired()
	{
		return (System.currentTimeMillis() > this.expiresTime);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpUserService getWxMpUserService()
	{
		return mpUserService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpMaterialService getWxMpMaterialService()
	{
		return materialService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RestClientService getRestClientService()
	{
		return restClientService;
	}

	/**
	 * 设置config
	 * 
	 * @param config
	 */
	public void setConfig(WxMpConfig config)
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
