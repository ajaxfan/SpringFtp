package com.freeway.web.ftp.client;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;

/**
 * Unit test for simple App.
 */
public class AppTest2 {
	@Test
	public void test() throws InterruptedException {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");

		SourcePollingChannelAdapter ftpChannel = ctx.getBean("ftpInbound", SourcePollingChannelAdapter.class);

		ftpChannel.start();

		ctx.close();
	}
}
