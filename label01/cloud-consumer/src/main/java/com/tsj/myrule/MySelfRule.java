package com.tsj.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author tansj
 * @Date 2022/8/8 14:34
 * @Version 1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
//        return new RoundRobinRule();
        return new MyRule();
    }

}
