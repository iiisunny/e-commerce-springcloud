package com.iiisunny.ecommerce.stream;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.vo.IiisunnyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * <h1>使用默认的信道实现消息的接收</h1>
 * */
@EnableBinding(Sink.class)
public class DefaultReceiveService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultReceiveService.class);

    /**
     * <h2>使用默认的输入信道接收消息</h2>
     * */
    @StreamListener(Sink.INPUT)
    public void receiveMessage(Object payload) {

        LOG.info("in DefaultReceiveService consume message start");
        IiisunnyMessage qinyiMessage = JSON.parseObject(
                payload.toString(), IiisunnyMessage.class
        );
        // 消费消息
        LOG.info("in DefaultReceiveService consume message success: [{}]",
                JSON.toJSONString(qinyiMessage));
    }
}
