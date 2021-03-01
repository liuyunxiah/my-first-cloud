package com.cloud.hystrix.service.impl;

import com.cloud.hystrix.service.PaymentService_1;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
//服务降级 配置通用与独享
@Service
@DefaultProperties(defaultFallback = "test_fallback")
public class PaymentServiceImpl_1 implements PaymentService_1 {


    //通用
    @Override
    @HystrixCommand
    public String selectPaymentById(String id) {
        return "server 8001 : selectPaymentById"+ Thread.currentThread().getName() + "ok~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "test_fallback_timeout", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String timeOut(String id) {
        try {
            long s = 6;
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "server 8001 : timeOut"+ Thread.currentThread().getName() + "ok~";
    }

    //服务降级方法
    public String test_fallback(){
        return "test_fallback 请重试!";
    }
    public String test_fallback_timeout(String id){
        return "test_fallback_timeout 请重试!" + id;
    }

}
