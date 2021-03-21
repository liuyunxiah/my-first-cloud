package com.seata.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Order {

    private Long id;

    //购买人id
    private String userId;

    //商品code
    private String commodityCode;

    //数量
    private Integer count;

    //订单金额
    private BigDecimal money;

    private Integer status;

}
