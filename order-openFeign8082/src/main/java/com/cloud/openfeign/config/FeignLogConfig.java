package com.cloud.openfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfig {
    // NONE, 不记录
    //        BASIC, 仅记录请求方法、URL以及响应状态码和执行时间
    //        HEADERS, BASIC + 记录请求和响应的头信息
    //        FULL; 记录所有请求与响应的明细， 包括头信息、 请求体、 元数据等

    @Bean
    Logger.Level feignLog() {
        return Logger.Level.FULL;
    }

}
