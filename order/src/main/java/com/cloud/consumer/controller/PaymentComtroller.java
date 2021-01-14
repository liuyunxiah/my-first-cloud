package com.cloud.consumer.controller;


import com.cloud.common.domain.CommonResult;
import com.cloud.common.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
public class PaymentComtroller {

    private static String PAYMENT_URL = "http://127.0.0.1:8081/";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public CommonResult addPayment(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "payment/", payment, CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult selectPaymentById(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL + "payment/" + id, CommonResult.class);
    }

}
