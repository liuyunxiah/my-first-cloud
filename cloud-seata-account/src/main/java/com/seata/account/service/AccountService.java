package com.seata.account.service;

import java.math.BigDecimal;

public interface AccountService {
    void debit(String userId, BigDecimal money);
}
