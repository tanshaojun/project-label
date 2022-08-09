package com.tsj.springcloud.service;

import com.tsj.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Author tansj
 * @Date 2022/8/9 16:02
 * @Version 1.0
 */
@Component
public class ProviderHystrixServiceFallback implements ProviderHystrixService {
    @Override
    public CommonResult getOk() {
        return new CommonResult(500, "失败", "getOk");
    }

    @Override
    public CommonResult getTimeout() {
        return new CommonResult(500, "失败", "getTimeout");
    }
}
