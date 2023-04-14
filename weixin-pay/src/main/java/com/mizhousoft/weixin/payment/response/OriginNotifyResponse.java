package com.mizhousoft.weixin.payment.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 通知响应
 *
 * @version
 */
public class OriginNotifyResponse
{
	/**
	 * <pre>
	 * 字段名：通知ID
	 * 变量名：id
	 * 是否必填：是
	 * 类型：string[1,36]
	 * 描述：
	 *  通知的唯一ID
	 *  示例值：EV-2018022511223320873
	 * </pre>
	 */
	@JsonProperty(value = "id")
	private String id;

	/**
	 * <pre>
	 * 字段名：通知创建时间
	 * 变量名：create_time
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  通知创建的时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日13点29分35秒。
	 *  示例值：2018-06-08T10:34:56+08:00
	 * </pre>
	 */
	@JsonProperty(value = "create_time")
	private String createTime;

	/**
	 * <pre>
	 * 字段名：通知类型
	 * 变量名：event_type
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  通知的类型：
	 *  REFUND.SUCCESS：退款成功通知
	 *  REFUND.ABNORMAL：退款异常通知
	 *  REFUND.CLOSED：退款关闭通知
	 *  示例值：REFUND.SUCCESS
	 * </pre>
	 */
	@JsonProperty(value = "event_type")
	private String eventType;

	/**
	 * <pre>
	 * 字段名：通知简要说明
	 * 变量名：summary
	 * 是否必填：是
	 * 类型：string[1,16]
	 * 描述：
	 *  通知简要说明
	 *  示例值：退款成功
	 * </pre>
	 */
	@JsonProperty(value = "summary")
	private String summary;

	/**
	 * <pre>
	 * 字段名：通知数据类型
	 * 变量名：resource_type
	 * 是否必填：是
	 * 类型：string[1,32]
	 * 描述：
	 *  通知的资源数据类型，支付成功通知为encrypt-resource
	 *  示例值：encrypt-resource
	 * </pre>
	 */
	@JsonProperty(value = "resource_type")
	private String resourceType;

	/**
	 * <pre>
	 * 字段名：通知数据
	 * 变量名：resource
	 * 是否必填：是
	 * 类型：object
	 * 描述：
	 *  通知资源数据
	 *  json格式，见示例
	 * </pre>
	 */
	@JsonProperty(value = "resource")
	private Resource resource;

	public static class Resource
	{
		/**
		 * <pre>
		 * 字段名：加密算法类型
		 * 变量名：algorithm
		 * 是否必填：是
		 * 类型：string[1,32]
		 * 描述：
		 *  对开启结果数据进行加密的加密算法，目前只支持AEAD_AES_256_GCM
		 *  示例值：AEAD_AES_256_GCM
		 * </pre>
		 */
		@JsonProperty(value = "algorithm")
		private String algorithm;

		/**
		 * <pre>
		 * 字段名：原始类型
		 * 变量名：original_type
		 * 是否必填：是
		 * 类型：string[1,16]
		 * 描述：
		 *  原始回调类型，为transaction
		 *  示例值：transaction
		 * </pre>
		 */
		@JsonProperty(value = "original_type")
		private String originalType;

		/**
		 * <pre>
		 * 字段名：数据密文
		 * 变量名：ciphertext
		 * 是否必填：是
		 * 类型：string[1,1048576]
		 * 描述：
		 *  Base64编码后的开启/停用结果数据密文
		 *  示例值：sadsadsadsad
		 * </pre>
		 */
		@JsonProperty(value = "ciphertext")
		private String ciphertext;

		/**
		 * <pre>
		 * 字段名：附加数据
		 * 变量名：associated_data
		 * 是否必填：否
		 * 类型：string[1,16]
		 * 描述：
		 *  附加数据
		 *  示例值：fdasfwqewlkja484w
		 * </pre>
		 */
		@JsonProperty(value = "associated_data")
		private String associatedData;

		/**
		 * <pre>
		 * 字段名：随机串
		 * 变量名：nonce
		 * 是否必填：是
		 * 类型：string[1,16]
		 * 描述：
		 *  加密使用的随机串
		 *  示例值：fdasflkja484w
		 * </pre>
		 */
		@JsonProperty(value = "nonce")
		private String nonce;

		/**
		 * 获取algorithm
		 * 
		 * @return
		 */
		public String getAlgorithm()
		{
			return algorithm;
		}

		/**
		 * 设置algorithm
		 * 
		 * @param algorithm
		 */
		public void setAlgorithm(String algorithm)
		{
			this.algorithm = algorithm;
		}

		/**
		 * 获取originalType
		 * 
		 * @return
		 */
		public String getOriginalType()
		{
			return originalType;
		}

		/**
		 * 设置originalType
		 * 
		 * @param originalType
		 */
		public void setOriginalType(String originalType)
		{
			this.originalType = originalType;
		}

		/**
		 * 获取ciphertext
		 * 
		 * @return
		 */
		public String getCiphertext()
		{
			return ciphertext;
		}

		/**
		 * 设置ciphertext
		 * 
		 * @param ciphertext
		 */
		public void setCiphertext(String ciphertext)
		{
			this.ciphertext = ciphertext;
		}

		/**
		 * 获取associatedData
		 * 
		 * @return
		 */
		public String getAssociatedData()
		{
			return associatedData;
		}

		/**
		 * 设置associatedData
		 * 
		 * @param associatedData
		 */
		public void setAssociatedData(String associatedData)
		{
			this.associatedData = associatedData;
		}

		/**
		 * 获取nonce
		 * 
		 * @return
		 */
		public String getNonce()
		{
			return nonce;
		}

		/**
		 * 设置nonce
		 * 
		 * @param nonce
		 */
		public void setNonce(String nonce)
		{
			this.nonce = nonce;
		}
	}

	/**
	 * 获取id
	 * 
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * 设置id
	 * 
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * 获取createTime
	 * 
	 * @return
	 */
	public String getCreateTime()
	{
		return createTime;
	}

	/**
	 * 设置createTime
	 * 
	 * @param createTime
	 */
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * 获取eventType
	 * 
	 * @return
	 */
	public String getEventType()
	{
		return eventType;
	}

	/**
	 * 设置eventType
	 * 
	 * @param eventType
	 */
	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}

	/**
	 * 获取summary
	 * 
	 * @return
	 */
	public String getSummary()
	{
		return summary;
	}

	/**
	 * 设置summary
	 * 
	 * @param summary
	 */
	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	/**
	 * 获取resourceType
	 * 
	 * @return
	 */
	public String getResourceType()
	{
		return resourceType;
	}

	/**
	 * 设置resourceType
	 * 
	 * @param resourceType
	 */
	public void setResourceType(String resourceType)
	{
		this.resourceType = resourceType;
	}

	/**
	 * 获取resource
	 * 
	 * @return
	 */
	public Resource getResource()
	{
		return resource;
	}

	/**
	 * 设置resource
	 * 
	 * @param resource
	 */
	public void setResource(Resource resource)
	{
		this.resource = resource;
	}
}
