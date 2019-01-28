/*
 * 文 件 名:  SinkReceiverInter.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/22
 */
package com.eral.brain.simple.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * Kafka消费者定义接口
 * 
 * @author LvWenbin
 * @version [版本号, 2019/01/22 16:29]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public interface SinkReceiverInter {
    String INPUT = "input";
    
    String INPUT2 = "input2";
    
    @Input(INPUT)
    SubscribableChannel input();
    
    @Input(INPUT2)
    SubscribableChannel input2();
}