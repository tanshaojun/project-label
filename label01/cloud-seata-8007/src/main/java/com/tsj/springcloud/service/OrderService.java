package com.tsj.springcloud.service;

import com.tsj.springcloud.entity.Order;

/**
 * @Author tansj
 * @Date 2022/8/18 09:57
 * @Version 1.0
 */
public interface OrderService {

    int create(Order order);

    int updateState(Integer userId, Integer state);

}
