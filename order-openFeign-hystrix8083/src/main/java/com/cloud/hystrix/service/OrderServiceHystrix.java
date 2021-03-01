package com.cloud.hystrix.service;

import org.springframework.stereotype.Component;

/**
 * 降级处理
 */
@Component
public class OrderServiceHystrix implements OrderService {
    @Override
    public String selectPaymentById(String id) {
        return "selectPaymentById" + "服务不可用";
    }

    @Override
    public String timeOut(String id) {
        return "timeOut 服务不可用";
    }
}
