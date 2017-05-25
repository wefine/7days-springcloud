package com.wefine.cloud.discovery.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
class ServiceInstanceRestController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
        @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }
}
