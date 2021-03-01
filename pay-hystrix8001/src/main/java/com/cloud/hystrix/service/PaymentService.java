package com.cloud.hystrix.service;


public interface PaymentService {

    String selectPaymentById(String id);


    String timeOut(String id);

}
