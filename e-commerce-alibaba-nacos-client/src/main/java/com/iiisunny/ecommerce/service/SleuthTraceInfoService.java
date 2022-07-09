package com.iiisunny.ecommerce.service;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <h1>使用代码更直观看到 Sletuh 生成的相关跟踪信息</h1>
 */
@Service
public class SleuthTraceInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(SleuthTraceInfoService.class);

    /** brave.Tracer 跟踪对象 */
    private final Tracer tracer;

    public SleuthTraceInfoService(Tracer tracer) {
        this.tracer = tracer;
    }

    /**
     * <h2>打印当前的跟踪信息到日志中</h2>
     */
    public void logCurrentTraceInfo() {

        LOG.info("Sleuth trace id: [{}]", tracer.currentSpan().context().traceId());
        LOG.info("Sleuth span id: [{}]", tracer.currentSpan().context().spanId());
    }
}
