/*
 * 文 件 名:  SinkSender2.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/22
 */
package com.eral.brain.simple.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

/**
 * Kafka生产者业务实现
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2019/01/22 16:26]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@EnableBinding(value = {SinkSenderInter.class})
public class SinkSender2 {
    @Autowired
    private SinkSenderInter sinkSenderInter;
 
    public void sendmessage2(String msg){
        sinkSenderInter.output2().send(MessageBuilder.withPayload(msg).build());
    }
}
