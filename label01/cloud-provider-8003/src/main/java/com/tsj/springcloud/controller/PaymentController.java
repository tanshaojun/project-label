package com.tsj.springcloud.controller;

import com.tsj.springcloud.entities.CommonResult;
import com.tsj.springcloud.entities.Payment;
import com.tsj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

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

}
