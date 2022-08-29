package com.iiisunny.ecommerce.partition;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.stream.DefaultReceiveService;
import com.iiisunny.ecommerce.vo.IiisunnyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * <h1>自定义从 Message 中提取 partition key 的策略</h1>
 * */
@Component
public class IiisunnyPartitionKeyExtractorStrategy implements PartitionKeyExtractorStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(IiisunnyPartitionKeyExtractorStrategy.class);

    @Override
    public Object extractKey(Message<?> message) {

        IiisunnyMessage iiisunnyMessage = JSON.parseObject(
                message.getPayload().toString(), IiisunnyMessage.class
        );
        // 自定义提取 key
        String key = iiisunnyMessage.getProjectName();
        LOG.info("SpringCloud Stream Qinyi Partition Key: [{}]", key);
        return key;
    }
}
