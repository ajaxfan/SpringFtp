package com.freeway.web.ftp.client;

import java.io.File;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.file.FileHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void test() throws InterruptedException {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");

		MessageChannel ftpChannel = ctx.getBean("ftpChannel", MessageChannel.class);

		File file = new File("d:/abc");

		for (File f : file.listFiles()) {
			Message<File> messageFile = MessageBuilder.withPayload(f).setHeader(FileHeaders.REMOTE_DIRECTORY, "test")
					.build();
			ftpChannel.send(messageFile);
		}
		ctx.close();
	}
}
