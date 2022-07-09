package com.iiisunny.ecommerce.controller;

import com.iiisunny.ecommerce.service.SleuthTraceInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>打印跟踪信息</h1>
 */
@RestController
@RequestMapping("/sleuth")
public class SleuthTraceInfoController {

    private static final Logger LOG = LoggerFactory.getLogger(SleuthTraceInfoController.class);

    private final SleuthTraceInfoService sleuthTraceInfoService;

    public SleuthTraceInfoController(SleuthTraceInfoService sleuthTraceInfoService) {
        this.sleuthTraceInfoService = sleuthTraceInfoService;
    }

    /**
     * <h2>打印日志跟踪信息</h2>
     */
    @GetMapping("/trace-info")
    public void logCurrentTraceInfo() {
        sleuthTraceInfoService.logCurrentTraceInfo();
    }
}
