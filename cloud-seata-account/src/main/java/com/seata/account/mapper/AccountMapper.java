package com.seata.account.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper {
    int debit(@Param("userId") String userId, @Param("money")BigDecimal money);
}
