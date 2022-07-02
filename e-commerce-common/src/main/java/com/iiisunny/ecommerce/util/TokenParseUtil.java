package com.iiisunny.ecommerce.util;

import cn.hutool.core.codec.Base64Decoder;
import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.constant.CommonConstant;
import com.iiisunny.ecommerce.vo.LoginUserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;

/**
 * <h1>JWT Token 解析工具类</h1>
 */
public class TokenParseUtil {

    /**
     * <h2>从 JWT Token 中解析 LoginUserInfo 对象</h2>
     */
    public static LoginUserInfo parseUserInfoFromToken(String token) throws Exception {

        if (null == token) {
            return null;
        }

        Jws<Claims> claimsJws = parseToken(token, getPublicKey());
        Claims body = claimsJws.getBody();

        // 如果 Token 已经过期，返回 null
        if (body.getExpiration().before(Calendar.getInstance().getTime())) {
            return null;
        }

        // 返回 Token 中保存的用户信息
        return JSON.parseObject(
                body.get(CommonConstant.JWT_USER_INFO_KEY).toString(),
                LoginUserInfo.class
        );
    }

    /**
     * <h2>通过公钥去解析 JWT Token</h2>
     */
    private static Jws<Claims> parseToken(String token, PublicKey publicKey) {

        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
    }

    /**
     * <h2>根据本地存储的公钥获取到 PublicKey 对象</h2>
     */
    private static PublicKey getPublicKey() throws Exception {

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec (
                Base64Decoder.decode(CommonConstant.PUBLIC_KEY)
        );
        return KeyFactory.getInstance("RSA").generatePublic(keySpec);
    }
}
