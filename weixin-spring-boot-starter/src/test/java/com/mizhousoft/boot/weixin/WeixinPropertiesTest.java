package com.mizhousoft.boot.weixin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mizhousoft.boot.weixin.properties.WeixinMPProperties;
import com.mizhousoft.boot.weixin.properties.WeixinMiniProperties;
import com.mizhousoft.boot.weixin.properties.WeixinOpenProperties;
import com.mizhousoft.boot.weixin.properties.WeixinPayListProperties;

/**
 * WeixinPayListProperties Test
 *
 * @version
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class WeixinPropertiesTest
{
	@Autowired
	private WeixinPayListProperties payListProperties;

	@Autowired
	private WeixinMiniProperties miniProperties;

	@Autowired
	private WeixinMPProperties mpProperties;

	@Autowired
	private WeixinOpenProperties openProperties;

	@Test
	public void test()
	{
		Assertions.assertEquals(1, payListProperties.getMerchants().size());

		Assertions.assertEquals("wx461216ssssss", miniProperties.getAppId());

		Assertions.assertEquals("wx461216ssssss", mpProperties.getAppId());

		Assertions.assertEquals("wx461216ssssss", openProperties.getAppId());
	}
}
