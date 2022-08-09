package com.tsj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tsj.springcloud.entities.CommonResult;
import com.tsj.springcloud.service.ProviderHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tansj
 * @Date 2022/8/9 15:03
 * @Version 1.0
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class ProviderHystrixController {

    @Autowired
    private ProviderHystrixService providerHystrixService;

    @GetMapping("/consumer/ok")
    public CommonResult getOk() {
        return providerHystrixService.getOk();
    }

//    @HystrixCommand(fallbackMethod = "getTimeout_fall", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
//    @HystrixCommand
    @GetMapping("/consumer/timeout")
    public CommonResult getTimeout() {
        return providerHystrixService.getTimeout();
    }

    public CommonResult getTimeout_fall() {
        return new CommonResult(300, "失败", "");
    }

    //全局fallback,需要在方法上添加@HystrixCommand
    public CommonResult defaultFallback() {
        return new CommonResult(300, "失败", "defaultFallback");
    }

}
