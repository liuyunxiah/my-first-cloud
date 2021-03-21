package com.seata.account.controller;

import com.cloud.common.domain.CommonResult;
import com.seata.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/seata/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping(value = "/debit")
    public CommonResult debit(@RequestParam(value = "userId") String userId,
                              @RequestParam(value = "money") BigDecimal money){
        accountService.debit(userId, money);
        return CommonResult.success();
    }

}
