package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lynch
 * @date 2020/3/25 22:59
 */
@SpringBootApplication
@EnableHystrix  //启动熔断降级服务
@EnableFeignClients //
public class OrderHystrixMain80 {

    public static void main(String[] args){
      SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
