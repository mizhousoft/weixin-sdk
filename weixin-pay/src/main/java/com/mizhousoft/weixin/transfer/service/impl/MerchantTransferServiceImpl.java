package com.mizhousoft.weixin.transfer.service.impl;

import java.util.List;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.payment.WxPayConfig;
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

import kong.unirest.core.HttpResponse;

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
				String encUserName = payConfig.getCipherService().encryptSensitiveField(userName);
				detail.setUserName(encUserName);
			}

			String body = JSONUtils.toJSONString(request);

			HttpResponse<String> httpResp = httpClient.post(body, canonicalUrl, true, payConfig);

			TransferCreateResult result = JSONUtils.parse(httpResp.getBody(), TransferCreateResult.class);

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

		HttpResponse<String> httpResp = httpClient.get(canonicalUrl, false, payConfig);

		try
		{
			BatcheQueryResult result = JSONUtils.parse(httpResp.getBody(), BatcheQueryResult.class);

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

		HttpResponse<String> httpResp = httpClient.get(canonicalUrl, false, payConfig);

		try
		{
			DetailQueryResult result = JSONUtils.parse(httpResp.getBody(), DetailQueryResult.class);

			String decUserName = payConfig.getCipherService().decryptSensitiveField(result.getUserName());
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

		HttpResponse<String> httpResp = httpClient.get(canonicalUrl, false, payConfig);

		try
		{
			BatcheQueryResult result = JSONUtils.parse(httpResp.getBody(), BatcheQueryResult.class);

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

		HttpResponse<String> httpResp = httpClient.get(canonicalUrl, false, payConfig);

		try
		{
			DetailQueryResult result = JSONUtils.parse(httpResp.getBody(), DetailQueryResult.class);

			String decUserName = payConfig.getCipherService().decryptSensitiveField(result.getUserName());
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
