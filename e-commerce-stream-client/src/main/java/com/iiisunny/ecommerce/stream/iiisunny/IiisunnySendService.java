package com.iiisunny.ecommerce.stream.iiisunny;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.stream.DefaultSendService;
import com.iiisunny.ecommerce.vo.IiisunnyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * <h1>使用自定义的通信信道 QinyiSource 实现消息的发送</h1>
 * */
@EnableBinding(IiisunnySource.class)
public class IiisunnySendService {

    private static final Logger LOG = LoggerFactory.getLogger(IiisunnySendService.class);

    private final IiisunnySource qinyiSource;

    public IiisunnySendService(IiisunnySource qinyiSource) {
        this.qinyiSource = qinyiSource;
    }

    /**
     * <h2>使用自定义的输出信道发送消息</h2>
     * */
    public void sendMessage(IiisunnyMessage message) {

        String _message = JSON.toJSONString(message);
        LOG.info("in QinyiSendService send message: [{}]", _message);
        qinyiSource.qinyiOutput().send(
                MessageBuilder.withPayload(_message).build()
        );
    }
}
