package com.tensquare.rabibtmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author haoyang
 * @Classname Customer1
 * @Description 消息消费者
 * @Date 2020/4/15 0015 15:51
 * @Created by Administrator
 */
@Component
@RabbitListener(queues = "itcast")
public class Customer1 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itcast接收到的消息为: " + message);
    }
}
