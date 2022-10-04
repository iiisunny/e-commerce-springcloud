package com.iiisunny.ecommerce.controller;

import com.iiisunny.ecommerce.feign.SentinelFeignClient;
import com.iiisunny.ecommerce.vo.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>OpenFeign 集成 Sentinel 实现熔断降级</h1>
 * */
@RestController
@RequestMapping("/sentinel-feign")
public class SentinelFeignController {

    private static final Logger LOG = LoggerFactory.getLogger(SentinelFeignController.class);

    private final SentinelFeignClient sentinelFeignClient;

    public SentinelFeignController(SentinelFeignClient sentinelFeignClient) {
        this.sentinelFeignClient = sentinelFeignClient;
    }

    /**
     * <h2>通过 Feign 接口去获取结果</h2>
     * */
    @GetMapping("/result-by-feign")
    public CommonResponse<String> getResultByFeign(@RequestParam Integer code) {
        LOG.info("coming in get result by feign: [{}]", code);
        return sentinelFeignClient.getResultByFeign(code);
    }
}
