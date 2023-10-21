package com.yue.yojbackendquestionservice.MQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 生产者
 * @author Yuuue
 * creat by 2023-10-06
 */
@Component
public class MqProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String exchange,String routinkey,String message){
        rabbitTemplate.convertAndSend(exchange,routinkey,message);
    }
}
