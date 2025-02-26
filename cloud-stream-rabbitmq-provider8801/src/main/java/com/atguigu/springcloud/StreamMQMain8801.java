package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lynch
 * @date 2020/3/30 16:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamMQMain8801 {

    public static void main(String[] args){
      SpringApplication.run(StreamMQMain8801.class, args);
    }
}
