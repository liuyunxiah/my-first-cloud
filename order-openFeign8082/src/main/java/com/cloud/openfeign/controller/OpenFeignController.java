package com.cloud.openfeign.controller;

import com.cloud.common.domain.CommonResult;
import com.cloud.openfeign.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignController {

    @Autowired
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/openfeign/{id}")
    public CommonResult selectPaymentById(@PathVariable(value = "id") Long id){
        //http://localhost:8082/consumer/openfeign/1
        CommonResult  result = openFeignService.selectPaymentById(id);
        return CommonResult.success().setData(result);
    }

}
