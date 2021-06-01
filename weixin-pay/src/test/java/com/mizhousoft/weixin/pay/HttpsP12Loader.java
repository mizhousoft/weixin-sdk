package com.mizhousoft.weixin.pay;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

import com.mizhousoft.commons.restclient.KeyStoreLoader;

/**
 * HttpsP12Loader
 *
 * @version
 */
public class HttpsP12Loader implements KeyStoreLoader
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyStore loadKeyStore() throws GeneralSecurityException
	{
		try
		{
			InputStream instream = HttpsP12Loader.class.getClassLoader().getResourceAsStream("apiclient_cert.p12");

			try
			{
				KeyStore keystore = KeyStore.getInstance("PKCS12");
				keystore.load(instream, "".toCharArray());

				return keystore;
			}
			finally
			{
				instream.close();
			}
		}
		catch (IOException e)
		{
			throw new GeneralSecurityException("Load https p12 failed.");
		}
	}

	@Override
	public char[] getKeyPassword()
	{
		return "".toCharArray();
	}
}
