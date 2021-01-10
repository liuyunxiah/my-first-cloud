package com.cloud.consumer.pay.service;


import com.cloud.common.domain.Payment;

public interface PaymentService {

    int addPayment(Payment payment);

    Payment selectPaymentById(Long id);

}
