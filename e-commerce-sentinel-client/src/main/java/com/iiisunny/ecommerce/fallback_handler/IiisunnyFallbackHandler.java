package com.iiisunny.ecommerce.fallback_handler;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.controller.FlowRuleCodeController;
import com.iiisunny.ecommerce.vo.JwtToken;
import com.iiisunny.ecommerce.vo.UsernameAndPassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>Sentinel 回退降级的兜底策略</h1>
 * 都需要是静态方法
 * */
public class IiisunnyFallbackHandler {

    private static final Logger LOG = LoggerFactory.getLogger(IiisunnyFallbackHandler.class);

    /**
     * <h2>getTokenFromAuthorityService 方法的 fallback</h2>
     * */
    public static JwtToken getTokenFromAuthorityServiceFallback(
            UsernameAndPassword usernameAndPassword
    ) {
        LOG.error("get token from authority service fallback: [{}]",
                JSON.toJSONString(usernameAndPassword));
        return new JwtToken("iiisunny-iiisunny-fallback");
    }

    /**
     * <h2>ignoreException 方法的 fallback</h2>
     * */
    public static JwtToken ignoreExceptionFallback(Integer code) {
        LOG.error("ignore exception input code: [{}] has trigger exception", code);
        return new JwtToken("iiisunny-iiisunny-fallback");
    }
}
