package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lynch
 * @date 2020/3/10 22:04
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource   //java自带的依赖注入，区别于@Autowired
    private PaymentDao paymentDao;


    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
