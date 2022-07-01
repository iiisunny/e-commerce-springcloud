package com.iiisunny.ecommerce.service.impl;

import cn.hutool.core.codec.Base64Decoder;
import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.constant.AuthorityConstant;
import com.iiisunny.ecommerce.constant.CommonConstant;
import com.iiisunny.ecommerce.dao.EcommerceUserDao;
import com.iiisunny.ecommerce.entity.EcommerceUser;
import com.iiisunny.ecommerce.service.IJWTService;
import com.iiisunny.ecommerce.vo.LoginUserInfo;
import com.iiisunny.ecommerce.vo.UsernameAndPassword;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/**
 * <h1>JWT 相关服务接口实现</h1>
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JWTServiceImpl implements IJWTService {

    private static final Logger LOG = LoggerFactory.getLogger(JWTServiceImpl.class);

    private final EcommerceUserDao ecommerceUserDao;

    public JWTServiceImpl(EcommerceUserDao ecommerceUserDao) {
        this.ecommerceUserDao = ecommerceUserDao;
    }

    @Override
    public String generateToken(String username, String password) throws Exception {
        return generateToken(username, password, 0);
    }

    @Override
    public String generateToken(String username, String password, int expire) throws Exception {

        // 需要首先验证用户是否能够通过授权检验，即输入的用户名和密码能匹配数据表记录
        EcommerceUser ecommerceUser = ecommerceUserDao.findByUsernameAndPassword(
                username, password
        );
        if (null == ecommerceUser){
            LOG.info("can not find user: [{}], [{}]", username, password);
            return null;
        }

        // Token 中塞入对象，即 JWT 中存储的信息，后端拿到这些信息就可以知道是哪个用户在操作
        LoginUserInfo loginUserInfo = new LoginUserInfo(
                ecommerceUser.getId(), ecommerceUser.getUsername()
        );

        if (expire <= 0){
            expire = AuthorityConstant.DEFAULT_EXPIRE_DAY;
        }

        // 计算超时时间
        ZonedDateTime zdt = LocalDate.now().plus(expire, ChronoUnit.DAYS)
                .atStartOfDay(ZoneId.systemDefault());
        Date expireDate = Date.from(zdt.toInstant());

        return Jwts.builder()
                // jwt payload --> KV
                .claim(CommonConstant.JWT_USER_INFO_KEY, JSON.toJSONString(loginUserInfo))
                // jwt id
                .setId(UUID.randomUUID().toString())
                // jwt 过期时间
                .setExpiration(expireDate)
                // jwt 签名 --> 加密
                .signWith(getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    @Override
    public String registerUserAndGenerateToken(UsernameAndPassword usernameAndPassword) throws Exception {

        // 先去校验用户名是否存在，如果存在就不能重复注册
        EcommerceUser oldUser = ecommerceUserDao.findByUsername(
                usernameAndPassword.getUsername()
        );
        if (null != oldUser){
            LOG.error("username is registered: [{}]", oldUser.getUsername());
            return null;
        }

        EcommerceUser ecommerceUser = new EcommerceUser();
        ecommerceUser.setUsername(usernameAndPassword.getUsername());

        // MD5 编码以后的密码
        ecommerceUser.setPassword(usernameAndPassword.getPassword());
        ecommerceUser.setExtraInfo("{}");

        // 注册一个新用户，就落库一条
        ecommerceUser = ecommerceUserDao.save(ecommerceUser);
        LOG.info("register user success: [{}], [{}]", ecommerceUser.getUsername(), ecommerceUser.getId());

        // 生成 token 并返回
        return generateToken(ecommerceUser.getUsername(), ecommerceUser.getPassword());
    }

    /**
     * <h2>根据本地存储的私钥获取到 Privatekey 对象</h2>
     * @return the private key
     */
    private PrivateKey getPrivateKey() throws Exception{

        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Decoder.decode(AuthorityConstant.PRIVATE_KEY));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(priPKCS8);
    }
}
