package com.tsj.springcloud.controller;

import com.tsj.springcloud.entities.CommonResult;
import com.tsj.springcloud.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tansj
 * @Date 2022/8/9 14:31
 * @Version 1.0
 */
@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/provider/hystrix/{id}")
    public CommonResult getId(@PathVariable Integer id) {
        return new CommonResult(200, "成功" + port, providerService.getById(id));
    }

    @GetMapping("/provider/ok")
    public CommonResult getOk() {
        return new CommonResult(200, "成功" + port, providerService.getOk());
    }

    @GetMapping("/provider/timeout")
    public CommonResult getTimeout() {
        return new CommonResult(200, "成功" + port, providerService.getTimeout());
    }

}
