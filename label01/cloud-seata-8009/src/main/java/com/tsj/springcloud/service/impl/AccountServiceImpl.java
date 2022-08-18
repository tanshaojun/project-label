package com.tsj.springcloud.service.impl;

import com.tsj.springcloud.mapper.AccountMapper;
import com.tsj.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author tansj
 * @Date 2022/8/18 10:53
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int decrease(Integer userId, BigDecimal count) {
        return accountMapper.decrease(userId, count);
    }
}
