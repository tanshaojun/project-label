package com.tsj.springcloud.service.impl;

import com.tsj.springcloud.entity.Order;
import com.tsj.springcloud.feign.AccountFeignService;
import com.tsj.springcloud.feign.ProductFeignService;
import com.tsj.springcloud.mapper.OrderMapper;
import com.tsj.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tansj
 * @Date 2022/8/18 09:58
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductFeignService productFeignService;

    @Autowired
    private AccountFeignService accountFeignService;

    @Override
    @GlobalTransactional //seata分布式事务注解
    public int create(Order order) {

        log.info("创建订单开始");
        orderMapper.create(order);
        log.info("创建订单结束");

        log.info("扣减库存开始");
        productFeignService.decrease(order.getProductId(), order.getCount());
        log.info("扣减库存结束");

        log.info("扣减金额开始");
        accountFeignService.decrease(order.getUserId(), order.getMoney());
        log.info("扣减金额结束");

        log.info("修改订单状态开始");
        orderMapper.updateState(order.getUserId(), 1);
        log.info("修改订单状态结束");

        return 1;
    }

    @Override
    public int updateState(Integer userId, Integer state) {
        return orderMapper.updateState(userId, state);
    }

}
