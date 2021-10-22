package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 手动配置负载均衡的规则  改为随机轮询 的方式
 *    配置类要放在CompnentScan扫描不到的地方
 *    不能和主启动类放在一个包下
 * @author Ht
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule myrule(){
        return new RandomRule();
    }
}
