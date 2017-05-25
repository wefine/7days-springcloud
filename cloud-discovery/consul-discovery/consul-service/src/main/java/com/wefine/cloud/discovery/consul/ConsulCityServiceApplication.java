package com.wefine.cloud.discovery.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulCityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulCityServiceApplication.class, args);
	}
}
