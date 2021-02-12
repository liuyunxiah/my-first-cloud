package com.cloud.consul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class ConsulController {

    @Value("${server.port}")
    private String servicePort;

    @RequestMapping(value = "/payment/consul")
    public String payment(){
        //http://localhost:8006/payment/consul
        return servicePort + UUID.randomUUID().toString();
    }
}
