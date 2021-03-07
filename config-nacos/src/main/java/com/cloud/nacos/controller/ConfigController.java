package com.cloud.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/nacos/config")
@RefreshScope
public class ConfigController {

//    @Value("${current.env}")
//    private String env;

    //1.
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @RequestMapping("/get")
    public String get() {
        return applicationContext.getEnvironment().getProperty("current.env");
    }

    //2.分组DEAFAULT_GROUP
    @Value("${config.info}")
    private String info;

    @GetMapping("/config/info")
    public 	String nacosConfig() {
        return info;
    }

}
