/*
 * 文 件 名:  KafkaListener.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/18
 */
package com.ztesoft.brain.simple.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2019/01/18 15:52]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class KafkaSub {
    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("##kafka的key: " + record.key());
        System.out.println("kafka的value: " + record.value().toString());
    }
}
