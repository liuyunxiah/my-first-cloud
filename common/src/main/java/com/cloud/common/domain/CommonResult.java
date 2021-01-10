package com.cloud.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private int code = 200;

    private String message = "success";

    private T data;

    public static CommonResult success() {
        return new CommonResult();
    }

    public CommonResult setData(T t){
        this.data = t;
        return this;
    }

}
