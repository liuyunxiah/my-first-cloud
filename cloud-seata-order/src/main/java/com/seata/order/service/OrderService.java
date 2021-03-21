package com.seata.order.service;

import com.seata.order.domain.Order;

public interface OrderService {
    Order create(String userId, String commodityCode, int orderCount);
}
