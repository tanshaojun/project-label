package com.tsj.springcloud.controller;

import com.tsj.springcloud.entities.CommonResult;
import com.tsj.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author tansj
 * @Date 2022/8/18 10:54
 * @Version 1.0
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/decrease")
    public CommonResult decrease(Integer userId, BigDecimal count) {
        int a = 1/0;
        return new CommonResult(200, "扣减金额成功", accountService.decrease(userId, count));
    }

}
