package com.mizhousoft.boot.weixin.configuration;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.mizhousoft.boot.weixin.properties.WeixinPayListProperties;
import com.mizhousoft.boot.weixin.properties.WeixinPayProperties;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.certificate.CertificateProvider;
import com.mizhousoft.weixin.certificate.impl.CertificateProviderImpl;
import com.mizhousoft.weixin.cipher.impl.CipherServiceImpl;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.WxPayConfig;
import com.mizhousoft.weixin.payment.service.WxPayConfigService;
import com.mizhousoft.weixin.payment.service.WxPayHttpClient;
import com.mizhousoft.weixin.payment.service.WxPaymentService;
import com.mizhousoft.weixin.payment.service.impl.WxPayConfigServiceImpl;
import com.mizhousoft.weixin.payment.service.impl.WxPayHttpClientImpl;
import com.mizhousoft.weixin.payment.service.impl.WxPaymentServiceImpl;
import com.mizhousoft.weixin.transfer.service.MerchantTransferService;
import com.mizhousoft.weixin.transfer.service.impl.MerchantTransferServiceImpl;
import com.mizhousoft.weixin.util.PemLoader;

/**
 * WeixinConfiguration
 *
 * @version
 */
@Configuration
public class WeixinPayConfiguration
{
	@Autowired
	private WeixinPayListProperties listProperties;

	@Autowired
	private RestClientService restClientService;

	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	@ConditionalOnProperty("weixin.pay.merchants[0].identifier")
	public WxPaymentService getWxPaymentService(WxPayConfigService configService, WxPayHttpClient httpClient)
	{
		WxPaymentServiceImpl paymentService = new WxPaymentServiceImpl();
		paymentService.setHttpClient(httpClient);
		paymentService.setConfigService(configService);

		return paymentService;
	}

	@Bean
	@ConditionalOnProperty("weixin.pay.merchants[0].identifier")
	public MerchantTransferService getMerchantTransferService(WxPayConfigService configService, WxPayHttpClient httpClient)
	{
		MerchantTransferServiceImpl merchantTransferService = new MerchantTransferServiceImpl();
		merchantTransferService.setHttpClient(httpClient);
		merchantTransferService.setConfigService(configService);

		return merchantTransferService;
	}

	@Bean
	@ConditionalOnProperty("weixin.pay.merchants[0].identifier")
	public WxPayHttpClient getWxPayHttpClient()
	{
		WxPayHttpClientImpl httpClient = new WxPayHttpClientImpl();
		httpClient.setRestClientService(restClientService);

		return httpClient;
	}

	@Bean
	@ConditionalOnProperty("weixin.pay.merchants[0].identifier")
	public WxPayConfigService getWxPayConfigService() throws IOException, WXException
	{
		WxPayConfigService configService = new WxPayConfigServiceImpl();

		List<WeixinPayProperties> list = listProperties.getMerchants();
		for (WeixinPayProperties item : list)
		{
			List<X509Certificate> certificates = new ArrayList<>(2);

			Resource resource = resourceLoader.getResource("classpath:" + item.getMchCertFilePath());
			String certPemPath = resource.getFile().getAbsolutePath();
			X509Certificate certificate = PemLoader.loadX509FromPath(certPemPath);
			String mchCertSerialNumber = PemLoader.getSerialNumber(certificate);
			certificates.add(certificate);

			resource = resourceLoader.getResource("classpath:" + item.getPlatformCertFilePath());
			certPemPath = resource.getFile().getAbsolutePath();
			certificate = PemLoader.loadX509FromPath(certPemPath);
			String platformCertSerialNumber = PemLoader.getSerialNumber(certificate);
			PublicKey platformPubKey = certificate.getPublicKey();
			certificates.add(certificate);

			CertificateProvider certificateProvider = new CertificateProviderImpl(certificates);

			resource = resourceLoader.getResource("classpath:" + item.getMchPrivFilePath());
			String privKeyPath = resource.getFile().getAbsolutePath();
			PrivateKey privateKey = PemLoader.loadPrivateKeyFromPath(privKeyPath);

			CipherServiceImpl cipherService = new CipherServiceImpl(item.getApiV3Key(), privateKey, platformPubKey, certificateProvider);

			WxPayConfig config = new WxPayConfig();
			config.setIdentifier(item.getIdentifier());
			config.setMchId(item.getMchId());
			config.setMchCertSerialNumber(mchCertSerialNumber);
			config.setPlatformCertSerialNumber(platformCertSerialNumber);
			config.setCipherService(cipherService);
			config.setEndpoint(item.getEndpoint());
			config.setPayNotifyUrl(item.getNotifyUrl());
			config.setRefundNotifyUrl(item.getRefundNotifyUrl());

			configService.addConfig(config);
		}

		return configService;
	}
}
