package com.tsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author tansj
 * @Date 2022/8/10 10:03
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGateway9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateway9001.class, args);
    }
}
