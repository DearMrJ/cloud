package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lynch
 * @date 2020/3/24 22:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumerMain80 {

    public static void main(String[] args){
      SpringApplication.run(OrderConsumerMain80.class, args);
    }
}
