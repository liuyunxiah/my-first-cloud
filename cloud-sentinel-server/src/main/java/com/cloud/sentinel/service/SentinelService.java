package com.cloud.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class SentinelService {

    @SentinelResource(value = "getservice", blockHandler = "blockHandler")
    public String getservice(){
        return "getservice " + new Date();
    }
    public String blockHandler(BlockException exception){
        return "报错了！" + exception;
    }
}
