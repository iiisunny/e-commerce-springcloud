package com.iiisunny.ecommerce.service;

import cn.hutool.core.codec.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


/**
 * <h1>RAS 非对称加密算法：生成公钥和私钥</h1>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RSATest {

    private static final Logger LOG = LoggerFactory.getLogger(RSATest.class);

    @Test
    public void generateKeyBytes() throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RAS");
        keyPairGenerator.initialize(2048);

        // 生成公钥和私钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 获取公钥和私钥对象
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateCrtKey = (RSAPrivateKey) keyPair.getPrivate();

        LOG.info("private key: [{}]", Base64.encode(privateCrtKey.getEncoded()));
        LOG.info("public key: [{}]", Base64.encode(publicKey.getEncoded()));

    }
}
