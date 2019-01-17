package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;
import org.springframework.scheduling.annotation.AsyncConfigurer;

@Configuration
@EnableIntegration
@IntegrationComponentScan("com.springboot")
public class IntegrationConfig {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		return factory;
	}

	@Bean
	public DirectChannel receiverChannel() {
		return new DirectChannel();
	}

	@Bean
	public RedisQueueMessageDrivenEndpoint consumerEndPoint() {
		RedisQueueMessageDrivenEndpoint endPoint = new RedisQueueMessageDrivenEndpoint("Redis-Queue",
				jedisConnectionFactory());
		endPoint.setOutputChannelName("receiverChannel");
		return endPoint;
	}
}
