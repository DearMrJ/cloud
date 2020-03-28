package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lynch
 * @date 2020/3/22 23:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {

    public static void main(String[] args){
      SpringApplication.run(OrderZKMain80.class, args);
    }
}
