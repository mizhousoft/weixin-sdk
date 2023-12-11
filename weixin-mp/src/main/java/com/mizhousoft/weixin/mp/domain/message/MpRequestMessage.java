package com.mizhousoft.weixin.mp.domain.message;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 请求消息
 *
 */
@XmlRootElement(name = "xml")
public class MpRequestMessage
{
	// 开发者微信号
	@XmlElement(name = "ToUserName")
	private String toUser;

	// 发送方帐号（一个OpenID）
	@XmlElement(name = "FromUserName")
	private String fromUser;

	// 消息创建时间 （整型）
	@XmlElement(name = "CreateTime")
	private Long createTime;

	// 消息类型
	@XmlElement(name = "MsgType")
	private String msgType;

	// 文本消息内容
	@XmlElement(name = "Content")
	private String content;

	// 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了。
	@XmlElement(name = "MenuId")
	private Long menuId;

	// 消息id，64位整型
	@XmlElement(name = "MsgId")
	private Long msgId;

	// 图片链接（由系统生成）
	@XmlElement(name = "PicUrl")
	private String picUrl;

	// 图片消息媒体id，可以调用获取临时素材接口拉取数据。
	@XmlElement(name = "MediaId")
	private String mediaId;

	// 语音格式，如amr，speex等
	@XmlElement(name = "Format")
	private String format;

	// 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	@XmlElement(name = "ThumbMediaId")
	private String thumbMediaId;

	// 地理位置纬度
	@XmlElement(name = "Location_X")
	private BigDecimal locationX;

	// 地理位置经度
	@XmlElement(name = "Location_Y")
	private BigDecimal locationY;

	// 地图缩放大小
	@XmlElement(name = "Scale")
	private BigDecimal scale;

	// 地理位置信息
	@XmlElement(name = "Label")
	private String label;

	// 消息标题
	@XmlElement(name = "Title")
	private String title;

	// 消息描述
	@XmlElement(name = "Description")
	private String description;

	// 消息链接
	@XmlElement(name = "Url")
	private String url;

	// 事件类型
	@XmlElement(name = "Event")
	private String event;

	// 事件KEY值
	@XmlElement(name = "EventKey")
	private String eventKey;

	// 二维码的ticket，可用来换取二维码图片
	@XmlElement(name = "Ticket")
	private String ticket;

	// 地理位置纬度
	@XmlElement(name = "Latitude")
	private BigDecimal latitude;

	// 地理位置经度
	@XmlElement(name = "Longitude")
	private BigDecimal longitude;

	// 地理位置精度
	@XmlElement(name = "Precision")
	private BigDecimal precision;

	// 语音识别结果，UTF8编码
	@XmlElement(name = "Recognition")
	private String recognition;

	//
	@XmlElement(name = "UnionId")
	private String unionId;

	/**
	 * 获取toUser
	 * 
	 * @return
	 */
	@XmlTransient
	public String getToUser()
	{
		return toUser;
	}

	/**
	 * 设置toUser
	 * 
	 * @param toUser
	 */
	public void setToUser(String toUser)
	{
		this.toUser = toUser;
	}

	/**
	 * 获取fromUser
	 * 
	 * @return
	 */
	@XmlTransient
	public String getFromUser()
	{
		return fromUser;
	}

	/**
	 * 设置fromUser
	 * 
	 * @param fromUser
	 */
	public void setFromUser(String fromUser)
	{
		this.fromUser = fromUser;
	}

	/**
	 * 获取createTime
	 * 
	 * @return
	 */
	@XmlTransient
	public Long getCreateTime()
	{
		return createTime;
	}

	/**
	 * 设置createTime
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Long createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * 获取msgType
	 * 
	 * @return
	 */
	@XmlTransient
	public String getMsgType()
	{
		return msgType;
	}

	/**
	 * 设置msgType
	 * 
	 * @param msgType
	 */
	public void setMsgType(String msgType)
	{
		this.msgType = msgType;
	}

	/**
	 * 获取content
	 * 
	 * @return
	 */
	@XmlTransient
	public String getContent()
	{
		return content;
	}

	/**
	 * 设置content
	 * 
	 * @param content
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/**
	 * 获取menuId
	 * 
	 * @return
	 */
	@XmlTransient
	public Long getMenuId()
	{
		return menuId;
	}

	/**
	 * 设置menuId
	 * 
	 * @param menuId
	 */
	public void setMenuId(Long menuId)
	{
		this.menuId = menuId;
	}

	/**
	 * 获取msgId
	 * 
	 * @return
	 */
	@XmlTransient
	public Long getMsgId()
	{
		return msgId;
	}

	/**
	 * 设置msgId
	 * 
	 * @param msgId
	 */
	public void setMsgId(Long msgId)
	{
		this.msgId = msgId;
	}

	/**
	 * 获取picUrl
	 * 
	 * @return
	 */
	@XmlTransient
	public String getPicUrl()
	{
		return picUrl;
	}

