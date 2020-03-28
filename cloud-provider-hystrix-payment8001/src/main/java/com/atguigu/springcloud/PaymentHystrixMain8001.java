package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lynch
 * @date 2020/3/25 15:33
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient  //让服务可发现，@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
@EnableCircuitBreaker   //开启断路器功能
public class PaymentHystrixMain8001 {

    public static void main(String[] args){
      SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
