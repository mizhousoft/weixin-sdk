package com.mizhousoft.boot.weixin.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置
 *
 * @version
 */
@Component
@ConfigurationProperties(prefix = "weixin.pay")
public class WeixinPayListProperties
{
	private List<WeixinPayProperties> merchants;

	/**
	 * 获取merchants
	 * 
	 * @return
	 */
	public List<WeixinPayProperties> getMerchants()
	{
		return merchants;
	}

	/**
	 * 设置merchants
	 * 
	 * @param merchants
	 */
	public void setMerchants(List<WeixinPayProperties> merchants)
	{
		this.merchants = merchants;
	}
}
