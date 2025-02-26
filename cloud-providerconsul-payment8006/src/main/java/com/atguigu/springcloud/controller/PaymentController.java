package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lynch
 * @date 2020/3/24 22:18
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * http://localhost:8006/payment/consul
     * @return
     */
    @RequestMapping("/payment/consul")
    public String paymentConsul() {
        return "SpringCloud with consul:" + serverPort + "\t " + UUID.randomUUID().toString();
    }
}
