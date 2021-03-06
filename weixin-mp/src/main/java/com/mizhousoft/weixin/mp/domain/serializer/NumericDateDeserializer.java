package com.mizhousoft.weixin.mp.domain.serializer;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * εεΊεε
 *
 * @version
 */
public class NumericDateDeserializer extends JsonDeserializer<Date>
{
	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException
	{
		long ts = parser.getLongValue();
		return new Date(ts * 1000);
	}
}
