package com.mizhousoft.weixin.mp.domain.material;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mizhousoft.weixin.common.WxError;

/**
 * 素材总数结果
 *
 */
public class WxMpMaterialCountResult extends WxError
{
	// 语音总数量
	@JsonProperty("voice_count")
	private int voiceCount;

	// 视频总数量
	@JsonProperty("video_count")
	private int videoCount;

	// 图片总数量
	@JsonProperty("image_count")
	private int imageCount;

	// 图文总数量
	@JsonProperty("news_count")
	private int newsCount;

	/**
	 * 获取voiceCount
	 * 
	 * @return
	 */
	public int getVoiceCount()
	{
		return voiceCount;
	}

	/**
	 * 设置voiceCount
	 * 
	 * @param voiceCount
	 */
	public void setVoiceCount(int voiceCount)
	{
		this.voiceCount = voiceCount;
	}

	/**
	 * 获取videoCount
	 * 
	 * @return
	 */
	public int getVideoCount()
	{
		return videoCount;
	}

	/**
	 * 设置videoCount
	 * 
	 * @param videoCount
	 */
	public void setVideoCount(int videoCount)
	{
		this.videoCount = videoCount;
	}

	/**
	 * 获取imageCount
	 * 
	 * @return
	 */
	public int getImageCount()
	{
		return imageCount;
	}

	/**
	 * 设置imageCount
	 * 
	 * @param imageCount
	 */
	public void setImageCount(int imageCount)
	{
		this.imageCount = imageCount;
	}

	/**
	 * 获取newsCount
	 * 
	 * @return
	 */
	public int getNewsCount()
	{
		return newsCount;
	}

	/**
	 * 设置newsCount
	 * 
	 * @param newsCount
	 */
	public void setNewsCount(int newsCount)
	{
		this.newsCount = newsCount;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("{\"voiceCount\":\"");
		builder.append(voiceCount);
		builder.append("\", \"videoCount\":\"");
		builder.append(videoCount);
		builder.append("\", \"imageCount\":\"");
		builder.append(imageCount);
		builder.append("\", \"newsCount\":\"");
		builder.append(newsCount);
		builder.append("\", \"errorCode\":\"");
		builder.append(errorCode);
		builder.append("\", \"errorMsg\":\"");
		builder.append(errorMsg);
		builder.append("\"}");
		return builder.toString();
	}
}
