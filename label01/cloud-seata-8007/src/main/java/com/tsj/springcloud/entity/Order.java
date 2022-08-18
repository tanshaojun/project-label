package com.tsj.springcloud.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author tansj
 * @Date 2022/8/18 09:59
 * @Version 1.0
 */
@Data
public class Order {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer count;
    private BigDecimal money;
    private Integer state;
}
