package com.mizhousoft.weixin.mp.service.impl;

import java.security.GeneralSecurityException;

import org.junit.jupiter.api.BeforeEach;

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

		wxMpService = new WxMpServiceImpl();
		wxMpService.setConfig(config);
	}

}
