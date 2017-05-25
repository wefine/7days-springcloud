package com.wefine.cloud.discovery.eureka.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {

    @Resource
    private RestTemplate template;

    public String hi(String name) {
        return template.getForObject("http://EUREKA-HI/hi?name=" + name, String.class);
    }
}
