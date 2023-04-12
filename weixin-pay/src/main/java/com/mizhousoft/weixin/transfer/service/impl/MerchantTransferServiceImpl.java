package com.mizhousoft.weixin.transfer.service.impl;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.transfer.request.MerchantBatchesQueryRequest;
import com.mizhousoft.weixin.transfer.request.MerchantDetailsQueryRequest;
import com.mizhousoft.weixin.transfer.request.TransferCreateRequest;
import com.mizhousoft.weixin.transfer.request.WxBatchesQueryRequest;
import com.mizhousoft.weixin.transfer.request.WxDetailsQueryRequest;
import com.mizhousoft.weixin.transfer.result.BatchesQueryResult;
import com.mizhousoft.weixin.transfer.result.DetailsQueryResult;
import com.mizhousoft.weixin.transfer.result.TransferCreateResult;
import com.mizhousoft.weixin.transfer.service.MerchantTransferService;

/**
 * 商家转账到零钱（直联商户）
 *
 * @version
 */
public class MerchantTransferServiceImpl implements MerchantTransferService
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TransferCreateResult createTransfer(TransferCreateRequest request) throws WXException
	{
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BatchesQueryResult queryWxBatches(WxBatchesQueryRequest request) throws WXException
	{
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DetailsQueryResult queryWxDetails(WxDetailsQueryRequest request) throws WXException
	{
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BatchesQueryResult queryMerchantBatches(MerchantBatchesQueryRequest request) throws WXException
	{
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DetailsQueryResult queryMerchantDetails(MerchantDetailsQueryRequest request) throws WXException
	{
		return null;
	}
}
