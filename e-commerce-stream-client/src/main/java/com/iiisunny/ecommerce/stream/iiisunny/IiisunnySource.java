package com.iiisunny.ecommerce.stream.iiisunny;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * <h1>自定义输出信道</h1>
 * */
public interface IiisunnySource {

    String OUTPUT = "iiisunnyOutput";

    /** 输出信道的名称是 iiisunnyOutput, 需要使用 Stream 绑定器在 yml 文件中声明 */
    @Output(IiisunnySource.OUTPUT)
    MessageChannel qinyiOutput();
}
