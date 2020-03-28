package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lynch
 * @date 2020/3/21 10:14
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * http://localhost:8004/payment/zk
     * @return
     */
    @RequestMapping("/payment/zk")
    public String paymentZk() {
        return "SpringCloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
