package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lynch
 * @date 2020/3/13 14:42
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = MySelfRule.class) //指定负载均衡策略，注意，自定义的策略类不能被@ComponentScan扫描到
public class OrderMain80 {
    public static void main(String[] args){
      SpringApplication.run(OrderMain80.class, args);
    }
}
