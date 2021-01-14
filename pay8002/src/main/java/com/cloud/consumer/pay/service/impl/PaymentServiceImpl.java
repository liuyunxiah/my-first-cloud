package com.cloud.consumer.pay.service.impl;

import com.cloud.common.domain.Payment;
import com.cloud.consumer.pay.mapper.PaymentMapper;
import com.cloud.consumer.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public int addPayment(Payment payment) {
        return paymentMapper.addPatment(payment);
    }

    @Override
    public Payment selectPaymentById(Long id) {
        return paymentMapper.selectPaymentById(id);
    }
}
