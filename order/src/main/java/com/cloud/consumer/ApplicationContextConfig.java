package com.cloud.consumer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //使客户端负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
