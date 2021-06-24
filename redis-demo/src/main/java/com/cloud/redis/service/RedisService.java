package com.cloud.redis.service;

import com.cloud.common.domain.Payment;


public interface RedisService {
    Payment selectPaymentById(Long id);

    Payment insert(Payment dto);

    Payment update(Long id);

    int delete(Long id);
}
