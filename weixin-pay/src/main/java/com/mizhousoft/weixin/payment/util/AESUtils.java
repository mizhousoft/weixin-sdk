package com.mizhousoft.weixin.payment.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.mizhousoft.weixin.common.WXException;

/**
 * 解密工具
 *
 * @version
 */
public abstract class AESUtils
{
	public static String decryptToString(String associatedData, String nonce, String ciphertext, String apiV3Key) throws WXException
	{
		try
		{
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

			SecretKeySpec key = new SecretKeySpec(apiV3Key.getBytes(), "AES");
			GCMParameterSpec spec = new GCMParameterSpec(128, nonce.getBytes());

			cipher.init(Cipher.DECRYPT_MODE, key, spec);
			cipher.updateAAD(associatedData.getBytes());

			return new String(cipher.doFinal(Base64.getDecoder().decode(ciphertext)), StandardCharsets.UTF_8);
		}
		catch (NoSuchAlgorithmException | NoSuchPaddingException e)
		{
			throw new WXException(e.getMessage(), e);
		}
		catch (InvalidKeyException | InvalidAlgorithmParameterException e)
		{
			throw new WXException(e.getMessage(), e);
		}
		catch (IllegalBlockSizeException e)
		{
			throw new WXException(e.getMessage(), e);
		}
		catch (BadPaddingException e)
		{
			throw new WXException(e.getMessage(), e);
		}
	}
}
