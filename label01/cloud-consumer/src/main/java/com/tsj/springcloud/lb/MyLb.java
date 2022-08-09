package com.tsj.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author tansj
 * @Date 2022/8/8 15:35
 * @Version 1.0
 */
@Component
@Slf4j
public class MyLb implements LoadBalancer {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> list) {
        int count = atomicInteger.incrementAndGet();
        log.info("当前第{}次请求", count);
        int size = list.size();
        return list.get(count % size);
    }
}
