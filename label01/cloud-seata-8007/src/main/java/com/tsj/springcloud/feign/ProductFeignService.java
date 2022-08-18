package com.tsj.springcloud.feign;

import com.tsj.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignService 必须要被spring 管理，不然无法访问
 *
 * @Author tansj
 * @Date 2022/8/18 10:15
 * @Version 1.0
 */
@Component
@FeignClient(value = "cloud-seata-8008")
public interface ProductFeignService {

    @GetMapping("/product/decrease")
    CommonResult decrease(@RequestParam(name = "productId") Integer productId, @RequestParam(name = "count") Integer count);

}
