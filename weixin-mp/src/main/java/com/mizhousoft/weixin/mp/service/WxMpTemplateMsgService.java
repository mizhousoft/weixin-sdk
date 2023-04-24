package com.mizhousoft.weixin.mp.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.template.WxMpTemplateMessage;

/**
 * 模板消息服务
 *
 */
public interface WxMpTemplateMsgService
{
	String MESSAGE_TEMPLATE_SEND = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

	/**
	 * 发生模板消息
	 * 
	 * @param templateMessage
	 * @return
	 * @throws WXException
	 */
	String sendTemplateMsg(WxMpTemplateMessage templateMessage) throws WXException;
}
