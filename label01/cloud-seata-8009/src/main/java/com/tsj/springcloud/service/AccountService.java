package com.tsj.springcloud.service;

import java.math.BigDecimal;

/**
 * @Author tansj
 * @Date 2022/8/18 10:53
 * @Version 1.0
 */
public interface AccountService {

    int decrease(Integer userId, BigDecimal count);
}
