package com.cloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/nacos/config")
@RefreshScope
public class ConfigController {

    @Value("${current.env}")
    private String env;

    @RequestMapping("/get")
    public String get() {
        return env;
    }

}
