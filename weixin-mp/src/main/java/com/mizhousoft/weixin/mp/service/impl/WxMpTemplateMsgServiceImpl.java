package com.mizhousoft.weixin.mp.service.impl;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.template.MpTemplateMessageResult;
import com.mizhousoft.weixin.mp.domain.template.WxMpTemplateMessage;
import com.mizhousoft.weixin.mp.service.WxMpService;
import com.mizhousoft.weixin.mp.service.WxMpTemplateMsgService;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 模板消息服务
 *
 */
public class WxMpTemplateMsgServiceImpl implements WxMpTemplateMsgService
{
	// WxMpService
	private WxMpService wxMpService;

	/**
	 * 构造函数
	 *
	 * @param wxMpService
	 */
	public WxMpTemplateMsgServiceImpl(WxMpService wxMpService)
	{
		super();
		this.wxMpService = wxMpService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String sendTemplateMsg(WxMpTemplateMessage templateMessage) throws WXException
	{
		try
		{
			String body = JSONUtils.toJSONString(templateMessage);

			String accessToken = wxMpService.getAccessToken();
			String url = String.format(MESSAGE_TEMPLATE_SEND, accessToken);

			MpTemplateMessageResult result = Unirest.post(url).body(body).asObject(MpTemplateMessageResult.class).getBody();

			if ("0".equals(result.getErrorCode()))
			{
				return result.getMessageId();
			}

			throw new WXException(result.getErrorMsg());
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
