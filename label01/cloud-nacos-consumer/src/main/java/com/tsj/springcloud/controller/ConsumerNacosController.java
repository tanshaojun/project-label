package com.tsj.springcloud.controller;

import com.tsj.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author tansj
 * @Date 2022/8/10 14:58
 * @Version 1.0
 */
@RestController
@Slf4j
public class ConsumerNacosController {

    @Value("${service-url}")
    private String serverName;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        log.info("consumer execute get");
        return restTemplate.getForObject(serverName + "/provider/get/" + id, CommonResult.class);
    }

}
