package com.yue.yojbackendjudgeservice.MQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于创建测试程序用到的交换机和队列（只用在程序启动前执行一次）
 * @author Yuuue
 * creat by 2023-10-06
 */
@Slf4j
public class InitRabbitMq {

    public static void initDoJudge(){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String EXCHANGE_NAME= "code_exchange";
            channel.exchangeDeclare(EXCHANGE_NAME,"direct");

            //创建队列
            String queueName = "code_name";
            channel.queueDeclare(queueName,true,false,false,null);
            channel.queueBind(queueName,EXCHANGE_NAME,"my_routingKey");
            log.info("消息队列启动成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        initDoJudge();

    }
}
