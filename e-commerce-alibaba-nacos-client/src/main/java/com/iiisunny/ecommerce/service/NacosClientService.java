package com.iiisunny.ecommerce.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author iiisunny
 */
@Service
public class NacosClientService {

    private static final Logger LOG = LoggerFactory.getLogger(NacosClientService.class);

    private final DiscoveryClient discoveryClient;

    public NacosClientService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    /**
     * <h2>打印 Nacos Client 信息到日志中</h2>
     * @param serviceId 服务ID
     * @return ServiceInstance的list
     */
    public List<ServiceInstance> getNacosClientInfo(String serviceId){

        LOG.info("request cacos client to get service instance info: [{}]", serviceId);
        return discoveryClient.getInstances(serviceId);
    }
}
