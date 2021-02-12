package com.consul.config.controller;

import com.cloud.common.domain.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@Slf4j
public class ConsulController {

    private static String SERVER_URL = "http://consul-payment-service8006";

    @Value("${server.port}")
    private String servicePort;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/order/consul")
    public String payment(){
        //http://localhost:8081/order/consul
        System.out.println(servicePort + UUID.randomUUID().toString());
        String result = restTemplate.getForObject(SERVER_URL + "/payment/consul", String.class);
        return result;
    }
}
