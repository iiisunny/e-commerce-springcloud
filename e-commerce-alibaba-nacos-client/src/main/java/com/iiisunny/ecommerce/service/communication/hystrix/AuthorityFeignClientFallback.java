package com.iiisunny.ecommerce.service.communication.hystrix;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.service.communication.AuthorityFeignClient;
import com.iiisunny.ecommerce.vo.JwtToken;
import com.iiisunny.ecommerce.vo.UsernameAndPassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <h1>AuthorityFeignClient 后备 fallback</h1>
 * */
@Component
public class AuthorityFeignClientFallback implements AuthorityFeignClient {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorityFeignClientFallback.class);

    @Override
    public JwtToken getTokenByFeign(UsernameAndPassword usernameAndPassword) {

        LOG.info("authority feign client get token by feign request error " +
                "(Hystrix Fallback): [{}]", JSON.toJSONString(usernameAndPassword));
        return new JwtToken("xxxxx");
    }
}
