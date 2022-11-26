package com.dailycode.cloudgetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//@EnableEurekaClient
public class CloudGetwayApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudGetwayApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate template(){
		return new RestTemplate();
	}

}
