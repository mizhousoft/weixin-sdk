package com.mizhousoft.weixin.mp.domain.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 序列化
 *
 * @version
 */
public class NumericBooleanSerializer extends JsonSerializer<Boolean>
{
	@Override
	public void serialize(Boolean bool, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException
	{
		generator.writeString(bool ? "1" : "0");
	}
}
