package com.akshay.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

    @Bean//So that we can use this bean in UserService
	@LoadBalanced//Because multiple services are connected to the service registry
	public RestTemplate restTemplate(){

		return new RestTemplate();
	   }
}
