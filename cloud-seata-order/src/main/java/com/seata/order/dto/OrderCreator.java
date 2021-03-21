package com.seata.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreator implements Serializable {

    //购买人id
    private String userId;

    //商品code
    private String commodityCode;

    //数量
    private Integer orderCount;

}
