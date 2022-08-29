package com.iiisunny.ecommerce.stream.iiisunny;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.vo.IiisunnyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * <h1>使用自定义的输入信道实现消息的接收</h1>
 * */

@EnableBinding(IiisunnySink.class)
public class IiisunnyReceiveService {

    private static final Logger LOG = LoggerFactory.getLogger(IiisunnyReceiveService.class);

    /** 使用自定义的输入信道接收消息 */
    @StreamListener(IiisunnySink.INPUT)
    public void receiveMessage(@Payload Object payload) {

        LOG.info("in QinyiReceiveService consume message start");
        IiisunnyMessage iiisunnyMessage = JSON.parseObject(payload.toString(), IiisunnyMessage.class);
        LOG.info("in QinyiReceiveService consume message success: [{}]",
                JSON.toJSONString(iiisunnyMessage));
    }
}
