package com.tsj.springcloud.feign;

import com.tsj.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * FeignService 必须要被spring 管理，不然无法访问
 *
 * @Author tansj
 * @Date 2022/8/18 10:15
 * @Version 1.0
 */
@Component
@FeignClient(value = "cloud-seata-8009")
public interface AccountFeignService {

    @GetMapping("/account/decrease")
    CommonResult decrease(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "count") BigDecimal count);

}
