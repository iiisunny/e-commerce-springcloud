package com.iiisunny.ecommerce.service;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

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

        LOG.info("request ncacos client to get service instance info: [{}]", serviceId);
        return discoveryClient.getInstances(serviceId);
    }

    /**
     * <h2>提供给编程方式的 Hystrix 请求合并</h2>
     */
    public List<List<ServiceInstance>> getNacosClientInfos(List<String> serviceIds){

        LOG.info("request ncacos client to get service instance infos: [{}]", serviceIds);
        List<List<ServiceInstance>> result = new ArrayList<>(serviceIds.size());

        serviceIds.forEach(s -> result.add(discoveryClient.getInstances(s)));

        return result;
    }

    /**
     * <h2>使用注解实现 Hystrix 请求合并</h2>
     */
    @HystrixCollapser(
            batchMethod = "findNacosClientInfos",
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            collapserProperties = {
                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "300")
            }
    )
    public Future<List<ServiceInstance>> findNacosClientInfo(String serviceId) {

        // 系统运行正常, 不会走这个方法
        throw new RuntimeException("This method body should not be executed!");
    }

    @HystrixCommand
    public List<List<ServiceInstance>> findNacosClientInfos(List<String> serviceIds) {

        LOG.info("coming in find nacos client infos: [{}]", JSON.toJSONString(serviceIds));
        return getNacosClientInfos(serviceIds);
    }
}
