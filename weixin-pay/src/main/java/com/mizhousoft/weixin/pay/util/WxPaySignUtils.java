package com.mizhousoft.weixin.pay.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.crypto.CryptoException;
import com.mizhousoft.commons.crypto.digest.HmacSHA256Digest;
import com.mizhousoft.commons.lang.CharEncoding;
import com.mizhousoft.commons.lang.HexUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.WXSignException;
import com.mizhousoft.weixin.pay.constant.WxPaySignType;
import com.mizhousoft.weixin.pay.internal.WxBasePayRequest;
import com.mizhousoft.weixin.pay.result.WxBasePayResult;

/**
 * 支付签名工具
 *
 * @version
 */
public class WxPaySignUtils
{
	private static final List<String> sList = Arrays.asList("sign", "key");

	public static void checkSign(Object xmlBean, String signType, String signKey) throws WXException
	{
		checkSign(xmlBean2Map(xmlBean), signType, signKey);
	}

	public static void checkSign(Map<String, String> params, String signType, String signKey) throws WXException
	{
		String sign = createSign(params, signType, signKey, new String[0]);
		if (!sign.equals(params.get("sign")))
		{
			throw new WXSignException("Sign failed.");
		}
	}

	public static String createSign(Object xmlBean, String signType, String signKey, String[] ignoredParams) throws WXException
	{
		return createSign(xmlBean2Map(xmlBean), signType, signKey, ignoredParams);
	}

	public static String createSign(Map<String, String> params, String signType, String signKey, String[] ignoredParams) throws WXException
	{
		try
		{
			SortedMap<String, String> sortedMap = new TreeMap<>(params);

			StringBuilder toSign = new StringBuilder();
			for (String key : sortedMap.keySet())
			{
				String value = params.get(key);
				boolean shouldSign = false;
				if (StringUtils.isNotEmpty(value) && !ArrayUtils.contains(ignoredParams, key) && !sList.contains(key))
				{
					shouldSign = true;
				}

				if (shouldSign)
				{
					toSign.append(key).append("=").append(value).append("&");
				}
			}

			toSign.append("key=").append(signKey);

			String signStr = toSign.toString();

			if (WxPaySignType.HMAC_SHA256.equals(signType))
			{
				byte[] bytes = HmacSHA256Digest.hash(signKey.getBytes(CharEncoding.UTF8), signStr.getBytes(CharEncoding.UTF8));
				String hashValue = HexUtils.encodeHexString(bytes, false);

				return hashValue;
			}
			else
			{
				return DigestUtils.md5Hex(signStr.getBytes(CharEncoding.UTF8)).toUpperCase();
			}
		}
		catch (CryptoException e)
		{
			throw new WXException(e.getMessage(), e);
		}
	}

	public static Map<String, String> xmlBean2Map(Object bean) throws WXException
	{
		Map<String, String> result = new HashMap<>(10);
		List<Field> fields = new ArrayList<>(Arrays.asList(bean.getClass().getDeclaredFields()));
		fields.addAll(Arrays.asList(bean.getClass().getSuperclass().getDeclaredFields()));
		if (bean.getClass().getSuperclass().getSuperclass() == WxBasePayRequest.class)
		{
			fields.addAll(Arrays.asList(WxBasePayRequest.class.getDeclaredFields()));
		}

		if (bean.getClass().getSuperclass().getSuperclass() == WxBasePayResult.class)
		{
			fields.addAll(Arrays.asList(WxBasePayResult.class.getDeclaredFields()));
		}

		for (Field field : fields)
		{
			try
			{
				boolean isAccessible = field.canAccess(bean);
				field.setAccessible(true);
				if (field.get(bean) == null)
				{
					field.setAccessible(isAccessible);
					continue;
				}

				if (field.isAnnotationPresent(XmlElement.class))
				{
					result.put(field.getAnnotation(XmlElement.class).name(), field.get(bean).toString());
				}
				else if (!Modifier.isStatic(field.getModifiers()))
				{
					// 忽略掉静态成员变量
					result.put(field.getName(), field.get(bean).toString());
				}

				field.setAccessible(isAccessible);
			}
			catch (SecurityException | IllegalArgumentException | IllegalAccessException e)
			{
				throw new WXException(e.getMessage(), e);
			}
		}

		return result;
	}
}
