package com.iiisunny.ecommerce.partition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.binder.PartitionSelectorStrategy;
import org.springframework.stereotype.Component;

/**
 * <h1>决定 message 发送到哪个分区的策略</h1>
 * */
@Component
public class IiisunnyPartitionSelectorStrategy implements PartitionSelectorStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(IiisunnyPartitionSelectorStrategy.class);

    /**
     * <h2>选择分区的策略</h2>
     * */
    @Override
    public int selectPartition(Object key, int partitionCount) {

        int partition = key.toString().hashCode() % partitionCount;
        LOG.info("SpringCloud Stream Qinyi Selector info: [{}], [{}], [{}]",
                key.toString(), partitionCount, partition);

        return partition;
    }
}
