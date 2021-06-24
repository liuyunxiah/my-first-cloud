package com.cloud.redis.controller;

import com.cloud.common.domain.CommonResult;
import com.cloud.common.domain.Payment;
import com.cloud.redis.PaymentDTO;
import com.cloud.redis.mapper.TestMapper;
import com.cloud.redis.service.RedisService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/{id}")
    @ApiOperation(value="查询id")
    public CommonResult selectPaymentById(@PathVariable(value = "id") Long id){
        Payment payment = redisService.selectPaymentById(id);
        return CommonResult.success().setData(payment);
    }


    @PostMapping
    @ApiOperation(value="插入")
    public CommonResult insert(@RequestBody PaymentDTO dto){

        Payment payment = new Payment();
        BeanUtils.copyProperties(dto, payment);
        payment = redisService.insert(payment);
        return CommonResult.success().setData(payment);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="删除id")
    public CommonResult delete(@PathVariable(value = "id") Long id){
        int count = redisService.delete(id);
        return CommonResult.success().setData(count);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="修改id")
    public CommonResult update(@PathVariable(value = "id") Long id){
        redisService.update(id);
        return CommonResult.success();
    }

}
