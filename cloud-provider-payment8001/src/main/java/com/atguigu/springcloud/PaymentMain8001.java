package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author lynch
 * @date 2020/3/9 23:15
 */
@SpringBootApplication
@EnableEurekaClient         //允许注册到eureka
@EnableDiscoveryClient      //启动查看服务注解
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}