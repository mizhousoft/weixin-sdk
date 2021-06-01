package com.mizhousoft.weixin.pay;

import com.mizhousoft.commons.restclient.KeyStoreLoader;
import com.mizhousoft.commons.restclient.TruststoreLoader;
import com.mizhousoft.commons.restclient.service.impl.HttpsRestClientServiceImpl;
import com.mizhousoft.weixin.pay.config.WxPayConfig;
import com.mizhousoft.weixin.pay.constant.WxPaySignType;
import com.mizhousoft.weixin.pay.request.IPayUnifiedOrderRequest;
import com.mizhousoft.weixin.pay.request.IWxPayRefundRequest;
import com.mizhousoft.weixin.pay.result.WxPayRefundResult;
import com.mizhousoft.weixin.pay.result.WxPayUnifiedOrderResult;
import com.mizhousoft.weixin.pay.service.impl.WxPayServiceImpl;

/**
 * 
 *
 * @version
 */
public class WxPayServiceImplTest
{
	public static void main(String[] args) throws Exception
	{
		WxPayConfig wxPayConfig = new WxPayConfig();
		wxPayConfig.setMchId("");
		wxPayConfig.setMchKey("");
		wxPayConfig.setPayNotifyUrl("");
		wxPayConfig.setSignType(WxPaySignType.HMAC_SHA256);

		HttpsTruststoreLoader truststoreLoader = new HttpsTruststoreLoader();
		truststoreLoader.loadTrustStore();

		TruststoreLoader[] truststoreLoaders = { truststoreLoader };
		KeyStoreLoader[] keyStoreLoaders = { new HttpsP12Loader() };

		HttpsRestClientServiceImpl restClientService = new HttpsRestClientServiceImpl();
		restClientService.setTruststoreLoaders(truststoreLoaders);
		restClientService.setKeyStoreLoaders(keyStoreLoaders);
		restClientService.init();

		WxPayServiceImpl wxPayService = new WxPayServiceImpl();
		wxPayService.setRestClientService(restClientService);
		wxPayService.setWxPayConfig(wxPayConfig);

		IPayUnifiedOrderRequest request = new IPayUnifiedOrderRequest();
		request.setAppId("");
		request.setBody("购买VIP会员");
		request.setDetail("2年VIP会员");
		request.setOutTradeNo("" + System.currentTimeMillis());
		request.setSpbillCreateIp("113.12.12.113");
		request.setTotalFee(10);

		WxPayUnifiedOrderResult result = wxPayService.unifiedOrder(request);
		System.out.println(result.getReturnMsg());
		System.out.println(result.getReturnCode());

		IWxPayRefundRequest refundReq = new IWxPayRefundRequest();
		refundReq.setRefundDesc("用户觉得VIP不好");
		refundReq.setRefundFee(20);
		refundReq.setTotalFee(20);
		refundReq.setOutTradeNo("10201912041651044026604");
		refundReq.setOutRefundNo(String.valueOf(System.currentTimeMillis()));

		WxPayRefundResult res = wxPayService.refund(refundReq);
		System.out.println(res.getReturnMsg());
		System.out.println(res.getReturnCode());
	}
}
