package com.iiisunny.ecommerce.controller;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.annotation.IgnoreResponseAdvice;
import com.iiisunny.ecommerce.service.IJWTService;
import com.iiisunny.ecommerce.vo.JwtToken;
import com.iiisunny.ecommerce.vo.UsernameAndPassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>对外暴露到授权服务接口</h1>
 */
@RestController
@RequestMapping("/authority")
public class AuthorityController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorityController.class);

    private final IJWTService ijwtService;

    public AuthorityController(IJWTService ijwtService) {
        this.ijwtService = ijwtService;
    }

    /**
     * <h2>登录功能，从授权中心获取 Token，且返回信息中没有统一响应的包装</h2>
     * @param usernameAndPassword
     */
    @IgnoreResponseAdvice
    @PostMapping("token")
    public JwtToken token(@RequestBody UsernameAndPassword usernameAndPassword) throws Exception{

        LOG.info("request to get token with param: [{}]", JSON.toJSONString(usernameAndPassword));
        return new JwtToken(ijwtService.generateToken(
                usernameAndPassword.getUsername(),
                usernameAndPassword.getPassword()
        ));
    }

    /**
     * <h2>注册用户并返回当前用户从授权中心获取的 Token，且返回信息中没有统一响应的包装</h2>
     * @param usernameAndPassword
     */
    @IgnoreResponseAdvice
    @PostMapping("register")
    public JwtToken register(@RequestBody UsernameAndPassword usernameAndPassword) throws Exception{

        LOG.info("register user with param: [{}]", JSON.toJSONString(usernameAndPassword));
        return new JwtToken(ijwtService.registerUserAndGenerateToken(usernameAndPassword));
    }

}
