package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lynch
 * @date 2020/3/25 23:03
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "*-*-*-*-*-*-*-*PaymentFallbackService fallback : paymentInfo_OK*-*-*-*-*-*-*-*";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "*-*-*-*-*-*-*-*PaymentFallbackService fallback : paymentInfo_Timeout*-*-*-*-*-*-*-*";
    }
}
