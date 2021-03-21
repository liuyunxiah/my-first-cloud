package com.seata.order.service;

import com.cloud.common.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存service
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 扣除存储数量
     */
    @PutMapping(value = "/seata/storage/deduct")
    CommonResult deduct(@RequestParam(value = "commodityCode") String commodityCode, @RequestParam(value = "count") Integer count);
}
