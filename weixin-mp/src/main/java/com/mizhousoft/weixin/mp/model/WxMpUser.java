package com.mizhousoft.weixin.mp.model;

/**
 * WxMpUser
 *
 * @version
 */
public class WxMpUser
{
	private Boolean subscribe;

	private String openId;

	private String nickname;

	/**
	 * 性别描述信息：男、女、未知等.
	 */
	private String sexDesc;

	/**
	 * 性别表示：1，2等数字.
	 */
	private Integer sex;

	private String language;

	private String city;

	private String province;

	private String country;

	private String headImgUrl;

	private Long subscribeTime;

	/**
	 * https://mp.weixin.qq.com/cgi-bin/announce?action=getannouncement&announce_id=11513156443eZYea&version=&lang=zh_CN
	 * 
	 * <pre>
	 * 只有在将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 * 另外，在用户未关注公众号时，将不返回用户unionID信息。
	 * 已关注的用户，开发者可使用“获取用户基本信息接口”获取unionID；
	 * 未关注用户，开发者可使用“微信授权登录接口”并将scope参数设置为snsapi_userinfo，获取用户unionID
	 * </pre>
	 */
	private String unionId;

	private String remark;

	private Integer groupId;

	private Long[] tagIds;

	/**
	 * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）.
	 */
	private String[] privileges;

	/**
	 * subscribe_scene 返回用户关注的渠道来源.
	 * ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD
	 * 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM
	 * 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他
	 */
	private String subscribeScene;

	/**
	 * qr_scene 二维码扫码场景（开发者自定义）.
	 */
	private String qrScene;

	/**
	 * qr_scene_str 二维码扫码场景描述（开发者自定义）.
	 */
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
	 * 获取sexDesc
	 * 
	 * @return
	 */
	public String getSexDesc()
	{
		return sexDesc;
	}

	/**
	 * 设置sexDesc
	 * 
	 * @param sexDesc
	 */
	public void setSexDesc(String sexDesc)
	{
		this.sexDesc = sexDesc;
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
