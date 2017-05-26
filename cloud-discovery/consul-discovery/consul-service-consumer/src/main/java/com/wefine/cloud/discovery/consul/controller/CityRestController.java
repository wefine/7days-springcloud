package com.wefine.cloud.discovery.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/city")
public class CityRestController {
    @Value("${server.port}")
    private int port;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/capital0")
    public String[] capital0() {
        String url = "http://localhost:8183/rest/city/capital";

        return restTemplate.getForObject(url, String[].class);
    }

    @GetMapping("/capital1")
    public String[] capital1() {

        ServiceInstance serviceInstance =
            discoveryClient.getInstances("city-service")
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("city-service not found"));

        String url = serviceInstance.getUri().toString() + "/rest/city/capital";
        return restTemplate.getForObject(url, String[].class);
    }

    @GetMapping("/capital")
    public String[] loadBalanceCapital() {
        ServiceInstance serviceInstance =loadBalancerClient.choose("city-service");
        Assert.notNull(serviceInstance, "city-service not found");

        // 使用负载均衡后，只需要使用服务名去查询即可，上面的代码生产环境当删除掉。
        return restTemplate.getForObject("http://city-service/rest/city/capital", String[].class);
    }
}
