package com.sapiens.activemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PortalConsumer {
	private static final Logger logger = LoggerFactory.getLogger(PortalConsumer.class);

	@JmsListener(destination = "netsurfingzone-queue")
	public void consumeMessage(String message) {
		logger.info("Message received from activemq queue---"+message);
	}
}
