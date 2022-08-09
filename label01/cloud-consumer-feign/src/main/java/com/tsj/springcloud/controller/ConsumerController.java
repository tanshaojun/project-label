package com.tsj.springcloud.controller;

import com.tsj.springcloud.entities.CommonResult;
import com.tsj.springcloud.entities.Payment;
import com.tsj.springcloud.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tansj
 * @Date 2022/8/5 10:22
 * @Version 1.0
 */
@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        log.info("consumer execute get");
        return providerService.getPaymentById(id);
    }

    @GetMapping("/provider/timeoutTest")
    public CommonResult timeoutTest() {
        return providerService.timeoutTest();
    }
}
