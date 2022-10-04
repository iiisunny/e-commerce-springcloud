package com.iiisunny.ecommerce.block_handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.controller.FlowRuleCodeController;
import com.iiisunny.ecommerce.vo.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>自定义通用的限流处理逻辑</h1>
 * */
public class IiiunnyBlockHandler {

    private static final Logger LOG = LoggerFactory.getLogger(IiiunnyBlockHandler.class);

    /**
     * <h2>通用限流处理方法</h2>
     * 这个方法必须是 static 的
     * */
    public static CommonResponse<String> iiisunnyHandleBlockException(BlockException exception) {

        LOG.error("trigger iiisunny block handler: [{}], [{}]",
                JSON.toJSONString(exception.getRule()), exception.getRuleLimitApp());
        return new CommonResponse<>(
                -1,
                "flow rule trigger block exception",
                null
        );
    }
}
