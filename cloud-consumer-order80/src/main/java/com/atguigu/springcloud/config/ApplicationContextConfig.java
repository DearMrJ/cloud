package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lynch
 * @date 2020/3/13 23:58
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced //注释此项，使用自己的负载均衡策略
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
