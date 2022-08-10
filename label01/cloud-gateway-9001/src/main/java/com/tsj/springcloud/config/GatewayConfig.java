package com.tsj.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author tansj
 * @Date 2022/8/10 11:06
 * @Version 1.0
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator buildRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("provider-8001-2", r -> r.path("/provider/discovery").uri("http://localhost:8001/provider/discovery")).build();
        return routes.build();
    }
}
