package com.tsj.springcloud.controller;

import com.tsj.springcloud.entities.CommonResult;
import com.tsj.springcloud.entities.Payment;
import com.tsj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/provider/timeoutTest")
    public CommonResult timeoutTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult<Payment>(200, "成功" + serverPort, null);
    }

    @GetMapping("/provider/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("provider execute getPayment");
        return new CommonResult<Payment>(200, "成功" + serverPort, payment);
    }

    @PostMapping("/provider/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        log.info("provider execute create");
        int i = paymentService.create(payment);
        return new CommonResult<Integer>(200, "成功" + serverPort, i);
    }

    @GetMapping("/provider/discovery")
    public CommonResult discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service name:{}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER");
        for (ServiceInstance instance : instances) {
            log.info("instanceId:{},host:{},port:{},uri:{}", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return new CommonResult(200, "成功" + serverPort, services);
    }

}
