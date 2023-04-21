package com.mizhousoft.weixin.transfer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.restclient.RestResponse;
import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.weixin.cipher.PrivacyDecryptor;
import com.mizhousoft.weixin.cipher.PrivacyEncryptor;
import com.mizhousoft.weixin.cipher.WxPayVerifier;
import com.mizhousoft.weixin.common.WXException;
import com.mizhousoft.weixin.common.WXSystemErrorException;
import com.mizhousoft.weixin.common.WxFrequencyLimitedException;
import com.mizhousoft.weixin.credential.WxPayCredential;
import com.mizhousoft.weixin.payment.constant.HttpConstants;
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
	private RestClientService restClientService;

	private PrivacyEncryptor encryptor;

	private PrivacyDecryptor decryptor;

	private WxPayCredential credential;

	private WxPayVerifier verifier;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TransferCreateResult createTransfer(TransferCreateRequest request) throws WXException
	{
		String canonicalUrl = "/v3/transfer/batches";

		try
		{
			List<TransferDetailList> detailList = request.getTransferDetailList();
			for (TransferDetailList detail : detailList)
			{
				String userName = detail.getUserName();
				String encUserName = encryptor.encrypt(userName);
				detail.setUserName(encUserName);
			}

			String body = JSONUtils.toJSONString(request);

			RestResponse restResp = executeRequest(body, canonicalUrl, HttpConstants.HTTP_METHOD_POST, true);

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
	public BatcheQueryResult queryWxBatches(WxBatchQueryRequest request) throws WXException
	{
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

		RestResponse restResp = executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, false);

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
	public DetailQueryResult queryWxDetails(WxDetailQueryRequest request) throws WXException
	{
		String canonicalUrl = String.format("/v3/transfer/batches/batch-id/%s/details/detail-id/%s", request.getBatchId(),
		        request.getDetailId());

		RestResponse restResp = executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, false);

		try
		{
			DetailQueryResult result = JSONUtils.parse(restResp.getBody(), DetailQueryResult.class);

			String decUserName = decryptor.decrypt(result.getUserName());
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
	public BatcheQueryResult queryMerchantBatches(MerchantBatchQueryRequest request) throws WXException
	{
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

		RestResponse restResp = executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, false);

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
	public DetailQueryResult queryMerchantDetails(MerchantDetailQueryRequest request) throws WXException
	{
		String canonicalUrl = String.format("/v3/transfer/batches/out-batch-no/%s/details/out-detail-no/%s", request.getOutBatchNo(),
		        request.getOutDetailNo());

		RestResponse restResp = executeRequest(null, canonicalUrl, HttpConstants.HTTP_METHOD_GET, false);

		try
		{
			DetailQueryResult result = JSONUtils.parse(restResp.getBody(), DetailQueryResult.class);

			String decUserName = decryptor.decrypt(result.getUserName());
			result.setUserName(decUserName);

			return result;
		}
		catch (JSONException e)
		{
			throw new WXException("JSON to object failed.", e);
		}
	}

	private RestResponse executeRequest(String body, String canonicalUrl, String httpMethod, boolean withSerial) throws WXException
	{
		Map<String, String> headerMap = new HashMap<>(5);
		headerMap.put(HttpConstants.ACCEPT, HttpConstants.HTTP_MEDIA_JSON);
		headerMap.put(HttpConstants.CONTENT_TYPE, HttpConstants.HTTP_MEDIA_JSON);

		if (withSerial)
		{
			String serialNumber = encryptor.getPaySerialNumber();
			headerMap.put(HttpConstants.WECHAT_PAY_SERIAL, serialNumber);
		}

		String authorization = credential.getAuthorization(canonicalUrl, httpMethod, body);
		headerMap.put(HttpConstants.AUTHORIZATION, authorization);

		String requestPath = ENDPOINT + canonicalUrl;

		RestResponse restResp = null;
		if (HttpConstants.HTTP_METHOD_POST.equals(httpMethod))
		{
			restResp = restClientService.postJSON(requestPath, body, headerMap);
		}
		else
		{
			restResp = restClientService.get(requestPath, headerMap);
		}

		if (HttpStatus.TOO_MANY_REQUESTS.value() == restResp.getStatusCode())
		{
			throw new WxFrequencyLimitedException(
			        "Request failed, body is " + restResp.getBody() + ", status code is " + restResp.getStatusCode());
		}
		else if (HttpStatus.INTERNAL_SERVER_ERROR.value() == restResp.getStatusCode())
		{
			throw new WXSystemErrorException(
			        "Request failed, body is " + restResp.getBody() + ", status code is " + restResp.getStatusCode());
		}

		if (HttpStatus.OK.value() != restResp.getStatusCode() && HttpStatus.NO_CONTENT.value() != restResp.getStatusCode())
		{
			throw new WXException("Request failed, body is " + restResp.getBody() + ", status code is " + restResp.getStatusCode());
		}

		if (!verifier.validate(restResp.getHeaders(), restResp.getBody()))
		{
			String requestId = restResp.getHeaders().get(HttpConstants.REQUEST_ID);

			throw new WXException(String.format(
			        "Validate response failed,the WechatPay signature is incorrect.%n" + "Request-ID[%s], responseBody[%.1024s]", requestId,
			        restResp.getBody()));
		}

		return restResp;
	}

	/**
	 * 设置restClientService
	 * 
	 * @param restClientService
	 */
	public void setRestClientService(RestClientService restClientService)
	{
		this.restClientService = restClientService;
	}

	/**
	 * 设置encryptor
	 * 
	 * @param encryptor
	 */
	public void setEncryptor(PrivacyEncryptor encryptor)
	{
		this.encryptor = encryptor;
	}

	/**
	 * 设置decryptor
	 * 
	 * @param decryptor
	 */
	public void setDecryptor(PrivacyDecryptor decryptor)
	{
		this.decryptor = decryptor;
	}

	/**
	 * 设置credential
	 * 
	 * @param credential
	 */
	public void setCredential(WxPayCredential credential)
	{
		this.credential = credential;
	}

	/**
	 * 设置verifier
	 * 
	 * @param verifier
	 */
	public void setVerifier(WxPayVerifier verifier)
	{
		this.verifier = verifier;
	}
}
