package com.cloud.hystrix.service.impl;

import com.cloud.hystrix.service.PaymentCommand;
import org.springframework.stereotype.Component;

@Component
public class PaymentCommandHystrix implements PaymentCommand {


    @Override
    public String selectPaymentById(String id) {
        return null;
    }

    @Override
    public String timeOut(String id) {
        return null;
    }
}
