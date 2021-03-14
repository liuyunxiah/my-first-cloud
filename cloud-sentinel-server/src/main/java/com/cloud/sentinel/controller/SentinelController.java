package com.cloud.sentinel.controller;

import com.cloud.sentinel.service.SentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @Autowired
    private SentinelService sentinelService;

    @GetMapping("/test")
    public String test(){
        return "test 执行......" + sentinelService.getservice();
    }

    @GetMapping("/testA")
    public String testA(){
        return "testA 执行......" + sentinelService.getservice();
    }
}
