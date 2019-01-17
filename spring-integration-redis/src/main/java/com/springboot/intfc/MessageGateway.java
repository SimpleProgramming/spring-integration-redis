package com.springboot.intfc;

import java.util.concurrent.Future;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageGateway {
	
	@Gateway(requestChannel = "inputChannel")
	public <S> Future<S> sendMessage(S request);

}
