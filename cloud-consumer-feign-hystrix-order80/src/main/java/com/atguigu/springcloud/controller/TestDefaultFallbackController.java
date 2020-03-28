package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lynch
 * @date 2020/3/26 14:54
 */
@RestController
@Slf4j
public class TestDefaultFallbackController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * 测试得知，@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")仅在所标注的类中起作用
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/testGlobal/{id}")
    @HystrixCommand
    public String paymentInfo_Global(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_Timeout(id);
    }

}
