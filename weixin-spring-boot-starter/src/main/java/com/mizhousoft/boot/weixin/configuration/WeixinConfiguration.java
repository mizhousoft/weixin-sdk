package com.mizhousoft.boot.weixin.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mizhousoft.boot.weixin.properties.WeixinMPProperties;
import com.mizhousoft.boot.weixin.properties.WeixinMiniProperties;
import com.mizhousoft.boot.weixin.properties.WeixinOpenProperties;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.miniapp.config.MiniAppConfig;
import com.mizhousoft.weixin.miniapp.service.WxMiniAppService;
import com.mizhousoft.weixin.miniapp.service.impl.WxMiniAppServiceImpl;
import com.mizhousoft.weixin.mp.config.WxMpConfig;
import com.mizhousoft.weixin.mp.service.WxMpMessageHandler;
import com.mizhousoft.weixin.mp.service.WxMpMessageRouter;
import com.mizhousoft.weixin.mp.service.WxMpService;
import com.mizhousoft.weixin.mp.service.impl.WxMpMessageRouterImpl;
import com.mizhousoft.weixin.mp.service.impl.WxMpServiceImpl;
import com.mizhousoft.weixin.open.config.WxOpenConfig;
import com.mizhousoft.weixin.open.service.WxOpenService;
import com.mizhousoft.weixin.open.service.impl.WxOpenServiceImpl;

/**
 * WeixinConfiguration
 *
 * @version
 */
@Configuration
public class WeixinConfiguration
{
	@Autowired
	private WeixinOpenProperties openProperties;

	@Autowired
	private WeixinMPProperties mpProperties;

	@Autowired
	private WeixinMiniProperties miniProperties;

	@Autowired
	private RestClientService restClientService;

	@Bean
	@ConditionalOnProperty("weixin.open.app-id")
	public WxOpenService getWxOpenService()
	{
		WxOpenConfig wxOpenConfig = new WxOpenConfig();
		wxOpenConfig.setAppId(openProperties.getAppId());
		wxOpenConfig.setAppSecret(openProperties.getAppSecret());

		WxOpenServiceImpl wxOpenService = new WxOpenServiceImpl();
		wxOpenService.setConfig(wxOpenConfig);
		wxOpenService.setRestClientService(restClientService);

		return wxOpenService;
	}

	@Bean
	@ConditionalOnProperty("weixin.miniapp.app-id")
	public WxMiniAppService getWxMiniAppService()
	{
		WxMiniAppServiceImpl wxMiniAppService = new WxMiniAppServiceImpl();

		MiniAppConfig config = new MiniAppConfig();
		config.setAppId(miniProperties.getAppId());
		config.setAppSecret(miniProperties.getAppSecret());
		config.setToken(miniProperties.getToken());
		config.setAesKey(miniProperties.getAesKey());

		wxMiniAppService.setConfig(config);
		wxMiniAppService.setRestClientService(restClientService);

		return wxMiniAppService;
	}

	@Bean
	@ConditionalOnProperty("weixin.mp.app-id")
	public WxMpService getWxMpService()
	{
		WxMpConfig config = new WxMpConfig();
		config.setAppId(mpProperties.getAppId());
		config.setAppSecret(mpProperties.getAppSecret());
		config.setToken(mpProperties.getToken());
		config.setAesKey(mpProperties.getAesKey());

		WxMpServiceImpl wxMpService = new WxMpServiceImpl();
		wxMpService.setRestClientService(restClientService);
		wxMpService.setConfig(config);

		return wxMpService;
	}

	@Bean
	@ConditionalOnProperty("weixin.mp.app-id")
	public WxMpMessageRouter getWxMpMessageRouter(List<WxMpMessageHandler> msgHandlers)
	{
		WxMpMessageRouterImpl router = new WxMpMessageRouterImpl(msgHandlers);

		return router;
	}
}
