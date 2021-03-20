package com.cloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.cloud.sentinel.common.BlockHandlerClass;
import com.cloud.sentinel.service.SentinelService;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @Autowired
    private SentinelService sentinelService;

    @GetMapping("/test")
    @SentinelResource("test")
    public String test(){
        try {
            Thread.sleep(2000);
//            int i = 10/0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test 执行......" + sentinelService.getservice();
    }

    @GetMapping("/testA")
    public String testA(){
        return "testA 执行......" + sentinelService.getservice();
    }

    //热点参数限流测试
    @GetMapping("/flow")
    @SentinelResource(value = "flow", blockHandler = "blockHandler", blockHandlerClass = {BlockHandlerClass.class})
    public String flow(@RequestParam(name = "arg1", required = false) String arg1,
                       @RequestParam(name = "arg2", required = false) String arg2,
                       @RequestParam(name = "arg3", required = false) String arg3){

        return "flow: 1--:"+ arg1 + " 2--:"+ arg2 +"3--:"+ arg3 + new Date();
    }

    //fallback 测试
    @GetMapping("/fallback")
    @SentinelResource(value = "fallback", fallback = "fallback", fallbackClass = {})
    public String fallbacktest(){
        int i = 10/0;
        return "fallback";
    }

    //授权测试
    public String qequestOriginParser(){

        return "授权成功";
    }

    //或者多一个Throwable 参数,返回值类型,参数一直,在Class中必须为static否则无法解析
    public String fallback(){
        return "fallback...";
    }

    public String blockHandler(String arg1,
                               String arg2,
                               String arg3,
                               BlockException exception){
        return "blockHandler==..."+ arg1 + arg2 + arg3 +exception;
    }
}
