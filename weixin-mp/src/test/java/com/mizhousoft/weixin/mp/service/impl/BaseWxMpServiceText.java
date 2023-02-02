package com.mizhousoft.weixin.mp.service.impl;

import java.security.GeneralSecurityException;

import org.junit.jupiter.api.BeforeEach;

import com.mizhousoft.commons.restclient.TruststoreLoader;
import com.mizhousoft.commons.restclient.service.impl.HttpsRestClientServiceImpl;
import com.mizhousoft.weixin.mp.config.WxMpConfig;

/**
 * BaseWxMpServiceText
 *
 * @version
 */
public class BaseWxMpServiceText
{
	protected WxMpServiceImpl wxMpService;

	@BeforeEach
	public void before() throws GeneralSecurityException
	{
		WxMpConfig config = new WxMpConfig();
		config.setAppId("");
		config.setAppSecret("");

		HttpsTruststoreLoader truststoreLoader = new HttpsTruststoreLoader();
		truststoreLoader.loadTrustStore();

		TruststoreLoader[] truststoreLoaders = { truststoreLoader };

		HttpsRestClientServiceImpl restClientService = new HttpsRestClientServiceImpl();
		restClientService.setTruststoreLoaders(truststoreLoaders);
		restClientService.init();

		wxMpService = new WxMpServiceImpl();
		wxMpService.setRestClientService(restClientService);
		wxMpService.setConfig(config);
	}

}
