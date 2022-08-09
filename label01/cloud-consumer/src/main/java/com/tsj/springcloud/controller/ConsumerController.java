package com.tsj.springcloud.controller;

import com.tsj.springcloud.entities.CommonResult;
import com.tsj.springcloud.entities.Payment;
import com.tsj.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author tansj
 * @Date 2022/8/5 10:22
 * @Version 1.0
 */
@RestController
@Slf4j
public class ConsumerController {

    private final static String URL_PROVIDER = "http://CLOUD-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancer loadBalancer;


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

    @GetMapping("/consumer/server")
    public CommonResult getServer() {
        //获取所有CLOUD-PROVIDER的服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER");
        ServiceInstance serviceInstance = loadBalancer.getServiceInstance(instances);
        return new CommonResult(200, "成功", serviceInstance.getPort());
    }

}
