package com.tsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author tansj
 * @Date 2022/8/5 16:49
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProvider8003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProvider8003.class, args);
    }
}
