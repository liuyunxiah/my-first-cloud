package com.seata.account.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(env.getProperty("spring.datasource.dynamic.datasource.mitu-cloud-finance.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.dynamic.datasource.mitu-cloud-finance.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.dynamic.datasource.mitu-cloud-finance.password"));
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.dynamic.datasource.mitu-cloud-finance.driver-class-name"));
     //这上面是获取配置文件中的信息，url,username,password,driverclassname等
        return dataSource;
    }

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }

}
