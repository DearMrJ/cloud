package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 库存服务
 *
 * @author lynch
 * @date 2020/4/9 14:19
 */
@Service
public interface AccountService {

    /**
     * 减库存操作
     *
     * @param userId 用户id
     * @param money  金额
     * @return
     */
    void decrease(Long userId, BigDecimal money);
}