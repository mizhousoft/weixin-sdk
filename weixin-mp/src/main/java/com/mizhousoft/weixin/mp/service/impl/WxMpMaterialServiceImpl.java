package com.mizhousoft.weixin.mp.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.constants.MaterialType;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialCountResult;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialFileBatchGetResult;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialNews;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialNewsBatchGetResult;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialVideoInfoResult;
import com.mizhousoft.weixin.mp.service.WxMpMaterialService;
import com.mizhousoft.weixin.mp.service.WxMpService;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 素材服务
 *
 */
public class WxMpMaterialServiceImpl implements WxMpMaterialService
{
	// WxMpService
	private WxMpService wxMpService;

	/**
	 * 构造函数
	 *
	 * @param wxMpService
	 */
	public WxMpMaterialServiceImpl(WxMpService wxMpService)
	{
		super();
		this.wxMpService = wxMpService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpMaterialVideoInfoResult materialVideoInfo(String mediaId) throws WXException
	{
		try
		{
			Map<String, Object> params = new HashMap<>(1);
			params.put("media_id", mediaId);
			String body = JSONUtils.toJSONString(params);

			String url = API_URL_PREFIX + "/get_material";

			String accessToken = wxMpService.getAccessToken();

			url = url + "?access_token=" + accessToken;

			String data = Unirest.post(url).body(body).asString().getBody();

			WxMpMaterialVideoInfoResult result = JSONUtils.parse(data, WxMpMaterialVideoInfoResult.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
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
	public File materialImageOrVoiceDownload(String mediaId, String destFilePath) throws WXException
	{
		try
		{
			Map<String, Object> params = new HashMap<>(1);
			params.put("media_id", mediaId);
			String body = JSONUtils.toJSONString(params);

			String url = API_URL_PREFIX + "/get_material";

			String accessToken = wxMpService.getAccessToken();

			url = url + "?access_token=" + accessToken;

			File file = Unirest.post(url).body(body).asFile(destFilePath).getBody();

			return file;
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
	public WxMpMaterialNews materialNewsInfo(String mediaId) throws WXException
	{
		try
		{
			Map<String, Object> params = new HashMap<>(1);
			params.put("media_id", mediaId);
			String body = JSONUtils.toJSONString(params);

			String url = API_URL_PREFIX + "/get_material";

			String accessToken = wxMpService.getAccessToken();

			url = url + "?access_token=" + accessToken;

			String data = Unirest.post(url).body(body).asString().getBody();

			WxMpMaterialNews result = JSONUtils.parse(data, WxMpMaterialNews.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
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
	public WxMpMaterialCountResult materialCount() throws WXException
	{
		String url = API_URL_PREFIX + "/get_materialcount";

		String accessToken = wxMpService.getAccessToken();

		url = url + "?access_token=" + accessToken;

		try
		{
			String data = Unirest.get(url).asString().getBody();

			WxMpMaterialCountResult result = JSONUtils.parse(data, WxMpMaterialCountResult.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
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
	public WxMpMaterialNewsBatchGetResult materialNewsBatchGet(int offset, int count) throws WXException
	{
		try
		{
			Map<String, Object> params = new HashMap<>(3);
			params.put("type", MaterialType.NEWS);
			params.put("offset", offset);
			params.put("count", count);
			String body = JSONUtils.toJSONString(params);

			String url = API_URL_PREFIX + "/batchget_material";

			String accessToken = wxMpService.getAccessToken();

			url = url + "?access_token=" + accessToken;

			String data = Unirest.post(url).body(body).asString().getBody();

			WxMpMaterialNewsBatchGetResult result = JSONUtils.parse(data, WxMpMaterialNewsBatchGetResult.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
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
	public WxMpMaterialFileBatchGetResult materialFileBatchGet(String type, int offset, int count) throws WXException
	{
		try
		{
			Map<String, Object> params = new HashMap<>(3);
			params.put("type", type);
			params.put("offset", offset);
			params.put("count", count);
			String body = JSONUtils.toJSONString(params);

			String url = API_URL_PREFIX + "/batchget_material";

			String accessToken = wxMpService.getAccessToken();

			url = url + "?access_token=" + accessToken;

			String data = Unirest.post(url).body(body).asString().getBody();

			WxMpMaterialFileBatchGetResult result = JSONUtils.parse(data, WxMpMaterialFileBatchGetResult.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
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
}
