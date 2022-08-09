package com.tsj.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author tansj
 * @Date 2022/8/8 15:33
 * @Version 1.0
 */
public interface LoadBalancer {
    ServiceInstance getServiceInstance(List<ServiceInstance> list);
}
