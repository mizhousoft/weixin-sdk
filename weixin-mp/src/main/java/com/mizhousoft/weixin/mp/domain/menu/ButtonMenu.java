package com.mizhousoft.weixin.mp.domain.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 菜单
 *
 * @version
 */
public class ButtonMenu
{
	/**
	 * <pre>
	 * 菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。
	 * 使用API设置的则有8种，详见<a href=
	"http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013&token=&lang=zh_CN">《自定义菜单创建接口》</a>
	 * </pre>
	 */
	@JsonProperty("type")
	private String type;

	/**
	 * 菜单名称.
	 */
	@JsonProperty("name")
	private String name;

	/**
	 * <pre>
	 * 对于不同的菜单类型，value的值意义不同.
	 * 官网上设置的自定义菜单：
	 *  <li>Text:保存文字到value；
	 *  <li>Img、voice：保存mediaID到value；
	 *  <li>Video：保存视频下载链接到value；
	 *  <li>News：保存图文消息到news_info，同时保存mediaID到value；
	 *  <li>View：保存链接到url。</li>
	 *
	 * 使用API设置的自定义菜单：
	 *  <li>click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、pic_weixin、location_select：保存值到key；
	 *  <li>view：保存链接到url
	 * </pre>
	 */
	@JsonProperty("key")
	private String key;

	/**
	 * .
	 *
	 * @see #key
	 */
	@JsonProperty("url")
	private String url;

	/**
	 * .
	 *
	 * @see #key
	 */
	@JsonProperty("value")
	private String value;

	/**
	 * <pre>
	 * 小程序的appid.miniprogram类型必须
	 * </pre>
	 */
	@JsonProperty("appid")
	private String appId;

	/**
	 * <pre>
	 * 小程序的页面路径.miniprogram类型必须
	 * </pre>
	 */
	@JsonProperty("pagepath")
	private String pagePath;

	/**
	 * 子菜单信息.
	 */
	@JsonProperty("sub_button")
	private List<ButtonMenu> subButtons;

	/**
	 * 获取type
	 * 
	 * @return
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * 设置type
	 * 
	 * @param type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * 获取name
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 设置name
	 * 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * 获取key
	 * 
	 * @return
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * 设置key
	 * 
	 * @param key
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * 获取url
	 * 
	 * @return
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * 设置url
	 * 
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
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
	 * 获取appId
	 * 
	 * @return
	 */
	public String getAppId()
	{
		return appId;
	}

	/**
	 * 设置appId
	 * 
	 * @param appId
	 */
	public void setAppId(String appId)
	{
		this.appId = appId;
	}

	/**
	 * 获取pagePath
	 * 
	 * @return
	 */
	public String getPagePath()
	{
		return pagePath;
	}

	/**
	 * 设置pagePath
	 * 
	 * @param pagePath
	 */
	public void setPagePath(String pagePath)
	{
		this.pagePath = pagePath;
	}

	/**
	 * 获取subButtons
	 * 
	 * @return
	 */
	public List<ButtonMenu> getSubButtons()
	{
		return subButtons;
	}

	/**
	 * 设置subButtons
	 * 
	 * @param subButtons
	 */
	public void setSubButtons(List<ButtonMenu> subButtons)
	{
		this.subButtons = subButtons;
	}
}
