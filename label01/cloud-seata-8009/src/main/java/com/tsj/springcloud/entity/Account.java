package com.tsj.springcloud.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author tansj
 * @Date 2022/8/18 09:59
 * @Version 1.0
 */
@Data
public class Account {
    private Integer id;
    private Integer userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
