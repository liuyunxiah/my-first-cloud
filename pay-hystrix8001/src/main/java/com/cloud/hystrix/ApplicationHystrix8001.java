package com.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCircuitBreaker //开启熔断器 @EnableHystrix
public class ApplicationHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrix8001.class, args);
    }
}
