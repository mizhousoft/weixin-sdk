package com.mizhousoft.weixin.mp.service.impl;

import java.security.GeneralSecurityException;

import org.junit.jupiter.api.Test;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.constants.MaterialType;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialCountResult;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialFileBatchGetResult;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialNews;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialNewsBatchGetResult;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialVideoInfoResult;
import com.mizhousoft.weixin.mp.service.WxMpMaterialService;

/**
 * WxMpMaterialServiceImpl Test
 *
 * @version
 */
public class WxMpMaterialServiceImplTest extends BaseWxMpServiceText
{
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

		materialService.materialImageOrVoiceDownload(mediaId, "C:\\work\\test.jpg");
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
