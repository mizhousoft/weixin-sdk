package com.mizhousoft.weixin.open.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WxOpenUser
 *
 * @version
 */
public class WxOpenUser
{
	// 普通用户的标识，对当前开发者帐号唯一
	@JsonProperty("openid")
	private String openId;

	// 普通用户昵称
	@JsonProperty("nickname")
	private String nickname;

	// 普通用户性别，1 为男性，2 为女性
	@JsonProperty("sex")
	private Integer sex;

	// 普通用户个人资料填写的省份
	@JsonProperty("province")
	private String province;

	// 普通用户个人资料填写的城市
	@JsonProperty("city")
	private String city;

	// 国家，如中国为 CN
	@JsonProperty("country")
	private String country;

	// 用户头像
	@JsonProperty("headimgurl")
	private String headImgUrl;

	// 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的 unionid 是唯一的。
	@JsonProperty("unionid")
	private String unionId;

	// 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）.
	@JsonProperty("privilege")
	private String[] privileges;

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
	 * 获取nickname
	 * 
	 * @return
	 */
	public String getNickname()
	{
		return nickname;
	}

	/**
	 * 设置nickname
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	/**
	 * 获取sex
	 * 
	 * @return
	 */
	public Integer getSex()
	{
		return sex;
	}

	/**
	 * 设置sex
	 * 
	 * @param sex
	 */
	public void setSex(Integer sex)
	{
		this.sex = sex;
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
	 * 获取headImgUrl
	 * 
	 * @return
	 */
	public String getHeadImgUrl()
	{
		return headImgUrl;
	}

	/**
	 * 设置headImgUrl
	 * 
	 * @param headImgUrl
	 */
	public void setHeadImgUrl(String headImgUrl)
	{
		this.headImgUrl = headImgUrl;
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
	 * 获取privileges
	 * 
	 * @return
	 */
	public String[] getPrivileges()
	{
		return privileges;
	}

	/**
	 * 设置privileges
	 * 
	 * @param privileges
	 */
	public void setPrivileges(String[] privileges)
	{
		this.privileges = privileges;
	}
}
