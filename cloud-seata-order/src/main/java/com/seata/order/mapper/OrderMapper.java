package com.seata.order.mapper;

import com.seata.order.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper
public interface OrderMapper {
    int create(Order order);
    int update(@Param("id") Long id);
}
