package com.mizhousoft.weixin.mp.domain.template;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 模板消息
 *
 * @version
 */
public class WxMpTemplateMessage
{
	// 接收者（用户）的 openid
	@JsonProperty("touser")
	private String openId;

	// 所需下发的订阅模板id
	@JsonProperty("template_id")
	private String templateId;

	// 跳转网页时填写
	@JsonProperty("page")
	private String pageUrl;

	// 跳转小程序时填写
	@JsonProperty("miniprogram")
	private WxMpMiniProgramData miniProgram;

	@JsonProperty("data")
	private Map<String, WxMpTemplateData> data;

	/**
	 * 获取openId
	 * 
	 * @return
	 */
	public String getOpenId()
	{
		return openId;
	}

	/**
	 * 设置openId
	 * 
	 * @param openId
	 */
	public void setOpenId(String openId)
	{
		this.openId = openId;
	}

	/**
	 * 获取templateId
	 * 
	 * @return
	 */
	public String getTemplateId()
	{
		return templateId;
	}

	/**
	 * 设置templateId
	 * 
	 * @param templateId
	 */
	public void setTemplateId(String templateId)
	{
		this.templateId = templateId;
	}

	/**
	 * 获取pageUrl
	 * 
	 * @return
	 */
	public String getPageUrl()
	{
		return pageUrl;
	}

	/**
	 * 设置pageUrl
	 * 
	 * @param pageUrl
	 */
	public void setPageUrl(String pageUrl)
	{
		this.pageUrl = pageUrl;
	}

	/**
	 * 获取miniProgram
	 * 
	 * @return
	 */
	public WxMpMiniProgramData getMiniProgram()
	{
		return miniProgram;
	}

	/**
	 * 设置miniProgram
	 * 
	 * @param miniProgram
	 */
	public void setMiniProgram(WxMpMiniProgramData miniProgram)
	{
		this.miniProgram = miniProgram;
	}

	/**
	 * 获取data
	 * 
	 * @return
	 */
	public Map<String, WxMpTemplateData> getData()
	{
		return data;
	}

	/**
	 * 设置data
	 * 
	 * @param data
	 */
	public void setData(Map<String, WxMpTemplateData> data)
	{
		this.data = data;
	}
}
