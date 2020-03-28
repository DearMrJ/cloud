package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lynch
 * @date 2020/3/21 10:11
 */
@SpringBootApplication
@EnableDiscoveryClient      //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMain8004 {

    /**启动zookeeper容器
     * docker run -d -p 2181:2181 --name zookeeper_orz --restart always ae908d18e2d0
     * docker exec -it ae908d18e2d0 bash
     * ./bin/zkCli.sh
     * quit
     * exit
     */
    public static void main(String[] args){
      SpringApplication.run(PaymentMain8004.class, args);
    }
}
