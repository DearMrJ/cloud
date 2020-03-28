package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lynch
 * @date 2020/3/16 14:17
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {

    public static void main(String[] args){
      SpringApplication.run(EurekaMain7001.class, args);
    }

}
