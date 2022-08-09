package com.tsj.springcloud.controller;

import com.tsj.springcloud.entities.CommonResult;
import com.tsj.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author tansj
 * @Date 2022/8/5 10:22
 * @Version 1.0
 */
@RestController
@Slf4j
public class ConsumerController {

    private final static String URL_PROVIDER = "http://CLOUD-PROVIDER-CONSUL";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        log.info("consumer execute get");
        return restTemplate.getForObject(URL_PROVIDER + "/provider/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/create")
    public CommonResult create(Payment payment) {
        log.info("consumer execute create");
        return restTemplate.postForObject(URL_PROVIDER + "/provider/create", payment, CommonResult.class);
    }

}
