package com.tsj.springcloud.service;

import com.tsj.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author tansj
 * @Date 2022/8/9 15:03
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-8004", fallback = ProviderHystrixServiceFallback.class)
public interface ProviderHystrixService {

    @GetMapping("/provider/ok")
    CommonResult getOk();

    @GetMapping("/provider/timeout")
    CommonResult getTimeout();

}
