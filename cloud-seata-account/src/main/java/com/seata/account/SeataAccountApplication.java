package com.seata.account;

import com.seata.account.config.DataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages="com.seata")
@SpringBootApplication
@Import(DataSourceConfig.class)
@EnableSwagger2
public class SeataAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication.class, args);
    }
}
