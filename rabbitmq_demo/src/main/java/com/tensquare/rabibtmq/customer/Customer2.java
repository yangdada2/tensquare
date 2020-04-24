package com.tensquare.rabibtmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author haoyang
 * @Classname Customer2
 * @Description  分列模式测试
 * @Date 2020/4/15 0015 16:19
 * @Created by Administrator
 */
@Component
@RabbitListener(queues = "yangdada")
public class Customer2 {


    @RabbitHandler
    public void testFanout(String message) {
        System.out.println("yangdada队列接收到的消息为 : " + message);
    }
}
