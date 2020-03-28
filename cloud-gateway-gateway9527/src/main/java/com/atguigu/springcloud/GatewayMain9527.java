package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lynch
 * @date 2020/3/29 2:02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayMain9527 {

    public static void main(String[] args){
      SpringApplication.run(GatewayMain9527.class, args);
    }
}
