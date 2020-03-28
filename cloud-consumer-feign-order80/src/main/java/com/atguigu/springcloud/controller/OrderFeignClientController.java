package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lynch
 * @date 2020/3/25 11:52
 */
@RestController
@Slf4j
public class OrderFeignClientController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        CommonResult payment = paymentFeignService.getPaymentById(id);
        return payment;
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
