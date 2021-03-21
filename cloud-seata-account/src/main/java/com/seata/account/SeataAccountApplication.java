package com.seata.account;

import com.seata.account.config.DataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages="com.seata.account.mapper")
@SpringBootApplication(scanBasePackages = {"com.seata"}, exclude = DataSourceAutoConfiguration.class)
@Import(DataSourceConfig.class)
public class SeataAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication.class, args);
    }
}