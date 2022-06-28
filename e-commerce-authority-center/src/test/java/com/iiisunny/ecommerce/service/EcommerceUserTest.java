package com.iiisunny.ecommerce.service;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.dao.EcommerceUserDao;
import com.iiisunny.ecommerce.entity.EcommerceUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>EcommerceUser 相关的测试</h1>
 * */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EcommerceUserTest {

    private static final Logger LOG = LoggerFactory.getLogger(EcommerceUserTest.class);

    @Autowired
    private EcommerceUserDao ecommerceUserDao;

    @Test
    public void createUserRecord() {

        EcommerceUser ecommerceUser = new EcommerceUser();
        ecommerceUser.setUsername("user1");
        ecommerceUser.setPassword(MD5.create().digestHex("12345678"));
        ecommerceUser.setExtraInfo("{}");
        LOG.info("save user: [{}]",
                JSON.toJSON(ecommerceUserDao.save(ecommerceUser)));
    }
}
