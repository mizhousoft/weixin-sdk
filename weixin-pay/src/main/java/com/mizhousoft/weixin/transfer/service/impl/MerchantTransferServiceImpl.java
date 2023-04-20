package com.mizhousoft.weixin.transfer.service.impl;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.transfer.request.MerchantBatchQueryRequest;
import com.mizhousoft.weixin.transfer.request.MerchantDetailQueryRequest;
import com.mizhousoft.weixin.transfer.request.TransferCreateRequest;
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
	public BatcheQueryResult queryWxBatches(WxBatchQueryRequest request) throws WXException
	{
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DetailQueryResult queryWxDetails(WxDetailQueryRequest request) throws WXException
	{
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BatcheQueryResult queryMerchantBatches(MerchantBatchQueryRequest request) throws WXException
	{
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DetailQueryResult queryMerchantDetails(MerchantDetailQueryRequest request) throws WXException
	{
		return null;
	}
}
