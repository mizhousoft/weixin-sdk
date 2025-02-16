package com.mizhousoft.weixin.miniapp.service.impl;

import org.apache.commons.codec.binary.Base64;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.util.WxCryptUtils;
import com.mizhousoft.weixin.common.util.WxDomUtils;
import com.mizhousoft.weixin.miniapp.config.MiniAppConfig;
import com.mizhousoft.weixin.miniapp.model.WxJscode2SessionResult;
import com.mizhousoft.weixin.miniapp.service.WxMiniAppService;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 微信小程序服务
 *
 */
public class WxMiniAppServiceImpl implements WxMiniAppService
{
	// 配置
	private MiniAppConfig config;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAppId()
	{
		return config.getAppId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxJscode2SessionResult jsCode2Session(String jsCode) throws WXException
	{
		String url = String.format(JSCODE_TO_SESSION_URL, config.getAppId(), config.getAppSecret(), jsCode);

		try
		{
			String responseContent = Unirest.get(url).asString().getBody();

			return JSONUtils.parse(responseContent, WxJscode2SessionResult.class);
		}
		catch (UnirestException e)
		{
			throw new WXException(e.getMessage(), e);
		}
		catch (JSONException e)
		{
			throw new WXException(e.getErrorCode(), e.getCodeParams(), e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkSignature(String timeStamp, String nonce, String signature)
	{
		String[] values = { config.getToken(), timeStamp, nonce };

		String shaValue = WxCryptUtils.sha1Sign(values);

		return (shaValue.equals(signature));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String decryptMsg(String msgSignature, String timeStamp, String nonce, String postData) throws WXException
	{
		String cipherText = WxDomUtils.extractEncryptPart(postData);

		String[] values = { config.getToken(), timeStamp, nonce };
		String shaValue = WxCryptUtils.sha1Sign(values);
		if (!shaValue.equals(msgSignature))
		{
			throw new WXException("Signature is wrong.");
		}

		String plainXml = WxCryptUtils.decrypt(cipherText, Base64.decodeBase64(config.getAesKey()));

		return plainXml;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encryptMsg(String replyMsg) throws WXException
	{
		String encrypt = WxCryptUtils.encrypt(RandomGenerator.genHexString(8, true), replyMsg, config.getAppId(),
		        Base64.decodeBase64(config.getAesKey()));

		String timeStamp = Long.toString(System.currentTimeMillis() / 1000L);
		String nonce = RandomGenerator.genHexString(8, true);

		String signature = WxCryptUtils.sha1Sign(config.getToken(), timeStamp, nonce);

		return WxDomUtils.generateXml(encrypt, signature, timeStamp, nonce);
	}

	/**
	 * 设置config
	 * 
	 * @param config
	 */
	public void setConfig(MiniAppConfig config)
	{
		this.config = config;
	}
}
