package com.seata.storage.controller;

import com.cloud.common.domain.CommonResult;
import com.seata.storage.service.StorageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/seata/storage")
@Api(value = "storageController", tags = "st")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PutMapping(value = "/deduct")
    public CommonResult deduct(@RequestParam(value = "commodityCode") String commodityCode,
                               @RequestParam(value = "count") Integer count){
        storageService.deduct(commodityCode, count);
        return CommonResult.success();
    }

}
