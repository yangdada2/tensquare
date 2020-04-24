package com.tensquare.sms.listen;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author haoyang
 * @Classname SmsListenner
 * @Description 短信发送服务监听类
 * @Date 2020/4/15 0015 17:19
 * @Created by Administrator
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Value("${aliyun.sms.template_code}")
    private String templateCode;//模板编号

    @Value("${aliyun.sms.sign_name}")
    private String signName;//签名

    @Autowired
    SmsUtil smsUtil;

    /**
     * 发送短信
     * @param
     */
    @RabbitHandler
    public void sendSms(Map<String,String> message){
        System.out.println("手机号 : " + message.get("mobile"));
        System.out.println("验证码 : " + message.get("code"));
        try {
            smsUtil.sendSms(message.get("mobile"),templateCode,signName,"{\"code\":"+ message.get("code") +"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


}
