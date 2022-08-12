package com.tsj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tsj.springcloud.handler.CustomerHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tansj
 * @Date 2022/8/11 15:13
 * @Version 1.0
 */
@RestController
public class FlowLimitController {

    @GetMapping("testA")
    public String testA() {
        return "testA";
    }

    @GetMapping("testB")
    public String testB() {
        return "testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
//    @SentinelResource(value = "testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1) {
        return "testHotKey";
    }

    public String deal_testHotKey(String p1, BlockException exception) {
        return "deal_testHotKey";
    }

    @GetMapping("/testCustomerHandler")
    @SentinelResource(value = "testCustomerHandler", blockHandlerClass = CustomerHandler.class, blockHandler = "handler")
    public String testCustomerHandler() {
        return "testCustomerHandler";
    }


}
