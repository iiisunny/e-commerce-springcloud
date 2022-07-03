package com.iiisunny.ecommerce.service;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.util.TokenParseUtil;
import com.iiisunny.ecommerce.vo.LoginUserInfo;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>JWT 相关服务测试</h1>
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class JWTServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(JWTServiceTest.class);

    @Autowired
    private IJWTService ijwtService;

    public void testGenerateAndParseToken() throws Exception {

        String jwtToken = ijwtService.generateToken(
                "xxx",
                "xxx"
        );
        LOG.info("jwt token is: [{}]", jwtToken);

        LoginUserInfo loginUserInfo = TokenParseUtil.parseUserInfoFromToken(jwtToken);
        LOG.info("parse token: [{}]", JSON.toJSONString(loginUserInfo));
    }
}
