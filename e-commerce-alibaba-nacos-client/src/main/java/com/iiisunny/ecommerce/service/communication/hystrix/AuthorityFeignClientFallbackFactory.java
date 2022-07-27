package com.iiisunny.ecommerce.service.communication.hystrix;

import com.iiisunny.ecommerce.service.communication.AuthorityFeignClient;
import com.iiisunny.ecommerce.vo.JwtToken;
import com.iiisunny.ecommerce.vo.UsernameAndPassword;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <h1>OpenFeign 集成 Hystrix 的另一种模式</h1>
 * */
@Component
public class AuthorityFeignClientFallbackFactory
        implements FallbackFactory<AuthorityFeignClient> {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorityFeignClientFallbackFactory.class);

    @Override
    public AuthorityFeignClient create(Throwable throwable) {

        LOG.warn("authority feign client get token by feign request error " +
                "(Hystrix FallbackFactory): [{}]", throwable.getMessage(), throwable);

        return new AuthorityFeignClient() {

            @Override
            public JwtToken getTokenByFeign(UsernameAndPassword usernameAndPassword) {
                return new JwtToken("xxx-factory");
            }
        };
    }
}
