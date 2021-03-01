package com.cloud.hystrix.controller;

import com.cloud.hystrix.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/hystrix")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/consumer/selectPaymentById/{id}")
    public String selectPaymentById(@PathVariable String id){
        return orderService.selectPaymentById(id);
    }

    @GetMapping("/consumer/timeOut/{id}")
    public String timeOut(@PathVariable String id){
        return orderService.timeOut(id);
    }
}
