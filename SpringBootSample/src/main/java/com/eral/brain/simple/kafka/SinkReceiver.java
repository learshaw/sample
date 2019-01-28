/*
 * 文 件 名:  SinkReceiver.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/22
 */
package com.eral.brain.simple.kafka;

import java.util.Date;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Kafka消费者业务处理类
 * 
 * @author LvWenbin
 * @version [版本号, 2019/01/22 16:30]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@EnableBinding(value = {SinkReceiverInter.class})
public class SinkReceiver {
    @StreamListener(SinkReceiverInter.INPUT)
    public void receiver(Person payload) {
        System.out.println("时间：" + new Date() + "接收到消息：" + payload.getMessage() + payload.getName());
    }
}