package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;

/**
 * 订单服务
 * @author lynch
 * @date 2020/4/8 18:44
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}