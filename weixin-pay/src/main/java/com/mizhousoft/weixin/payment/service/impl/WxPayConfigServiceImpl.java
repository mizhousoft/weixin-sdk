package com.mizhousoft.weixin.payment.service.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.WxPayConfig;
import com.mizhousoft.weixin.payment.service.WxPayConfigService;

/**
 * 配置服务
 *
 */
public class WxPayConfigServiceImpl implements WxPayConfigService
{
	private static final String DEFAULT_MCH_IDENTIFIER = "default";

	private Map<String, WxPayConfig> configMap = new ConcurrentHashMap<>(10);

	private WxPayConfig defaultConfig = null;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void addConfig(WxPayConfig wxPayConfig) throws WXException
	{
		if (configMap.containsKey(wxPayConfig.getMchId()))
		{
			throw new WXException("Mch exist, mchId is " + wxPayConfig.getMchId());
		}

		configMap.put(wxPayConfig.getMchId(), wxPayConfig);

		if (DEFAULT_MCH_IDENTIFIER.equals(wxPayConfig.getIdentifier()))
		{
			defaultConfig = wxPayConfig;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void deleteConfig(String mchId)
	{
		WxPayConfig config = configMap.remove(mchId);

		if (null != config)
		{
			if (DEFAULT_MCH_IDENTIFIER.equals(config.getIdentifier()))
			{
				defaultConfig = null;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayConfig getDefault() throws WXException
	{
		if (null == defaultConfig)
		{
			throw new WXException("Default WxPayConfig not found.");
		}

		return defaultConfig;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayConfig getByMchId(String mchId) throws WXException
	{
		WxPayConfig config = null;
		if (null == mchId)
		{
			config = getDefault();
		}
		else
		{
			config = configMap.get(mchId);
		}

		if (null == config)
		{
			throw new WXException("WxPayConfig not found, mchId is " + mchId);
		}

		return config;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxPayConfig getByIdentifier(String identifier) throws WXException
	{
		Iterator<Entry<String, WxPayConfig>> iter = configMap.entrySet().iterator();
		while (iter.hasNext())
		{
			Entry<String, WxPayConfig> entry = iter.next();
			WxPayConfig config = entry.getValue();

			if (config.getIdentifier().equals(identifier))
			{
				return config;
			}
		}

		throw new WXException("WxPayConfig not found, identifier is " + identifier);
	}
}
