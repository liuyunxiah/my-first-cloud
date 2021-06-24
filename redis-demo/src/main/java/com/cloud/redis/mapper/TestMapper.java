package com.cloud.redis.mapper;

import com.cloud.common.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
    Payment selectPaymentById(Long id);
    int update(Long id);
    int save(Payment payment);
    int delete(Long id);
}
