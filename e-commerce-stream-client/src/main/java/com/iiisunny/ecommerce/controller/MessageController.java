package com.iiisunny.ecommerce.controller;

import com.iiisunny.ecommerce.stream.DefaultSendService;
import com.iiisunny.ecommerce.stream.iiisunny.IiisunnySendService;
import com.iiisunny.ecommerce.vo.IiisunnyMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * <h1>构建消息驱动</h1>
 * */

@RestController
@RequestMapping("/message")
public class MessageController {

    private final DefaultSendService defaultSendService;

    private final IiisunnySendService iiisunnySendService;

    public MessageController(DefaultSendService defaultSendService,
                             IiisunnySendService iiisunnySendService) {
        this.defaultSendService = defaultSendService;
        this.iiisunnySendService = iiisunnySendService;
    }

    /**
     * <h2>默认信道</h2>
     * */
    @GetMapping("/default")
    public void defaultSend() {
        defaultSendService.sendMessage(IiisunnyMessage.defaultMessage());
    }

    /**
     * <h2>自定义信道</h2>
     * */
    @GetMapping("/iiisunny")
    public void qinyiSend() {
        iiisunnySendService.sendMessage(IiisunnyMessage.defaultMessage());
    }
}
