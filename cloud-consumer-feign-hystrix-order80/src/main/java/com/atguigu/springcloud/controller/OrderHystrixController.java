package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lynch
 * @date 2020/3/25 23:01
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {//@HystrixCommand 需要配合 @EnableCircuitBreaker 或者 @EnableHystrix 激活使用
            //设置自身调用的超时时间峰值，峰值内可以正常运行，超过了需要由兜底的方法处理，作服务降级fallback
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_Timeout(id);

    }


    @GetMapping("/consumer/payment/hystrix/global/{id}")
    @HystrixCommand
    public String paymentInfo_Global(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_Timeout(id);
    }

    /**
     * 要求FallBack方法和调用方法的返回值类型，参数列表必须一致
     * @param id
     * @return
     */
    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id) {
        return "80 ：支付系统繁忙，请稍后再试，o(╥﹏╥)o";
    }


    /**
     * global fallback
     * 由于此中方式，FallBack方法属于统一错误处理方法，应当适用所有服务调用发放的错误调用，
     * 因此此种方式默认调用空参FallBack方法，所以改FallBack方法的参数列表为空参即可：
     * @return
     */
    public String paymentGlobalFallbackMethod() {
        return "[GlobalFallback]支付系统繁忙，请稍后再试，(⊙o⊙)…";
    }
}
