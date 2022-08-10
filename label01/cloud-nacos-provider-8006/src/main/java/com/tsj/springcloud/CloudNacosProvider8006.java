package com.tsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author tansj
 * @Date 2022/8/10 14:51
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosProvider8006 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosProvider8006.class, args);
    }
}
