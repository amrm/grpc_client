package com.daily.technical.knowledge.grpcClient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * 
 * 
 * @author Amr Abdeldayem
 *
 */
@Component
public class ApplicationConfig {

	@Value("${grpc.port}")
	private int port;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	public ManagedChannel managedChannel() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
	    return channel;
	}
	

}
