package com.mizhousoft.weixin.transfer.service;

import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.transfer.request.MerchantBatchQueryRequest;
import com.mizhousoft.weixin.transfer.request.MerchantDetailQueryRequest;
import com.mizhousoft.weixin.transfer.request.TransferCreateRequest;
import com.mizhousoft.weixin.transfer.request.WxBatchQueryRequest;
import com.mizhousoft.weixin.transfer.request.WxDetailQueryRequest;
import com.mizhousoft.weixin.transfer.result.BatcheQueryResult;
import com.mizhousoft.weixin.transfer.result.DetailQueryResult;
import com.mizhousoft.weixin.transfer.result.TransferCreateResult;

/**
 * 商家转账到零钱（直联商户）
 *
 * @version
 */
public interface MerchantTransferService
{
	/**
	 * 发起商家转账API
	 * <p>
	 * 适用对象：直连商户
	 * 文档详见: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_1.shtml
	 * 请求URL：https://api.mch.weixin.qq.com/v3/transfer/batches
	 * 请求方式：POST
	 * 接口限频： 单个商户 50QPS，如果超过频率限制，会报错FREQUENCY_LIMITED，请降低频率请求。
	 * 是否需要证书：是
	 *
	 * @param request the request
	 * @return transfer create result
	 * @throws WXException the wx pay exception
	 */
	TransferCreateResult createTransfer(TransferCreateRequest request) throws WXException;

	/**
	 * 微信批次单号查询批次单API
	 * <p>
	 * 适用对象：直连商户
	 * 文档详见: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_2.shtml
	 * 请求URL：https://api.mch.weixin.qq.com/v3/transfer/batches/batch-id/{batch_id}
	 * 请求方式：GET
	 * 接口限频： 单个商户 50QPS，如果超过频率限制，会报错FREQUENCY_LIMITED，请降低频率请求。
	 *
	 * @param request the request
	 * @return batches query result
	 * @throws WXException the wx pay exception
	 */
	BatcheQueryResult queryWxBatches(WxBatchQueryRequest request) throws WXException;

	/**
	 * 微信明细单号查询明细单API
	 * <p>
	 * 适用对象：直连商户
	 * 文档详见: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_3.shtml
	 * 请求URL：https://api.mch.weixin.qq.com/v3/transfer/batches/batch-id/{batch_id}/details/detail-id/{detail_id}
	 * 请求方式：GET
	 * 接口限频： 单个商户 50QPS，如果超过频率限制，会报错FREQUENCY_LIMITED，请降低频率请求。
	 *
	 * @param request the request
	 * @return details query result
	 * @throws WXException the wx pay exception
	 */
	DetailQueryResult queryWxDetails(WxDetailQueryRequest request) throws WXException;

	/**
	 * 商家批次单号查询批次单API
	 * <p>
	 * 适用对象：直连商户
	 * 文档详见: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_5.shtml
	 * 请求URL：https://api.mch.weixin.qq.com/v3/transfer/batches/out-batch-no/{out_batch_no}
	 * 请求方式：GET
	 * 接口限频： 单个商户 50QPS，如果超过频率限制，会报错FREQUENCY_LIMITED，请降低频率请求。
	 *
	 * @param request the request
	 * @return batches query result
	 * @throws WXException the wx pay exception
	 */
	BatcheQueryResult queryMerchantBatches(MerchantBatchQueryRequest request) throws WXException;

	/**
	 * 商家明细单号查询明细单API
	 * <p>
	 * 适用对象：直连商户
	 * 文档详见: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_6.shtml
	 * 请求URL：https://api.mch.weixin.qq.com/v3/transfer/batches/out-batch-no/{out_batch_no}/details/out-detail-no/{out_detail_no}
	 * 请求方式：GET
	 * 接口限频： 单个商户 50QPS，如果超过频率限制，会报错FREQUENCY_LIMITED，请降低频率请求。
	 *
	 * @param request the request
	 * @return details query result
	 * @throws WXException the wx pay exception
	 */
	DetailQueryResult queryMerchantDetails(MerchantDetailQueryRequest request) throws WXException;
}
