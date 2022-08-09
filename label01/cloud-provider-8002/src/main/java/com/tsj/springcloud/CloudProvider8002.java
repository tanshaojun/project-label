package com.tsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author tansj
 * @Date 2022/8/4 15:32
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudProvider8002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProvider8002.class, args);
    }
}
