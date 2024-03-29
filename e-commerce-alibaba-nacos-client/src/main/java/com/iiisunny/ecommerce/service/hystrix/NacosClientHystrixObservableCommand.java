package com.iiisunny.ecommerce.service.hystrix;

import com.alibaba.fastjson.JSON;
import com.iiisunny.ecommerce.service.NacosClientService;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import rx.Observable;
import rx.Subscriber;

import java.util.Collections;
import java.util.List;

/**
 * <h1>HystrixCommand, 隔离策略是基于信号量实现的</h1>
 * */
public class NacosClientHystrixObservableCommand
        extends HystrixObservableCommand<List<ServiceInstance>> {

    private static final Logger LOG = LoggerFactory.getLogger(NacosClientHystrixObservableCommand.class);

    /** 要保护的服务 */
    private final NacosClientService nacosClientService;

    /** 方法需要传递的参数 */
    private final List<String> serviceIds;

    public NacosClientHystrixObservableCommand(NacosClientService nacosClientService,
                                               List<String> serviceIds) {
        super(
                Setter
                        .withGroupKey(HystrixCommandGroupKey
                                .Factory.asKey("NacosClientService"))
                        .andCommandKey(HystrixCommandKey
                                .Factory.asKey("NacosClientHystrixObservableCommand"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                        .withFallbackEnabled(true)          // 开启降级
                        .withCircuitBreakerEnabled(true)    // 开启熔断器
                )
        );

        this.nacosClientService = nacosClientService;
        this.serviceIds = serviceIds;
    }

    /**
     * <h2>要保护的方法调用写在这里</h2>
     * */
    @Override
    protected Observable<List<ServiceInstance>> construct() {

        return Observable.create(new Observable.OnSubscribe<List<ServiceInstance>>() {
            // Observable 有三个关键的事件方法, 分别是 onNext、onCompleted、onError
            @Override
            public void call(Subscriber<? super List<ServiceInstance>> subscriber) {

                try {
                    if (!subscriber.isUnsubscribed()) {
                        LOG.info("subscriber command task: [{}], [{}]",
                                JSON.toJSONString(serviceIds),
                                Thread.currentThread().getName());
                        serviceIds.forEach(
                                s -> subscriber
                                        .onNext(nacosClientService.getNacosClientInfo(s))
                        );
                        subscriber.onCompleted();
                        LOG.info("command task completed: [{}], [{}]",
                                JSON.toJSONString(serviceIds),
                                Thread.currentThread().getName());
                    }
                } catch (Exception ex) {
                    subscriber.onError(ex);
                }
            }
        });
    }

    /**
     * <h2>服务降级</h2>
     * */
    @Override
    protected Observable<List<ServiceInstance>> resumeWithFallback() {

        return Observable.create(new Observable.OnSubscribe<List<ServiceInstance>>() {
            @Override
            public void call(Subscriber<? super List<ServiceInstance>> subscriber) {

                try {
                    if (!subscriber.isUnsubscribed()) {
                        LOG.info("(fallback) subscriber command task: [{}], [{}]",
                                JSON.toJSONString(serviceIds),
                                Thread.currentThread().getName());
                        subscriber.onNext(Collections.emptyList());
                        subscriber.onCompleted();
                        LOG.info("(fallback) command task completed: [{}], [{}]",
                                JSON.toJSONString(serviceIds),
                                Thread.currentThread().getName());
                    }
                } catch (Exception ex) {
                    subscriber.onError(ex);
                }
            }
        });
    }
}
