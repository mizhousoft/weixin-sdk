package com.mizhousoft.weixin.mp.request;

import java.security.GeneralSecurityException;

import org.junit.Test;

import com.mizhousoft.commons.lang.JAXBUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.mp.domain.message.MpRequestMessage;

/**
 * MpRequestMessage Test
 *
 * @version
 */
public class MpRequestMessageTest
{
	@Test
	public void test() throws GeneralSecurityException, WXException
	{
		String value = "<xml>" + "  <ToUserName><![CDATA[toUser]]></ToUserName>" + "  <FromUserName><![CDATA[FromUser]]></FromUserName>"
		        + "  <CreateTime>123456789</CreateTime>" + "  <MsgType><![CDATA[event]]></MsgType>"
		        + "  <Event><![CDATA[subscribe]]></Event>" + "</xml>";

		MpRequestMessage message = JAXBUtils.xmlToBean(value, MpRequestMessage.class);

		System.out.println(message);
	}
}
