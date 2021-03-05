package com.cloud.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/consumer/nacos")
public class OrderController {
    @Autowired
    private  RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String service_url;

    @GetMapping(value = "/order/selectPaymentById/{id}")
    public String selectPaymentById(@PathVariable String id) {
        return restTemplate.getForObject(service_url + "/payment/nacos/selectPaymentById/" + id, String.class);
    }

}
