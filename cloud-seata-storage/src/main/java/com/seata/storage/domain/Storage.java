package com.seata.storage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id;

    //库存数量
    private Integer count;

    //商品code
    private String commodityCode;
}
