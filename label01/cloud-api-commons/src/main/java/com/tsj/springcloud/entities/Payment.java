package com.tsj.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author tansj
 * @Date 2022/8/4 15:58
 * @Version 1.0
 */
@Data
public class Payment implements Serializable {
    private long id;
    private String serial;
}
