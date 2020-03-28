package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lynch
 * @date 2020/3/25 11:53
 */
@Component
@FeignClient(name = "CLOUD-PROVIDER-PAYMENT") //目标服务
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);


    /**
     * 模拟feign超时
     *
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
