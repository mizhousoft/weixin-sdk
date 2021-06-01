package com.mizhousoft.weixin.mp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mizhousoft.weixin.mp.serializer.NumericBooleanDeserializer;

/**
 * 图文消息article
 *
 * @version
 */
public class WxMpNewsArticle
{
	// 图文消息的封面图片素材id（必须是永久mediaID）
	@JsonProperty("thumb_media_id")
	private String thumbMediaId;

	// 图文消息的封面url
	@JsonProperty("thumb_url")
	private String thumbUrl;

	// 图文消息的作者.
	@JsonProperty("author")
	private String author;

	// 图文消息的标题.
	@JsonProperty("title")
	private String title;

	// 在图文消息页面点击“阅读原文”后的页面链接.
	@JsonProperty("content_source_url")
	private String contentSourceUrl;

	// (必填) 图文消息页面的内容，支持HTML标签.
	@JsonProperty("content")
	private String content;

	// 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
	@JsonProperty("digest")
	private String digest;

	// 是否显示封面，0为false，即不显示，1为true，即显示
	@JsonProperty("show_cover_pic")
	@JsonDeserialize(using = NumericBooleanDeserializer.class)
	private boolean showCoverPic;

	// 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
	@JsonProperty("url")
	private String url;

	// 是否打开评论，0不打开，1打开.
	@JsonProperty("need_open_comment")
	@JsonDeserialize(using = NumericBooleanDeserializer.class)
	private boolean needOpenComment;

	// 是否粉丝才可评论，0所有人可评论，1粉丝才可评论.
	@JsonProperty("only_fans_can_comment")
	@JsonDeserialize(using = NumericBooleanDeserializer.class)
	private boolean onlyFansCanComment;

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
	 * 获取showCoverPic
	 * 
	 * @return
	 */
	public boolean isShowCoverPic()
	{
		return showCoverPic;
	}

	/**
	 * 设置showCoverPic
	 * 
	 * @param showCoverPic
	 */
	public void setShowCoverPic(boolean showCoverPic)
	{
		this.showCoverPic = showCoverPic;
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
	 * 获取needOpenComment
	 * 
	 * @return
	 */
	public boolean isNeedOpenComment()
	{
		return needOpenComment;
	}

	/**
	 * 设置needOpenComment
	 * 
	 * @param needOpenComment
	 */
	public void setNeedOpenComment(boolean needOpenComment)
	{
		this.needOpenComment = needOpenComment;
	}

	/**
	 * 获取onlyFansCanComment
	 * 
	 * @return
	 */
	public boolean isOnlyFansCanComment()
	{
		return onlyFansCanComment;
	}

	/**
	 * 设置onlyFansCanComment
	 * 
	 * @param onlyFansCanComment
	 */
	public void setOnlyFansCanComment(boolean onlyFansCanComment)
	{
		this.onlyFansCanComment = onlyFansCanComment;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"thumbMediaId\":\"");
		builder.append(thumbMediaId);
		builder.append("\", \"thumbUrl\":\"");
		builder.append(thumbUrl);
		builder.append("\", \"author\":\"");
		builder.append(author);
		builder.append("\", \"title\":\"");
		builder.append(title);
		builder.append("\", \"contentSourceUrl\":\"");
		builder.append(contentSourceUrl);
		builder.append("\", \"digest\":\"");
		builder.append(digest);
		builder.append("\", \"showCoverPic\":\"");
		builder.append(showCoverPic);
		builder.append("\", \"url\":\"");
		builder.append(url);
		builder.append("\", \"needOpenComment\":\"");
		builder.append(needOpenComment);
		builder.append("\", \"onlyFansCanComment\":\"");
		builder.append(onlyFansCanComment);
		builder.append("\"}");
		return builder.toString();
	}
}
