package com.tsj.springcloud.entity;

import lombok.Data;

/**
 * @Author tansj
 * @Date 2022/8/18 09:59
 * @Version 1.0
 */
@Data
public class Product {
    private Integer id;
    private Integer productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
