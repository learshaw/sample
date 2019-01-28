/*
 * 文 件 名:  SinkReceiver2.java
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
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2019/01/22 16:31]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */

@EnableBinding(value = {SinkReceiverInter.class})
public class SinkReceiver2 {
    @StreamListener(SinkReceiverInter.INPUT2)
    public void receiver(Object payload){
        System.out.println("时间："+new Date()+"接收到消息：" + payload.toString());
    }
}