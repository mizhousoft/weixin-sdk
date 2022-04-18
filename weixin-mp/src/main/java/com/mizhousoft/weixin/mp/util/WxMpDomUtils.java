package com.mizhousoft.weixin.mp.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import com.mizhousoft.weixin.common.WXException;

/**
 * 工具类
 *
 * @version
 */
public abstract class WxMpDomUtils
{
	private static final ThreadLocal<DocumentBuilder> BUILDER_LOCAL = new ThreadLocal<DocumentBuilder>()
	{
		@Override
		protected DocumentBuilder initialValue()
		{
			try
			{
				final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				factory.setExpandEntityReferences(false);
				factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
				return factory.newDocumentBuilder();
			}
			catch (ParserConfigurationException exc)
			{
				throw new IllegalArgumentException(exc);
			}
		}
	};

	public static String extractEncryptPart(String xml) throws WXException
	{
		try
		{
			DocumentBuilder db = BUILDER_LOCAL.get();
			Document document = db.parse(new InputSource(new StringReader(xml)));

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
