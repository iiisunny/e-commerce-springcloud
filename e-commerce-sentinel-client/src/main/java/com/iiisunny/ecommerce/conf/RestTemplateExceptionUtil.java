package com.iiisunny.ecommerce.conf;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.controller.FlowRuleCodeController;
import com.iiisunny.ecommerce.vo.JwtToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * <h1>RestTemplate 在限流或异常时的兜底方法</h1>
 * */
public class RestTemplateExceptionUtil {

    private static final Logger LOG = LoggerFactory.getLogger(RestTemplateExceptionUtil.class);

    /**
     * <h2>限流后的处理方法</h2>
     * */
    public static SentinelClientHttpResponse handleBlock(HttpRequest request,
                                                         byte[] body,
                                                         ClientHttpRequestExecution execution,
                                                         BlockException ex) {
        LOG.error("Handle RestTemplate Block Exception: [{}], [{}]",
                request.getURI().getPath(), ex.getClass().getCanonicalName());
        return new SentinelClientHttpResponse(
                JSON.toJSONString(new JwtToken("iiisunny-iiisunny-block"))
        );
    }

    /**
     * <h2>异常降级之后的处理方法</h2>
     * */
    public static SentinelClientHttpResponse handleFallback(HttpRequest request,
                                                            byte[] body,
                                                            ClientHttpRequestExecution execution,
                                                            BlockException ex) {
        LOG.error("Handle RestTemplate Fallback Exception: [{}], [{}]",
                request.getURI().getPath(), ex.getClass().getCanonicalName());
        return new SentinelClientHttpResponse(
                JSON.toJSONString(new JwtToken("iiisunny-iiisunny-block"))
        );
    }
}
