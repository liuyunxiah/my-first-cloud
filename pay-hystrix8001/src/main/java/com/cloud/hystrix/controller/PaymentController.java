package com.cloud.hystrix.controller;

import com.cloud.hystrix.service.PaymentService;
import com.cloud.hystrix.service.PaymentService_1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/hystrix")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;




    @GetMapping("/selectPaymentById/{id}")
    public String selectPaymentById(@PathVariable String id){
//        http://localhost:8001/payment/hystrix/selectPaymentById/1
         return paymentService.selectPaymentById(id);
    }

    @GetMapping("/timeOut/{id}")
    public String timeOut(@PathVariable String id){
        return paymentService.timeOut(id);
    }


    @Autowired
    private PaymentService_1 paymentService_1;

    @GetMapping("/selectPaymentById1/{id}")
    public String selectPaymentById_1(@PathVariable String id){
        return paymentService_1.selectPaymentById(id);
    }

    @GetMapping("/timeOut1/{id}")
    public String timeOut_1(@PathVariable String id){
        return paymentService_1.timeOut(id);
    }
}
