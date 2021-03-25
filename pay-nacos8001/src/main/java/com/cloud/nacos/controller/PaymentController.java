package com.cloud.nacos.controller;

import com.cloud.nacos.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/nacos")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/selectPaymentById/{id}")
    public String selectPaymentById_1(@PathVariable String id){
        //http://localhost:8001/payment/nacos/selectPaymentById/1
        return paymentService.selectPaymentById(id);
    }

    @PostMapping("/selectPaymentById")
    public String selectPaymentById_1(){
        return "成功";
    }

}
