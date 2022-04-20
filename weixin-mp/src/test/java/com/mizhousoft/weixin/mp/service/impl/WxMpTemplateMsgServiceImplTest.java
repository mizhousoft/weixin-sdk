package com.mizhousoft.weixin.mp.service.impl;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mizhousoft.commons.restclient.TruststoreLoader;
import com.mizhousoft.commons.restclient.service.impl.HttpsRestClientServiceImpl;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.config.WxMpConfig;
import com.mizhousoft.weixin.mp.domain.template.WxMpMiniProgramData;
import com.mizhousoft.weixin.mp.domain.template.WxMpTemplateData;
import com.mizhousoft.weixin.mp.domain.template.WxMpTemplateMessage;
import com.mizhousoft.weixin.mp.service.WxMpTemplateMsgService;

/**
 * WxMpTemplateMsgServiceImpl Test
 *
 * @version
 */
public class WxMpTemplateMsgServiceImplTest
{
	private WxMpServiceImpl wxMpService;

	@Before
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

	@Test
	public void materialVideoInfo() throws GeneralSecurityException, WXException
	{
		WxMpTemplateMsgService templateMsgService = wxMpService.getWxMpTemplateMsgService();

		WxMpMiniProgramData miniProgram = new WxMpMiniProgramData();
		miniProgram.setAppId("test");
		miniProgram.setPagePath("test");

		Map<String, WxMpTemplateData> dataMap = new HashMap<>();

		dataMap.put("first", new WxMpTemplateData("您有新的订单要发货"));
		dataMap.put("keyword1", new WxMpTemplateData("司机配送直达"));
		dataMap.put("keyword2", new WxMpTemplateData("76173131232233"));
		dataMap.put("keyword3", new WxMpTemplateData("张三"));
		dataMap.put("keyword4", new WxMpTemplateData("无"));
		dataMap.put("remark", new WxMpTemplateData("客户购买了东北大米3包"));

		WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
		templateMessage.setOpenId("oP_Jt6LUs0DPhwY2Far1wrgcRxM4");
		templateMessage.setTemplateId("4xTtk7ifBz4FfzvoxsodZMAi1EJB3nfxcFo2aHGVJEY");
		templateMessage.setMiniProgram(null);
		templateMessage.setData(dataMap);

		String result = templateMsgService.sendTemplateMsg(templateMessage);

		System.out.println(result);
	}
}
