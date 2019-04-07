package com.share.view.stockservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Config {
	@Bean 
	@LoadBalanced
	public RestTemplate restTemplate() { return new RestTemplate(); }
}
