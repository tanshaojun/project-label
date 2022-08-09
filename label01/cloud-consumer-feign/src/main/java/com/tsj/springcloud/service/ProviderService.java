package com.tsj.springcloud.service;

import com.tsj.springcloud.entities.CommonResult;
import com.tsj.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author tansj
 * @Date 2022/8/8 16:12
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER")
public interface ProviderService {

    @GetMapping("/provider/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/provider/timeoutTest")
    CommonResult timeoutTest();

}
