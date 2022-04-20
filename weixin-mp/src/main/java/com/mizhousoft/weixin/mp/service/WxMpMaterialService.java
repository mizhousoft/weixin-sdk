package com.mizhousoft.weixin.mp.service;

import java.io.InputStream;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialCountResult;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialFileBatchGetResult;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialNews;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialNewsBatchGetResult;
import com.mizhousoft.weixin.mp.domain.material.WxMpMaterialVideoInfoResult;

/**
 * 素材服务
 *
 * @version
 */
public interface WxMpMaterialService
{
	String API_URL_PREFIX = "https://api.weixin.qq.com/cgi-bin/material";

	/**
	 * 获取视频永久素材的信息和下载地址
	 * 
	 * @param mediaId 永久素材的id
	 * @return
	 * @throws WXException
	 */
	WxMpMaterialVideoInfoResult materialVideoInfo(String mediaId) throws WXException;

	/**
	 * 获取声音或者图片永久素材
	 * 
	 * @param mediaId
	 * @return
	 * @throws WXException
	 */
	InputStream materialImageOrVoiceDownload(String mediaId) throws WXException;

	/**
	 * 获取图文永久素材的信息
	 * 
	 * @param mediaId
	 * @return
	 * @throws WXException
	 */
	WxMpMaterialNews materialNewsInfo(String mediaId) throws WXException;

	/**
	 * 获取各类素材总数
	 * 1.永久素材的总数，也会计算公众平台官网素材管理中的素材
	 * 2.图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000
	 * 
	 * @return
	 * @throws WXException
	 */
	WxMpMaterialCountResult materialCount() throws WXException;

	/**
	 * 分页获取图文素材列表
	 * 
	 * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count 返回素材的数量，取值在1到20之间
	 * @return
	 * @throws WXException
	 */
	WxMpMaterialNewsBatchGetResult materialNewsBatchGet(int offset, int count) throws WXException;

	/**
	 * 分页获取其他媒体素材列表
	 * 
	 * @param type 媒体类型
	 * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
	 * @param count 返回素材的数量，取值在1到20之间
	 * @return
	 * @throws WXException
	 */
	WxMpMaterialFileBatchGetResult materialFileBatchGet(String type, int offset, int count) throws WXException;
}
