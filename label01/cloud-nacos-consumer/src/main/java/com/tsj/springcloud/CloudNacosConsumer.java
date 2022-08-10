package com.tsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author tansj
 * @Date 2022/8/10 14:57
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosConsumer {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConsumer.class, args);
    }
}
