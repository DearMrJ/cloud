package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author lynch
 * @date 2020/3/10 0:43
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
