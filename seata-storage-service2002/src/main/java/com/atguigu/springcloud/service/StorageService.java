package com.atguigu.springcloud.service;

/**
 * 库存服务
 *
 * @author lynch
 * @date 2020/4/9 14:45
 */
public interface StorageService {
    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    void decrease(Long productId, Integer count);
}