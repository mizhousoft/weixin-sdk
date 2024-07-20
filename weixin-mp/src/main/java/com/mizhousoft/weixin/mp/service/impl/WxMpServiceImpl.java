package com.mizhousoft.weixin.mp.service.impl;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.model.WxAccessToken;
import com.mizhousoft.weixin.mp.config.WxMpConfig;
import com.mizhousoft.weixin.mp.service.WxMpFreePublishService;
import com.mizhousoft.weixin.mp.service.WxMpMaterialService;
import com.mizhousoft.weixin.mp.service.WxMpMenuService;
import com.mizhousoft.weixin.mp.service.WxMpService;
import com.mizhousoft.weixin.mp.service.WxMpTemplateMsgService;
import com.mizhousoft.weixin.mp.service.WxMpUserService;
import com.mizhousoft.weixin.mp.util.WxMpCryptUtils;
import com.mizhousoft.weixin.mp.util.WxMpDomUtils;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 微信公众号服务
 *
 */
public class WxMpServiceImpl implements WxMpService
{
	// 公众号配置
	private WxMpConfig config;

	// 访问Token
	private volatile String accessToken;

	// Token过期时间
	private volatile long expiresTime;

	// WxMpUserService
	private WxMpUserService mpUserService = new WxMpUserServiceImpl(this);

	// WxMpMaterialService
	private WxMpMaterialService materialService = new WxMpMaterialServiceImpl(this);

	// WxMpFreePublishService
	private WxMpFreePublishService freePublishService = new WxMpFreePublishServiceImpl(this);

	// WxMpTemplateMsgService
	private WxMpTemplateMsgService templateMsgService = new WxMpTemplateMsgServiceImpl(this);

	// WxMpMenuService
	private WxMpMenuService menuService = new WxMpMenuServiceImpl(this);

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
	public boolean checkSignature(String timeStamp, String nonce, String signature)
	{
		String[] values = { config.getToken(), timeStamp, nonce };

		String shaValue = WxMpCryptUtils.sha1Sign(values);

		return (shaValue.equals(signature));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String decryptMsg(String msgSignature, String timeStamp, String nonce, String postData) throws WXException
	{
		String cipherText = WxMpDomUtils.extractEncryptPart(postData);

		String[] values = { config.getToken(), timeStamp, nonce };
		String shaValue = WxMpCryptUtils.sha1Sign(values);
		if (!shaValue.equals(msgSignature))
		{
			throw new WXException("Signature is wrong.");
		}

		String plainXml = WxMpCryptUtils.decrypt(cipherText, Base64.decodeBase64(config.getAesKey()));

		return plainXml;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String encryptMsg(String replyMsg) throws WXException
	{
		String encrypt = WxMpCryptUtils.encrypt(RandomGenerator.genHexString(8, true), replyMsg, config.getAppId(),
		        Base64.decodeBase64(config.getAesKey()));

		String timeStamp = Long.toString(System.currentTimeMillis() / 1000L);
		String nonce = RandomGenerator.genHexString(8, true);

		String signature = WxMpCryptUtils.sha1Sign(config.getToken(), timeStamp, nonce);

		return WxMpDomUtils.generateXml(encrypt, signature, timeStamp, nonce);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized String getAccessToken() throws WXException
	{
		if (isAccessTokenExpired())
		{
			String url = String.format(GET_ACCESS_TOKEN_URL, config.getAppId(), config.getAppSecret());

			try
			{
				String responseContent = Unirest.get(url).asString().getBody();

				WxAccessToken wxAccessToken = JSONUtils.parse(responseContent, WxAccessToken.class);

				if (!StringUtils.isBlank(wxAccessToken.getErrorCode()))
				{
					throw new WXException(wxAccessToken.getErrorCode(), wxAccessToken.getErrorMsg());
				}

				this.accessToken = wxAccessToken.getAccessToken();
				this.expiresTime = System.currentTimeMillis() + (wxAccessToken.getExpiresIn() - 200) * 1000L;
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

		return this.accessToken;
	}

	private boolean isAccessTokenExpired()
	{
		return (System.currentTimeMillis() > this.expiresTime);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpUserService getWxMpUserService()
	{
		return mpUserService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpMaterialService getWxMpMaterialService()
	{
		return materialService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpFreePublishService getWxMpFreePublishService()
	{
		return freePublishService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpTemplateMsgService getWxMpTemplateMsgService()
	{
		return templateMsgService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WxMpMenuService getWxMpMenuService()
	{
		return menuService;
	}

	/**
	 * 设置config
	 * 
	 * @param config
	 */
	public void setConfig(WxMpConfig config)
	{
		this.config = config;
	}
}
