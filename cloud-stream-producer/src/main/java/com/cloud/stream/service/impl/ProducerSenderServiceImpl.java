package com.cloud.stream.service.impl;

import com.cloud.stream.service.ProducerSenderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Component
@EnableBinding(Source.class)
public class ProducerSenderServiceImpl implements ProducerSenderService {

    @Autowired//定义消息发送管道，名字只能叫output
    private MessageChannel output;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() throws UnsupportedEncodingException {
        String uuid = UUID.randomUUID().toString();
        //核心代码：构建一个消息类型，然后使用发送管道发送出去
//        output.send(MessageBuilder.withPayload(uuid).build());

////        rabbitTemplate.send(new Message());
////        MessageProperties messageProperties = new MessageProperties();
////        messageProperties.getHeaders().put("type", "小鸡");
////        messageProperties.getHeaders().put("name", "jim");
//
////        String content = "测试消息111";
////        Message message = new Message(content.getBytes("UTF-8"), messageProperties);
////        rabbitTemplate.send(message);
        rabbitTemplate.convertAndSend("mydestination","",uuid);
        System.out.println("send:" + uuid);
    }
}
