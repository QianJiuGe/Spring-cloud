package com.wustht;

import com.rule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @EnableEurekaClient 是指该类是Eureka的客户端
 * @RibbonClient  用于配置自定义Ribbon负载的方式   name指明对那些生产者调用   configuration指明配置的自定义规则是什么
 *
 * @author Ht
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE" , configuration = MyRibbonRule.class)
public class Order80Main {

    public static void main(String[] args) {
        SpringApplication.run(Order80Main.class, args);
    }
}
