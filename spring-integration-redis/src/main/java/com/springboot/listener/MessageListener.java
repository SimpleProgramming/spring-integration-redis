package com.springboot.listener;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

	@ServiceActivator(inputChannel = "inputChannel", outputChannel = "redisChannel")
	public Message<?> receiveFromService(Message<?> message) {
		System.out.println("received from service");
		return message;
	}


}
