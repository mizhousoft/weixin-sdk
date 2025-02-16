package com.mizhousoft.weixin.common.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import com.mizhousoft.weixin.common.WXException;

/**
 * 工具类
 *
 */
public abstract class WxDomUtils
{
	public static String extractEncryptPart(String xml) throws WXException
	{
		try
		{
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setExpandEntityReferences(false);
			factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(xml)));

			Element root = document.getDocumentElement();

			return root.getElementsByTagName("Encrypt").item(0).getTextContent();
		}
		catch (Exception e)
		{
			throw new WXException("Extract content failed.", e);
		}
	}

	public static String generateXml(String encrypt, String signature, String timestamp, String nonce)
	{
		String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n" + "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
		        + "<TimeStamp>%3$s</TimeStamp>\n" + "<Nonce><![CDATA[%4$s]]></Nonce>\n" + "</xml>";
		return String.format(format, encrypt, signature, timestamp, nonce);
	}
}
