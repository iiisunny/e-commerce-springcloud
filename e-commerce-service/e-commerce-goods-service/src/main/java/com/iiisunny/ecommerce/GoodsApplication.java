package com.iiisunny.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * <h1>商品微服务入口启动</h1>
 * 启动依赖组件/中间价：Redis + MySQL + Nacos + Kafka + Zipkin
 * <a href="http://127.0.0.1:8081/ecommerce-goods-service/doc.html">...</a>
 */
@EnableJpaAuditing
@EnableDiscoveryClient
@SpringBootApplication
public class GoodsApplication {

    public static void main(String[] args) {

        SpringApplication.run(GoodsApplication.class, args);
    }
}
