package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lynch
 * @date 2020/3/29 22:59
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")    //目标dev.yml中的config.info
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "server.port = " + serverPort + "\t configInfo=" + configInfo;
    }
}