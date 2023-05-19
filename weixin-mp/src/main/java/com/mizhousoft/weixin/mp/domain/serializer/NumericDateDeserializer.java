package com.mizhousoft.weixin.mp.domain.serializer;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mizhousoft.commons.lang.LocalDateTimeUtils;

/**
 * 反序列化
 *
 */
public class NumericDateDeserializer extends JsonDeserializer<LocalDateTime>
{
	@Override
	public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException
	{
		long ts = parser.getLongValue();
		return LocalDateTimeUtils.toLocalDateTime(ts);
	}
}
