package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lynch
 * @date 2020/3/10 0:43
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        System.err.println("====================>" + payment.getSerial());
        int result = paymentService.create(payment);
        log.info("***********插入结果：" + result + "\t O(∩_∩)O");
        if (result > 0) {
            return new CommonResult(200, "插入数据成功[server.port: " + serverPort + "]", result);
        }
        return new CommonResult(444, "插入数据失败[server.port: " + serverPort + "]");
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            return new CommonResult(200, "查询成功[server.port: " + serverPort + "]", payment);
        }
        return new CommonResult(444, "没有对应记录，[server.port: " + serverPort + "],查询id：" + id);
    }

    @GetMapping("/payment/lb")
    public String getPaymentWithCustomLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
