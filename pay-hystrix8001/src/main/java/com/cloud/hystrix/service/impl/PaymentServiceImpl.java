package com.cloud.hystrix.service.impl;

import com.cloud.hystrix.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

//1. 服务降级 一对一
@Service
public class PaymentServiceImpl implements PaymentService {


    @Override
    @HystrixCommand(fallbackMethod = "test_fallback")
    public String selectPaymentById(String id) {
        return "server 8001 : selectPaymentById"+ Thread.currentThread().getName() + "ok~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "test_fallback", commandProperties = {
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
    public String test_fallback(String id){
        return "test_fallback 请重试!" + id;
    }

}
