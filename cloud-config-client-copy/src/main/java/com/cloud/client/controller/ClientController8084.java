package com.cloud.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope //刷新
@RestController
@EnableAutoConfiguration
@RequestMapping("/config/client8084")
public class ClientController8084 {
    //TODO* curl -X POST http://localhost:8084/actuator/refresh 调用此地址告诉client配置了

    @Value("${test.version}")
    String version;

    @RequestMapping("/")
    public String home(){
        return "Hello World!" + version ;
    }
}
