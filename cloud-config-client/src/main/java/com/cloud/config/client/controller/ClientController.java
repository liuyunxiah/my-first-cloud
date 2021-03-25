package com.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
@RequestMapping("/config/client")
public class ClientController {

    @Value("${test.version}")
    String version;

    @RequestMapping("/")
    public String home(){
        return "Hello World!" + version ;
    }

}
