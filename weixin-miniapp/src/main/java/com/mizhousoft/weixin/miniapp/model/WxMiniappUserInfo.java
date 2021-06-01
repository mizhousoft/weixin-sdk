package com.mizhousoft.weixin.miniapp.model;

/**
 * 小程序用户信息
 *
 * @version
 */
public class WxMiniappUserInfo
{
	// openId
	private String openId;

	// 用户昵称
	private String nickName;

	// 用户性别
	private int gender;

	// 显示 country，province，city 所用的语言
	private String language;

	// 用户所在城市
	private String city;

	// 用户所在省份
	private String province;

	// 用户所在国家
	private String country;

	// 用户头像图片的 URL
	private String avatarUrl;

	// unionId
	private String unionId;

	// 数据水印
	private Watermark watermark;

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
	 * 获取nickName
	 * 
	 * @return
	 */
	public String getNickName()
	{
		return nickName;
	}

	/**
	 * 设置nickName
	 * 
	 * @param nickName
	 */
	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	/**
	 * 获取gender
	 * 
	 * @return
	 */
	public int getGender()
	{
		return gender;
	}

	/**
	 * 设置gender
	 * 
	 * @param gender
	 */
	public void setGender(int gender)
	{
		this.gender = gender;
	}

	/**
	 * 获取language
	 * 
	 * @return
	 */
	public String getLanguage()
	{
		return language;
	}

	/**
	 * 设置language
	 * 
	 * @param language
	 */
	public void setLanguage(String language)
	{
		this.language = language;
	}

	/**
	 * 获取city
	 * 
	 * @return
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * 设置city
	 * 
	 * @param city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * 获取province
	 * 
	 * @return
	 */
	public String getProvince()
	{
		return province;
	}

	/**
	 * 设置province
	 * 
	 * @param province
	 */
	public void setProvince(String province)
	{
		this.province = province;
	}

	/**
	 * 获取country
	 * 
	 * @return
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * 设置country
	 * 
	 * @param country
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}

	/**
	 * 获取avatarUrl
	 * 
	 * @return
	 */
	public String getAvatarUrl()
	{
		return avatarUrl;
	}

	/**
	 * 设置avatarUrl
	 * 
	 * @param avatarUrl
	 */
	public void setAvatarUrl(String avatarUrl)
	{
		this.avatarUrl = avatarUrl;
	}

	/**
	 * 获取unionId
	 * 
	 * @return
	 */
	public String getUnionId()
	{
		return unionId;
	}

	/**
	 * 设置unionId
	 * 
	 * @param unionId
	 */
	public void setUnionId(String unionId)
	{
		this.unionId = unionId;
	}

	/**
	 * 获取watermark
	 * 
	 * @return
	 */
	public Watermark getWatermark()
	{
		return watermark;
	}

	/**
	 * 设置watermark
	 * 
	 * @param watermark
	 */
	public void setWatermark(Watermark watermark)
	{
		this.watermark = watermark;
	}
}
