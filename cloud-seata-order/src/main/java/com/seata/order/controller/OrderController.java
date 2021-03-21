package com.seata.order.controller;


import com.cloud.common.domain.CommonResult;
import com.seata.order.domain.Order;
import com.seata.order.dto.OrderCreator;
import com.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seata/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public CommonResult createOrder(@RequestBody @Validated OrderCreator creator){
        Order order = orderService.create(creator.getUserId(), creator.getCommodityCode(), creator.getOrderCount());
        return CommonResult.success().setData(order.getId());
    }

}
