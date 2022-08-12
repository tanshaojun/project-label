package com.tsj.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 自定义限流handler,方法必须是静态的
 *
 * @Author tansj
 * @Date 2022/8/12 16:39
 * @Version 1.0
 */
public class CustomerHandler {

    public static String handler(BlockException exception) {
        return "handler";
    }

    public static String handler1(BlockException exception) {
        return "handler";
    }


}
