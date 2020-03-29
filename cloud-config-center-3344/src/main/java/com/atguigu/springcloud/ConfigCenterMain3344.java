package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lynch
 * @date 2020/3/29 21:48
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigCenterMain3344 {

    public static void main(String[] args){
      SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
