package cm.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myrule {

    //第几次请求 % 总数  = 轮训的服务器

    @Bean
    public IRule Myrule(){
        return new RandomRule();
    }
}
