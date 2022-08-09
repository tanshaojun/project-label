package com.tsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author tansj
 * @Date 2022/8/8 16:08
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class CloudConsumerFeign {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeign.class, args);
    }
}
