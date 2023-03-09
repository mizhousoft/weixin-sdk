package com.mizhousoft.weixin.mp.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.freepublish.WxMpFreePublishInfo;
import com.mizhousoft.weixin.mp.domain.freepublish.WxMpFreePublishList;

/**
 * 微信 发布能力 接口.
 *
 * @version
 */
public interface WxMpFreePublishService
{
	String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/freepublish";

	/**
	 * 通过 article_id 获取已发布文章
	 *
	 * @param articleId 要获取的草稿的article_id
	 * @return 已发布文章信息
	 * @throws WXException .
	 */
	WxMpFreePublishInfo getArticleFromId(String articleId) throws WXException;

	/**
	 * 获取成功发布列表 - 支持选择是否返回：图文消息的具体内容
	 *
	 * @param offset 分页页数，从0开始 从全部素材的该偏移位置开始返回，0表示从第一个素材返回
	 * @param count 每页数量 返回素材的数量，取值在1到20之间
	 * @param noContent 是否返回内容
	 * @return 草稿信息列表
	 * @throws WXException .
	 */
	WxMpFreePublishList getPublicationRecords(int offset, int count, boolean noContent) throws WXException;

	/**
	 * 获取成功发布列表 - 默认返回 图文消息的具体内容
	 *
	 * @param offset 分页页数，从0开始 从全部素材的该偏移位置开始返回，0表示从第一个素材返回
	 * @param count 每页数量 返回素材的数量，取值在1到20之间
	 * @return
	 * @throws WXException
	 */
	WxMpFreePublishList getPublicationRecords(int offset, int count) throws WXException;
}
