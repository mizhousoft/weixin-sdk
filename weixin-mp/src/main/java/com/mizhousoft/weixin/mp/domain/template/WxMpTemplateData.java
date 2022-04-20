package com.mizhousoft.weixin.mp.domain.template;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 模板数据
 *
 * @version
 */
public class WxMpTemplateData
{
	// 值
	@JsonProperty("value")
	private String value;

	// 颜色
	@JsonProperty("color")
	private String color;

	/**
	 * 构造函数
	 *
	 * @param value
	 */
	public WxMpTemplateData(String value)
	{
		super();
		this.value = value;
	}

	/**
	 * 构造函数
	 *
	 * @param value
	 * @param color
	 */
	public WxMpTemplateData(String value, String color)
	{
		super();
		this.value = value;
		this.color = color;
	}

	/**
	 * 获取value
	 * 
	 * @return
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * 设置value
	 * 
	 * @param value
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * 获取color
	 * 
	 * @return
	 */
	public String getColor()
	{
		return color;
	}

	/**
	 * 设置color
	 * 
	 * @param color
	 */
	public void setColor(String color)
	{
		this.color = color;
	}
}
