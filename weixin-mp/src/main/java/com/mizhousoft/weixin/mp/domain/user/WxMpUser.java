package com.mizhousoft.weixin.mp.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WxMpUser
 *
 * @version
 */
public class WxMpUser
{
	// 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	@JsonProperty("subscribe")
	private Boolean subscribe;

	// 用户的标识，对当前公众号唯一
	@JsonProperty("openid")
	private String openId;

	// 普通用户昵称
	@JsonProperty("nickname")
	private String nickname;

	// 普通用户性别，1 为男性，2 为女性
	@JsonProperty("sex")
	private Integer sex;

	// 用户的语言，简体中文为zh_CN
	@JsonProperty("language")
	private String language;

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

	// 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	@JsonProperty("subscribe_time")
	private Long subscribeTime;

	// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	@JsonProperty("unionid")
	private String unionId;

	// 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	@JsonProperty("remark")
	private String remark;

	// 用户所在的分组ID（兼容旧的用户分组接口）
	@JsonProperty("groupid")
	private Integer groupId;

	// 用户被打上的标签ID列表
	@JsonProperty("tagid_list")
	private Long[] tagIds;

	// 返回用户关注的渠道来源
	@JsonProperty("subscribe_scene")
	private String subscribeScene;

	// 二维码扫码场景（开发者自定义）
	@JsonProperty("qr_scene")
	private String qrScene;

	// 二维码扫码场景描述（开发者自定义）
	@JsonProperty("qr_scene_str")
	private String qrSceneStr;

	/**
	 * 获取subscribe
	 * 
	 * @return
	 */
	public Boolean getSubscribe()
	{
		return subscribe;
	}

	/**
	 * 设置subscribe
	 * 
	 * @param subscribe
	 */
	public void setSubscribe(Boolean subscribe)
	{
		this.subscribe = subscribe;
	}

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
	 * 获取subscribeTime
	 * 
	 * @return
	 */
	public Long getSubscribeTime()
	{
		return subscribeTime;
	}

	/**
	 * 设置subscribeTime
	 * 
	 * @param subscribeTime
	 */
	public void setSubscribeTime(Long subscribeTime)
	{
		this.subscribeTime = subscribeTime;
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
	 * 获取remark
	 * 
	 * @return
	 */
	public String getRemark()
	{
		return remark;
	}

	/**
	 * 设置remark
	 * 
	 * @param remark
	 */
	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	/**
	 * 获取groupId
	 * 
	 * @return
	 */
	public Integer getGroupId()
	{
		return groupId;
	}

	/**
	 * 设置groupId
	 * 
	 * @param groupId
	 */
	public void setGroupId(Integer groupId)
	{
		this.groupId = groupId;
	}

	/**
	 * 获取tagIds
	 * 
	 * @return
	 */
	public Long[] getTagIds()
	{
		return tagIds;
	}

	/**
	 * 设置tagIds
	 * 
	 * @param tagIds
	 */
	public void setTagIds(Long[] tagIds)
	{
		this.tagIds = tagIds;
	}

	/**
	 * 获取subscribeScene
	 * 
	 * @return
	 */
	public String getSubscribeScene()
	{
		return subscribeScene;
	}

	/**
	 * 设置subscribeScene
	 * 
	 * @param subscribeScene
	 */
	public void setSubscribeScene(String subscribeScene)
	{
		this.subscribeScene = subscribeScene;
	}

	/**
	 * 获取qrScene
	 * 
	 * @return
	 */
	public String getQrScene()
	{
		return qrScene;
	}

	/**
	 * 设置qrScene
	 * 
	 * @param qrScene
	 */
	public void setQrScene(String qrScene)
	{
		this.qrScene = qrScene;
	}

	/**
	 * 获取qrSceneStr
	 * 
	 * @return
	 */
	public String getQrSceneStr()
	{
		return qrSceneStr;
	}

	/**
	 * 设置qrSceneStr
	 * 
	 * @param qrSceneStr
	 */
	public void setQrSceneStr(String qrSceneStr)
	{
		this.qrSceneStr = qrSceneStr;
	}
}
