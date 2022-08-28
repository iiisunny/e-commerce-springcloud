package com.iiisunny.ecommerce.stream;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.vo.IiisunnyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * <h1>使用默认的通信信道实现消息的发送</h1>
 * */
@EnableBinding(Source.class)
public class DefaultSendService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultSendService.class);

    private final Source source;

    public DefaultSendService(Source source) {
        this.source = source;
    }

    /**
     * <h2>使用默认的输出信道发送消息</h2>
     * */
    public void sendMessage(IiisunnyMessage message) {

        String _message = JSON.toJSONString(message);
        LOG.info("in DefaultSendService send message: [{}]", _message);

        // Spring Messaging, 统一消息的编程模型, 是 Stream 组件的重要组成部分之一
        source.output().send(MessageBuilder.withPayload(_message).build());
    }
}
