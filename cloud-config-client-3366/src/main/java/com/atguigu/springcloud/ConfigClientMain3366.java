package com.atguigu.springcloud;

/**
 * @author lynch
 * @date 2020/3/29 23:02
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3366 {
    
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class, args);
    }
}