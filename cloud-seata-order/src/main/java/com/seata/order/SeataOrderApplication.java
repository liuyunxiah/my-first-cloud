package com.seata.order;

import com.seata.order.config.DataSourceConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages="com.seata")
@SpringBootApplication//(scanBasePackages = {"com.seata"}, exclude = DataSourceAutoConfiguration.class)//
@Import(DataSourceConfig.class)
@EnableSwagger2
public class SeataOrderApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(SeataOrderApplication.class, args);

        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        System.out.println("端口号："+port);
        System.out.println("SWAGGER地址：http://"+ip+":"+port+"/swagger-ui.html");
        System.out.println("Local访问地址：http://localhost:"+port+"/");
        System.out.println("External访问网址：http://"+ip+":"+port+"/");
        System.out.println("------------------------------------------------------");
    }

}
