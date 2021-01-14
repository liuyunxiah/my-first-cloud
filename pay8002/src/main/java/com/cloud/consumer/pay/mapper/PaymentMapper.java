package com.cloud.consumer.pay.mapper;

import com.cloud.common.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PaymentMapper {
    int addPatment(Payment payment);
    Payment selectPaymentById(Long id);
}
