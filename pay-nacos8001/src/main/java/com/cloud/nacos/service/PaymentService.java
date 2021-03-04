package com.cloud.nacos.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String selectPaymentById(String id){
        return "nacos 8001 : selectPaymentById"+ Thread.currentThread().getName() + "ok~";
    }
}
