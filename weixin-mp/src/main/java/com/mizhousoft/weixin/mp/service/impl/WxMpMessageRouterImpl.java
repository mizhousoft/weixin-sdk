package com.mizhousoft.weixin.mp.service.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mizhousoft.commons.thread.FixedThreadPool;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.message.MpRequestMessage;
import com.mizhousoft.weixin.mp.domain.message.MpResponseMessage;
import com.mizhousoft.weixin.mp.service.WxMpMessageHandler;
import com.mizhousoft.weixin.mp.service.WxMpMessageRouter;

/**
 * 消息路由
 *
 */
public class WxMpMessageRouterImpl implements WxMpMessageRouter
{
	private static final Logger LOG = LoggerFactory.getLogger(WxMpMessageRouterImpl.class);

	// 线程池
	private ExecutorService executorService;

	// 处理器
	private List<WxMpMessageHandler> handlers;

	/**
	 * 构造函数
	 *
	 * @param handlers
	 */
	public WxMpMessageRouterImpl(List<WxMpMessageHandler> handlers)
	{
		super();
		this.handlers = handlers;

		executorService = FixedThreadPool.newThreadPool(100, "mp-message-router");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MpResponseMessage route(MpRequestMessage wxMessage) throws WXException
	{
		WxMpMessageHandler matchHandler = null;
		for (WxMpMessageHandler handler : handlers)
		{
			if (handler.match(wxMessage))
			{
				matchHandler = handler;
				break;
			}
		}

		if (null == matchHandler)
		{
			return null;
		}

		if (matchHandler.supportAsync(wxMessage))
		{
			final WxMpMessageHandler handler = matchHandler;
			this.executorService.submit(() -> {
				try
				{
					handler.handle(wxMessage);
				}
				catch (Throwable e)
				{
					LOG.error("Handle message failed.", e);
				}
			});

			return null;
		}
		else
		{
			return matchHandler.handle(wxMessage);
		}
	}

}
