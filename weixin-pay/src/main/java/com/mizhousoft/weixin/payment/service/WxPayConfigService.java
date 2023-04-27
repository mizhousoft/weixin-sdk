package com.mizhousoft.weixin.payment.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.WxPayConfig;

/**
 * 配置服务
 *
 */
public interface WxPayConfigService
{
	/**
	 * 增加配置
	 * 
	 * @param wxPayConfig
	 * @throws WXException
	 */
	void addConfig(WxPayConfig wxPayConfig) throws WXException;

	/**
	 * 删除配置
	 * 
	 * @param mchId
	 */
	void deleteConfig(String mchId);

	/**
	 * 获取默认的
	 * 
	 * @return
	 * @throws WXException
	 */
	WxPayConfig getDefault() throws WXException;

	/**
	 * 根据商户ID获取
	 * 
	 * @param mchId
	 * @return
	 * @throws WXException
	 */
	WxPayConfig getByMchId(String mchId) throws WXException;

	/**
	 * 根据标识获取
	 * 
	 * @param identifier
	 * @return
	 * @throws WXException
	 */
	WxPayConfig getByIdentifier(String identifier) throws WXException;
}
