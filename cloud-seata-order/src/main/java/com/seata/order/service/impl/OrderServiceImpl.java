package com.seata.order.service.impl;

import com.seata.order.domain.Order;
import com.seata.order.mapper.OrderMapper;
import com.seata.order.service.AccountService;
import com.seata.order.service.OrderService;
import com.seata.order.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
//@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;


    @Override
    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    public Order create(String userId, String commodityCode, int orderCount) {
        Order order = new Order();
        order.setCount(orderCount)
             .setCommodityCode(commodityCode)
             .setUserId(userId)
             .setMoney(new BigDecimal(10));
        //新增订单信息
        orderMapper.create(order);
        //减库存
        storageService.deduct(order.getCommodityCode(), order.getCount());

//        减账户
        accountService.debit(order.getUserId(), order.getMoney());
        //改订单状态
        orderMapper.update(order.getId());
        return order;
    }
}
