package com.mizhousoft.weixin.payment.service;

import java.security.cert.X509Certificate;

/**
 * 根据序列号获取证书
 *
 * @version
 */
public interface CertificateProvider
{
	/**
	 * 根据证书序列号获取证书
	 *
	 * @param serialNumber 微信支付平台证书序列号
	 * @return X.509证书实例
	 */
	X509Certificate getCertificate(String serialNumber);
}
