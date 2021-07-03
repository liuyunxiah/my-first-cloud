package com.seata.account.service.impl;

import com.seata.account.mapper.AccountMapper;
import com.seata.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(rollbackFor = Exception.class)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void debit(String userId, BigDecimal money)  {

        accountMapper.debit(userId, money);
        if(true){
            throw new RuntimeException("错了");
        }
    }
}
