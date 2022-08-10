package com.tsj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tansj
 * @Date 2022/8/10 15:29
 * @Version 1.0
 */
@RestController
@RefreshScope
public class NacosConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/getConfig")
    public String getConfig() {
        return configInfo;
    }
}
