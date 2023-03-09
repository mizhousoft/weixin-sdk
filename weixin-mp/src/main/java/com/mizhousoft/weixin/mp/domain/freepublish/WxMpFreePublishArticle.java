package com.mizhousoft.weixin.mp.domain.freepublish;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 一条发布的图文记录
 *
 * @version
 */
public class WxMpFreePublishArticle
{
	/**
	 * 标题
	 */
	@JsonProperty("title")
	private String title;

	/**
	 * 作者
	 */
	@JsonProperty("author")
	private String author;

	/**
	 * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。
	 */
	@JsonProperty("digest")
	private String digest;

	/**
	 * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
	 */
	@JsonProperty("content")
	private String content;

	/**
	 * 图文消息的原文地址，即点击“阅读原文”后的URL
	 */
	@JsonProperty("content_source_url")
	private String contentSourceUrl;

	/**
	 * 图文消息的封面图片素材id（一定是永久MediaID）
	 */
	@JsonProperty("thumb_media_id")
	private String thumbMediaId;

	/**
	 * 图文消息的封面url
	 */
	@JsonProperty("thumb_url")
	private String thumbUrl;

	/**
	 * 是否显示封面，0为false，即不显示，1为true，即显示(默认)
	 */
	@JsonProperty("show_cover_pic")
	private Integer showCoverPic;

	/**
	 * 是否打开评论，0不打开(默认)，1打开
	 */
	@JsonProperty("need_open_comment")
	private Integer needOpenComment;

	/**
	 * 是否粉丝才可评论，0所有人可评论(默认)，1粉丝才可评论
	 */
	@JsonProperty("only_fans_can_comment")
	private Integer onlyFansCanComment;

	/**
	 * 图文消息的URL
	 */
	@JsonProperty("url")
	private String url;

	/**
	 * 该图文是否被删除
	 */
	@JsonProperty("is_deleted")
	private Boolean isDeleted;

	/**
	 * 获取title
	 * 
	 * @return
	 */
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
	 * 获取author
	 * 
	 * @return
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * 设置author
	 * 
	 * @param author
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * 获取digest
	 * 
	 * @return
	 */
	public String getDigest()
	{
		return digest;
	}

	/**
	 * 设置digest
	 * 
	 * @param digest
	 */
	public void setDigest(String digest)
	{
		this.digest = digest;
	}

	/**
	 * 获取content
	 * 
	 * @return
	 */
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
	 * 获取contentSourceUrl
	 * 
	 * @return
	 */
	public String getContentSourceUrl()
	{
		return contentSourceUrl;
	}

	/**
	 * 设置contentSourceUrl
	 * 
	 * @param contentSourceUrl
	 */
	public void setContentSourceUrl(String contentSourceUrl)
	{
		this.contentSourceUrl = contentSourceUrl;
	}

	/**
	 * 获取thumbMediaId
	 * 
	 * @return
	 */
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
	 * 获取thumbUrl
	 * 
	 * @return
	 */
	public String getThumbUrl()
	{
		return thumbUrl;
	}

	/**
	 * 设置thumbUrl
	 * 
	 * @param thumbUrl
	 */
	public void setThumbUrl(String thumbUrl)
	{
		this.thumbUrl = thumbUrl;
	}

	/**
	 * 获取showCoverPic
	 * 
	 * @return
	 */
	public Integer getShowCoverPic()
	{
		return showCoverPic;
	}

	/**
	 * 设置showCoverPic
	 * 
	 * @param showCoverPic
	 */
	public void setShowCoverPic(Integer showCoverPic)
	{
		this.showCoverPic = showCoverPic;
	}

	/**
	 * 获取needOpenComment
	 * 
	 * @return
	 */
	public Integer getNeedOpenComment()
	{
		return needOpenComment;
	}

	/**
	 * 设置needOpenComment
	 * 
	 * @param needOpenComment
	 */
	public void setNeedOpenComment(Integer needOpenComment)
	{
		this.needOpenComment = needOpenComment;
	}

	/**
	 * 获取onlyFansCanComment
	 * 
	 * @return
	 */
	public Integer getOnlyFansCanComment()
	{
		return onlyFansCanComment;
	}

	/**
	 * 设置onlyFansCanComment
	 * 
	 * @param onlyFansCanComment
	 */
	public void setOnlyFansCanComment(Integer onlyFansCanComment)
	{
		this.onlyFansCanComment = onlyFansCanComment;
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
	 * 获取isDeleted
	 * 
	 * @return
	 */
	public Boolean getIsDeleted()
	{
		return isDeleted;
	}

	/**
	 * 设置isDeleted
	 * 
	 * @param isDeleted
	 */
	public void setIsDeleted(Boolean isDeleted)
	{
		this.isDeleted = isDeleted;
	}
}
