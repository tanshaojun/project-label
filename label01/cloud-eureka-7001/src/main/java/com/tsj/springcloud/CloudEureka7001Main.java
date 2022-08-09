package com.tsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author tansj
 * @Date 2022/8/5 14:10
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEureka7001Main {

    public static void main(String[] args) {
        SpringApplication.run(CloudEureka7001Main.class, args);
    }

}
