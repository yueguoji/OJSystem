package com.yue.yojbackendjudgeservice.MQ;

import com.rabbitmq.client.Channel;
import com.yue.yojbackendjudgeservice.judge.JudgeService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * MQ消费者
 * @author Yuuue
 * creat by 2023-10-06
 */
@Component
@Slf4j
public class MqConsumer {

    @Resource
    private JudgeService judgeService;

    @SneakyThrows
    @RabbitListener(queues = {"code_queue"},ackMode = "MANUAL")
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_MODE) long deliveryTag){
        //消费者获取消息队列中的题目Id
         log.info(("接受信息"));
         try {
             //正常运行
             long questionSubmitId = Long.parseLong(message);
             judgeService.doJudge(questionSubmitId);
             channel.basicAck(deliveryTag,false);
         }catch (Exception e){
             //消费消息失败
             channel.basicNack(deliveryTag,false,false);
         }





    }
}
