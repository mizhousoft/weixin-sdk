package com.mizhousoft.weixin.mp.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.constants.MaterialType;
import com.mizhousoft.weixin.mp.model.WxMpMaterialCountResult;
import com.mizhousoft.weixin.mp.model.WxMpMaterialFileBatchGetResult;
import com.mizhousoft.weixin.mp.model.WxMpMaterialNews;
import com.mizhousoft.weixin.mp.model.WxMpMaterialNewsBatchGetResult;
import com.mizhousoft.weixin.mp.model.WxMpMaterialVideoInfoResult;
import com.mizhousoft.weixin.mp.service.WxMpMaterialService;
import com.mizhousoft.weixin.mp.service.WxMpService;

/**
 * 素材服务
 *
 * @version
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
			String data = wxMpService.getRestClientService().postForObject(url, body, String.class);

			WxMpMaterialVideoInfoResult result = JSONUtils.parse(data, WxMpMaterialVideoInfoResult.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
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
	public InputStream materialImageOrVoiceDownload(String mediaId) throws WXException
	{
		try
		{
			Map<String, Object> params = new HashMap<>(1);
			params.put("media_id", mediaId);
			String body = JSONUtils.toJSONString(params);

			String url = API_URL_PREFIX + "/get_material";

			String accessToken = wxMpService.getAccessToken();

			url = url + "?access_token=" + accessToken;
			InputStream istream = wxMpService.getRestClientService().download(url, body);

			return istream;
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
			String data = wxMpService.getRestClientService().postForObject(url, body, String.class);

			WxMpMaterialNews result = JSONUtils.parse(data, WxMpMaterialNews.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
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
	public WxMpMaterialCountResult materialCount() throws WXException
	{
		String url = API_URL_PREFIX + "/get_materialcount";

		String accessToken = wxMpService.getAccessToken();

		url = url + "?access_token=" + accessToken;
		String data = wxMpService.getRestClientService().getForObject(url, String.class);

		try
		{
			WxMpMaterialCountResult result = JSONUtils.parse(data, WxMpMaterialCountResult.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
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
			String data = wxMpService.getRestClientService().postForObject(url, body, String.class);

			WxMpMaterialNewsBatchGetResult result = JSONUtils.parse(data, WxMpMaterialNewsBatchGetResult.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
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
			String data = wxMpService.getRestClientService().postForObject(url, body, String.class);

			WxMpMaterialFileBatchGetResult result = JSONUtils.parse(data, WxMpMaterialFileBatchGetResult.class);

			if (!StringUtils.isBlank(result.getErrorCode()))
			{
				throw new WXException(result.getErrorCode(), result.getErrorMsg());
			}

			return result;
		}
		catch (JSONException e)
		{
			throw new WXException(e.getErrorCode(), e);
		}
	}
}
