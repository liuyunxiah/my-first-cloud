package com.cloud.hystrix.service;

public interface PaymentCommand {
    String selectPaymentById(String id);
    String timeOut(String id);
}
