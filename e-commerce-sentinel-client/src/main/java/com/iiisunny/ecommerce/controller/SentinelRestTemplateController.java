package com.iiisunny.ecommerce.controller;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.vo.JwtToken;
import com.iiisunny.ecommerce.vo.UsernameAndPassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>使用 Sentinel 保护 RestTemplate 服务间调用</h1>
 * */
@RestController
@RequestMapping("/sentinel-rest-template")
public class SentinelRestTemplateController {

    private static final Logger LOG = LoggerFactory.getLogger(SentinelRestTemplateController.class);

    private final RestTemplate restTemplate;

    public SentinelRestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * <h2>从授权服务中获取 JwtToken</h2>
     * 1. 流控降级:
     * 是针对于簇点链路中的 http://127.0.0.1:7000/ecommerce-authority-center/authority/token
     * 2. 容错降级: 对于服务不可用时不能生效
     * */
    @PostMapping("/get-token")
    public JwtToken getTokenFromAuthorityService(
            @RequestBody UsernameAndPassword usernameAndPassword) {

        String requestUrl =
                "http://127.0.0.1:7000/ecommerce-authority-center/authority/token";
        LOG.info("RestTemplate request url and body: [{}], [{}]",
                requestUrl, JSON.toJSONString(usernameAndPassword));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForObject(
                requestUrl,
                new HttpEntity<>(JSON.toJSONString(usernameAndPassword), headers),
                JwtToken.class
        );
    }
}
