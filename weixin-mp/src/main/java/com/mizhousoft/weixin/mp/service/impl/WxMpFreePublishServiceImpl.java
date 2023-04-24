package com.mizhousoft.weixin.mp.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.freepublish.WxMpFreePublishInfo;
import com.mizhousoft.weixin.mp.domain.freepublish.WxMpFreePublishList;
import com.mizhousoft.weixin.mp.service.WxMpFreePublishService;
import com.mizhousoft.weixin.mp.service.WxMpService;

/**
 * 微信 发布能力 接口.
 *
 */
public class WxMpFreePublishServiceImpl implements WxMpFreePublishService
{
	// WxMpService
	private WxMpService wxMpService;

	/**
	 * 构造函数
	 *
	 * @param wxMpService
	 */
	public WxMpFreePublishServiceImpl(WxMpService wxMpService)
	{
		super();
		this.wxMpService = wxMpService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpFreePublishInfo getArticleFromId(String articleId) throws WXException
	{
		try
		{
			Map<String, Object> params = new HashMap<>(1);
			params.put("article_id", articleId);
			String body = JSONUtils.toJSONString(params);

			String url = API_URL_PREFIX + "/getarticle";

			String accessToken = wxMpService.getAccessToken();

			url = url + "?access_token=" + accessToken;
			String data = wxMpService.getRestClientService().postForObject(url, body, String.class);

			WxMpFreePublishInfo result = JSONUtils.parse(data, WxMpFreePublishInfo.class);

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
	public WxMpFreePublishList getPublicationRecords(int offset, int count, boolean noContent) throws WXException
	{
		try
		{
			Map<String, Object> params = new HashMap<>(3);
			params.put("offset", offset);
			params.put("count", count);
			params.put("no_content", noContent ? 1 : 0);
			String body = JSONUtils.toJSONString(params);

			String url = API_URL_PREFIX + "/batchget";

			String accessToken = wxMpService.getAccessToken();

			url = url + "?access_token=" + accessToken;
			String data = wxMpService.getRestClientService().postForObject(url, body, String.class);

			WxMpFreePublishList result = JSONUtils.parse(data, WxMpFreePublishList.class);

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
	public WxMpFreePublishList getPublicationRecords(int offset, int count) throws WXException
	{
		return getPublicationRecords(offset, count, false);
	}
}
