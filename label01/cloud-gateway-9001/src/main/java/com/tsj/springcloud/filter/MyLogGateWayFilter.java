package com.tsj.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * gateway 过滤器
 *
 * @Author tansj
 * @Date 2022/8/10 13:57
 * @Version 1.0
 */
@Slf4j
@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("global filter");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
