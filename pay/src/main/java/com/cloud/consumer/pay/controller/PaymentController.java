package com.cloud.consumer.pay.controller;

import com.cloud.common.domain.CommonResult;
import com.cloud.common.domain.Payment;
import com.cloud.consumer.pay.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping
    @ApiOperation(value="添加")
    public CommonResult addPayment(@RequestBody Payment payment){
        int id = paymentService.addPayment(payment);
        return CommonResult.success().setData(id);
    }

    @GetMapping("/{id}")
    @ApiOperation(value="查询id")
    public CommonResult selectPaymentById(@PathVariable(value = "id") Long id){
        log.info("****"+servicePort);
        Payment payment = paymentService.selectPaymentById(id);
        return CommonResult.success().setData(payment);
    }


    //服务发现
    @GetMapping("/discoveryclient")
    @ApiOperation(value="discoveryClient")
    public CommonResult discoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(service);
            for (ServiceInstance instance : serviceInstances){
                log.info(instance.getInstanceId() + " " + instance.getHost() + " " + instance.getUri());
            }
        }
        return CommonResult.success();
    }

}
