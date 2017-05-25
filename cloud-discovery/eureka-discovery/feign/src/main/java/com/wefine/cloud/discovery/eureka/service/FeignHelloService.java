package com.wefine.cloud.discovery.eureka.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-hi")
public interface FeignHelloService {

    @GetMapping(value = "/hi")
    String hi(@RequestParam(value = "name") String name);

}
