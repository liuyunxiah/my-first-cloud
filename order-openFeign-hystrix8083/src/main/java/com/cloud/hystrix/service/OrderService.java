package com.cloud.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE8001", fallback = OrderServiceHystrix.class)
@Component
public interface OrderService {
    @GetMapping("/payment/hystrix/selectPaymentById/{id}")
    public String selectPaymentById(@PathVariable String id);

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String timeOut(@PathVariable String id);
}
