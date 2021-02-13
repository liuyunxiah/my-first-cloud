package com.cloud.openfeign.service;

import com.cloud.common.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignService {

    @GetMapping(value = "/payment/{id}")
    CommonResult selectPaymentById(@PathVariable(value = "id") Long id);
}
