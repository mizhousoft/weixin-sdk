package com.mizhousoft.weixin.transfer.service.impl;

import java.util.List;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.RestResponse;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.WxPayConfig;
import com.mizhousoft.weixin.payment.constant.HttpConstants;
import com.mizhousoft.weixin.payment.service.WxPayConfigService;
import com.mizhousoft.weixin.payment.service.WxPayHttpClient;
import com.mizhousoft.weixin.transfer.request.MerchantBatchQueryRequest;
import com.mizhousoft.weixin.transfer.request.MerchantDetailQueryRequest;
import com.mizhousoft.weixin.transfer.request.TransferCreateRequest;
import com.mizhousoft.weixin.transfer.request.TransferCreateRequest.TransferDetailList;
import com.mizhousoft.weixin.transfer.request.WxBatchQueryRequest;
import com.mizhousoft.weixin.transfer.request.WxDetailQueryRequest;
import com.mizhousoft.weixin.transfer.result.BatcheQueryResult;
import com.mizhousoft.weixin.transfer.result.DetailQueryResult;
import com.mizhousoft.weixin.transfer.result.TransferCreateResult;
import com.mizhousoft.weixin.transfer.service.MerchantTransferService;

/**
 * 商家转账到零钱（直联商户）
 *
 * @version
 */
public class MerchantTransferServiceImpl implements MerchantTransferService
{
	private WxPayConfigService configService;

	private WxPayHttpClient httpClient;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TransferCreateResult createTransfer(String mchId, TransferCreateRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);

		String canonicalUrl = "/v3/transfer/batches";

		try
		{
			List<TransferDetailList> detailList = request.getTransferDetailList();
			for (TransferDetailList detail : detailList)
			{
				String userName = detail.getUserName();
				String encUserName = payConfig.getEncryptor().encrypt(userName);
				detail.setUserName(encUserName);
			}

			String body = JSONUtils.toJSONString(request);

			RestResponse restResp = httpClient.executeRequest(body, canonicalUrl, HttpConstants.HTTP_METHOD_POST, true, payConfig);

			TransferCreateResult result = JSONUtils.parse(restResp.getBody(), TransferCreateResult.class);

			return result;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BatcheQueryResult queryWxBatches(String mchId, WxBatchQueryRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);

		String canonicalUrl = String.format("/v3/transfer/batches/batch-id/%s?need_query_detail=%b", request.getBatchId(),
		        request.getNeedQueryDetail());

		if (request.getOffset() != null)
		{
			canonicalUrl = String.format("%s&offset=%d", canonicalUrl, request.getOffset());
		}
		if (request.getLimit() != null)
		{
			canonicalUrl = String.format("%s&limit=%d", canonicalUrl, request.getLimit());
		}
		if (request.getDetailStatus() != null && request.getDetailStatus().length() != 0)
		{
			canonicalUrl = String.format("%s&detail_status=%s", canonicalUrl, request.getDetailStatus());
		}

		RestResponse restResp = httpClient.executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, false, payConfig);

		try
		{
			BatcheQueryResult result = JSONUtils.parse(restResp.getBody(), BatcheQueryResult.class);

			return result;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DetailQueryResult queryWxDetails(String mchId, WxDetailQueryRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);

		String canonicalUrl = String.format("/v3/transfer/batches/batch-id/%s/details/detail-id/%s", request.getBatchId(),
		        request.getDetailId());

		RestResponse restResp = httpClient.executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, false, payConfig);

		try
		{
			DetailQueryResult result = JSONUtils.parse(restResp.getBody(), DetailQueryResult.class);

			String decUserName = payConfig.getDecryptor().decrypt(result.getUserName());
			result.setUserName(decUserName);

			return result;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BatcheQueryResult queryMerchantBatches(String mchId, MerchantBatchQueryRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);

		String canonicalUrl = String.format("/v3/transfer/batches/out-batch-no/%s?need_query_detail=%b", request.getOutBatchNo(),
		        request.getNeedQueryDetail());

		if (request.getOffset() != null)
		{
			canonicalUrl = String.format("%s&offset=%d", canonicalUrl, request.getOffset());
		}
		if (request.getLimit() != null)
		{
			canonicalUrl = String.format("%s&limit=%d", canonicalUrl, request.getLimit());
		}
		if (request.getDetailStatus() != null && request.getDetailStatus().length() != 0)
		{
			canonicalUrl = String.format("%s&detail_status=%s", canonicalUrl, request.getDetailStatus());
		}

		RestResponse restResp = httpClient.executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, false, payConfig);

		try
		{
			BatcheQueryResult result = JSONUtils.parse(restResp.getBody(), BatcheQueryResult.class);

			return result;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DetailQueryResult queryMerchantDetails(String mchId, MerchantDetailQueryRequest request) throws WXException
	{
		WxPayConfig payConfig = configService.getByMchId(mchId);

		String canonicalUrl = String.format("/v3/transfer/batches/out-batch-no/%s/details/out-detail-no/%s", request.getOutBatchNo(),
		        request.getOutDetailNo());

		RestResponse restResp = httpClient.executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, false, payConfig);

		try
		{
			DetailQueryResult result = JSONUtils.parse(restResp.getBody(), DetailQueryResult.class);

			String decUserName = payConfig.getDecryptor().decrypt(result.getUserName());
			result.setUserName(decUserName);

			return result;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	/**
	 * 设置configService
	 * 
	 * @param configService
	 */
	public void setConfigService(WxPayConfigService configService)
	{
		this.configService = configService;
	}

	/**
	 * 设置httpClient
	 * 
	 * @param httpClient
	 */
	public void setHttpClient(WxPayHttpClient httpClient)
	{
		this.httpClient = httpClient;
	}
}
