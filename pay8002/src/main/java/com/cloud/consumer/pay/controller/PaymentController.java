package com.cloud.consumer.pay.controller;

import com.cloud.common.domain.CommonResult;
import com.cloud.common.domain.Payment;
import com.cloud.consumer.pay.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @PostMapping
    @ApiOperation(value="添加")
    public CommonResult addPayment(@RequestBody Payment payment){
        int id = paymentService.addPayment(payment);
        return CommonResult.success().setData(id);
    }

    @GetMapping("/{id}")
    @ApiOperation(value="查询id")
    public CommonResult selectPaymentById(@PathVariable Long id){
        log.info("****"+servicePort);
        Payment payment = paymentService.selectPaymentById(id);
        return CommonResult.success().setData(payment);
    }

    @GetMapping("/timeout")
    public void timeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
