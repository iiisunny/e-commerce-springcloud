package com.iiisunny.ecommerce.stream.iiisunny;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * <h1>自定义输入信道</h1>
 * */
public interface IiisunnySink {

    String INPUT = "iiisunnyInput";

    /** 输入信道的名称是 iiisunnyInput, 需要使用 Stream 绑定器在 yml 文件中配置*/
    @Input(IiisunnySink.INPUT)
    SubscribableChannel iiisunnyInput();
}
