package com.tsj.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @Author tansj
 * @Date 2022/8/9 14:31
 * @Version 1.0
 */
@Service
public class ProviderService {


    public String getOk() {
        return "ok";
    }

    @HystrixCommand(fallbackMethod = "getTimeout_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String getTimeout() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout";
    }

    public String getTimeout_fallback() {
        return "timeout fallback";
    }

    //断路器开启或者关闭的条件
    //当满足一定的阀值的时候(默认10秒内超过20个请求次数)
    //当失败率到达一定的时候(默认10秒内超过50%的请求失败)
    //满足以上条件，断路器将会开启，开启的时候，所有请求都是走fallback。
    // 一定时间之后(默认是5秒)。这个时候断路器会处于半开状态，会让其中一个请求进入。如果请求成功，则关闭断路器。否则。继续开启，5秒后重试
    @HystrixCommand(fallbackMethod = "getById_fallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
            }) // 在10s内10次请求有60%失败 // 先看次数，再看百分比
    public String getById(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String getById_fallback(Integer id) {
        return "getById_fallback," + id;
    }

}
