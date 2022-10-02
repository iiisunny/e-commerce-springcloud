package com.iiisunny.ecommerce.service;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.dao.EcommerceLogisticsDao;
import com.iiisunny.ecommerce.entity.EcommerceLogistics;
import com.iiisunny.ecommerce.order.LogisticsMessage;
import com.iiisunny.ecommerce.sink.LogisticsSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * <h1>物流服务实现</h1>
 * */
@EnableBinding(LogisticsSink.class)
public class LogisticsServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(LogisticsServiceImpl.class);

    private final EcommerceLogisticsDao logisticsDao;

    public LogisticsServiceImpl(EcommerceLogisticsDao logisticsDao) {
        this.logisticsDao = logisticsDao;
    }

    /**
     * <h2>订阅监听订单微服务发送的物流消息</h2>
     * */
    @StreamListener("logisticsInput")
    public void consumeLogisticsMessage(@Payload Object payload) {

        LOG.info("receive and consume logistics message: [{}]", payload.toString());
        LogisticsMessage logisticsMessage = JSON.parseObject(
                payload.toString(), LogisticsMessage.class
        );
        EcommerceLogistics ecommerceLogistics = logisticsDao.save(
                new EcommerceLogistics(
                        logisticsMessage.getUserId(),
                        logisticsMessage.getOrderId(),
                        logisticsMessage.getAddressId(),
                        logisticsMessage.getExtraInfo()
                )
        );
        LOG.info("consume logistics message success: [{}]", ecommerceLogistics.getId());
    }
}
