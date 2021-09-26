package com.mizhousoft.weixin.mp.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.GeneralSecurityException;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.mizhousoft.commons.restclient.TruststoreLoader;
import com.mizhousoft.commons.restclient.service.impl.HttpsRestClientServiceImpl;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.config.WxMpConfig;
import com.mizhousoft.weixin.mp.constants.MaterialType;
import com.mizhousoft.weixin.mp.model.WxMpMaterialCountResult;
import com.mizhousoft.weixin.mp.model.WxMpMaterialFileBatchGetResult;
import com.mizhousoft.weixin.mp.model.WxMpMaterialNews;
import com.mizhousoft.weixin.mp.model.WxMpMaterialNewsBatchGetResult;
import com.mizhousoft.weixin.mp.model.WxMpMaterialVideoInfoResult;
import com.mizhousoft.weixin.mp.service.WxMpMaterialService;

/**
 * WxMpMaterialServiceImpl Test
 *
 * @version
 */
public class WxMpMaterialServiceImplTest
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
		WxMpMaterialService materialService = wxMpService.getWxMpMaterialService();

		String mediaId = "E4Yu4m7wM4Qu07WquP60y8h2rJmvJxyZfo6tjc67HjU";
		WxMpMaterialVideoInfoResult result = materialService.materialVideoInfo(mediaId);
		System.out.println(result.toString());
	}

	@Test
	public void materialImageOrVoiceDownload() throws Exception
	{
		WxMpMaterialService materialService = wxMpService.getWxMpMaterialService();

		String mediaId = "E4Yu4m7wM4Qu07WquP60y8h2rJmvJxyZfo6tjc67HjU";
		InputStream istream = materialService.materialImageOrVoiceDownload(mediaId);

		File file = new File("C:\\work\\test.jpg");

		FileOutputStream fos = new FileOutputStream(file);
		IOUtils.copy(istream, fos);
	}

	@Test
	public void materialNewsInfo() throws GeneralSecurityException, WXException
	{
		WxMpMaterialService materialService = wxMpService.getWxMpMaterialService();

		String mediaId = "E4Yu4m7wM4Qu07WquP60y76mHfBjgsaK1RK5mOcPyyw";
		WxMpMaterialNews result = materialService.materialNewsInfo(mediaId);
		System.out.println(result.toString());
	}

	@Test
	public void materialCount() throws GeneralSecurityException, WXException
	{
		WxMpMaterialService materialService = wxMpService.getWxMpMaterialService();

		WxMpMaterialCountResult result = materialService.materialCount();
		System.out.println(result.toString());
	}

	@Test
	public void materialNewsBatchGet() throws GeneralSecurityException, WXException
	{
		WxMpMaterialService materialService = wxMpService.getWxMpMaterialService();

		WxMpMaterialNewsBatchGetResult result = materialService.materialNewsBatchGet(0, 20);
		System.out.println(result.toString());
	}

	@Test
	public void materialFileBatchGet() throws GeneralSecurityException, WXException
	{
		WxMpMaterialService materialService = wxMpService.getWxMpMaterialService();

		WxMpMaterialFileBatchGetResult result = materialService.materialFileBatchGet(MaterialType.IMAGE, 0, 1);
		System.out.println(result.toString());
	}
}