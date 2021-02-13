package com.cloud.consumer.controller;


import com.cloud.common.domain.CommonResult;
import com.cloud.common.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class PaymentComtroller {

    private static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String servicePort;

    @PostMapping
    public CommonResult addPayment(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "payment/", payment, CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult selectPaymentById(@PathVariable(value = "id") Long id){
        log.info("查询"+servicePort);
        System.out.println(servicePort);
        return restTemplate.getForObject(PAYMENT_URL + "payment/" + id, CommonResult.class);
    }

}