	/**
	 * 设置picUrl
	 * 
	 * @param picUrl
	 */
	public void setPicUrl(String picUrl)
	{
		this.picUrl = picUrl;
	}

	/**
	 * 获取mediaId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getMediaId()
	{
		return mediaId;
	}

	/**
	 * 设置mediaId
	 * 
	 * @param mediaId
	 */
	public void setMediaId(String mediaId)
	{
		this.mediaId = mediaId;
	}

	/**
	 * 获取format
	 * 
	 * @return
	 */
	@XmlTransient
	public String getFormat()
	{
		return format;
	}

	/**
	 * 设置format
	 * 
	 * @param format
	 */
	public void setFormat(String format)
	{
		this.format = format;
	}

	/**
	 * 获取thumbMediaId
	 * 
	 * @return
	 */
	@XmlTransient
	public String getThumbMediaId()
	{
		return thumbMediaId;
	}

	/**
	 * 设置thumbMediaId
	 * 
	 * @param thumbMediaId
	 */
	public void setThumbMediaId(String thumbMediaId)
	{
		this.thumbMediaId = thumbMediaId;
	}

	/**
	 * 获取locationX
	 * 
	 * @return
	 */
	@XmlTransient
	public BigDecimal getLocationX()
	{
		return locationX;
	}

	/**
	 * 设置locationX
	 * 
	 * @param locationX
	 */
	public void setLocationX(BigDecimal locationX)
	{
		this.locationX = locationX;
	}

	/**
	 * 获取locationY
	 * 
	 * @return
	 */
	@XmlTransient
	public BigDecimal getLocationY()
	{
		return locationY;
	}

	/**
	 * 设置locationY
	 * 
	 * @param locationY
	 */
	public void setLocationY(BigDecimal locationY)
	{
		this.locationY = locationY;
	}

	/**
	 * 获取scale
	 * 
	 * @return
	 */
	@XmlTransient
	public BigDecimal getScale()
	{
		return scale;
	}

	/**
	 * 设置scale
	 * 
	 * @param scale
	 */
	public void setScale(BigDecimal scale)
	{
		this.scale = scale;
	}

	/**
	 * 获取label
	 * 
	 * @return
	 */
	@XmlTransient
	public String getLabel()
	{
		return label;
	}

	/**
	 * 设置label
	 * 
	 * @param label
	 */
	public void setLabel(String label)
	{
		this.label = label;
	}

	/**
	 * 获取title
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTitle()
	{
		return title;
	}

	/**
	 * 设置title
	 * 
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * 获取description
	 * 
	 * @return
	 */
	@XmlTransient
	public String getDescription()
	{
		return description;
	}

	/**
	 * 设置description
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * 获取url
	 * 
	 * @return
	 */
	@XmlTransient
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
	 * 获取event
	 * 
	 * @return
	 */
	@XmlTransient
	public String getEvent()
	{
		return event;
	}

	/**
	 * 设置event
	 * 
	 * @param event
	 */
	public void setEvent(String event)
	{
		this.event = event;
	}

	/**
	 * 获取eventKey
	 * 
	 * @return
	 */
	@XmlTransient
	public String getEventKey()
	{
		return eventKey;
	}

	/**
	 * 设置eventKey
	 * 
	 * @param eventKey
	 */
	public void setEventKey(String eventKey)
	{
		this.eventKey = eventKey;
	}

	/**
	 * 获取ticket
	 * 
	 * @return
	 */
	@XmlTransient
	public String getTicket()
	{
		return ticket;
	}

	/**
	 * 设置ticket
	 * 
	 * @param ticket
	 */
	public void setTicket(String ticket)
	{
		this.ticket = ticket;
	}

	/**
	 * 获取latitude
	 * 
	 * @return
	 */
	@XmlTransient
	public BigDecimal getLatitude()
	{
		return latitude;
	}

	/**
	 * 设置latitude
	 * 
	 * @param latitude
	 */
	public void setLatitude(BigDecimal latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * 获取longitude
	 * 
	 * @return
	 */
	@XmlTransient
	public BigDecimal getLongitude()
	{
		return longitude;
	}

	/**
	 * 设置longitude
	 * 
	 * @param longitude
	 */
	public void setLongitude(BigDecimal longitude)
	{
		this.longitude = longitude;
	}

	/**
	 * 获取precision
	 * 
	 * @return
	 */
	@XmlTransient
	public BigDecimal getPrecision()
	{
		return precision;
	}

	/**
	 * 设置precision
	 * 
	 * @param precision
	 */
	public void setPrecision(BigDecimal precision)
	{
		this.precision = precision;
	}

	/**
	 * 获取recognition
	 * 
	 * @return
	 */
	@XmlTransient
	public String getRecognition()
	{
		return recognition;
	}

	/**
	 * 设置recognition
	 * 
	 * @param recognition
	 */
	public void setRecognition(String recognition)
	{
		this.recognition = recognition;
	}

	/**
	 * 获取unionId
	 * 
	 * @return
	 */
	@XmlTransient
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
}
