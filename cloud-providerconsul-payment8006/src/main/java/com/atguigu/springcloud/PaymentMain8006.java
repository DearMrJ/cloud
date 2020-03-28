package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lynch
 * @date 2020/3/24 22:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {

    public static void main(String[] args){
      SpringApplication.run(PaymentMain8006.class, args);
    }
}
