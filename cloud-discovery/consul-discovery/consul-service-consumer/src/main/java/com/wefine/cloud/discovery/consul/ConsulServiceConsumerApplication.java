package com.wefine.cloud.discovery.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulServiceConsumerApplication.class, args);
    }

}
