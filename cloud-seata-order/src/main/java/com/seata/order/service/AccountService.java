package com.seata.order.service;

import com.cloud.common.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;

/**
 * 账户
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 从用户账户中借出
     */
    @PutMapping(value = "/seata/account/debit")
    CommonResult debit(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);
}
