package com.yue.yojbackendjudgeservice;

import com.yue.yojbackendjudgeservice.MQ.InitRabbitMq;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.yue.yojbackendquestionservice.mapper")
//@EnableScheduling
@ComponentScan("com.yue")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.yue.yojbackendserviceclient.service")
public class YojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        InitRabbitMq.initDoJudge();
        SpringApplication.run(YojBackendJudgeServiceApplication.class, args);
    }

}
