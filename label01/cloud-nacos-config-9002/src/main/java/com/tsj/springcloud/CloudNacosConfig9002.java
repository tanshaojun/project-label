package com.tsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author tansj
 * @Date 2022/8/10 15:18
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosConfig9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConfig9002.class, args);
    }
}
