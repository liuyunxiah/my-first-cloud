package com.seata.storage.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
@Mapper
public interface StorageMapper {
    int deduct(@Param("commodityCode") String commodityCode, @Param(value = "count") Integer count);
}
