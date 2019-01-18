/*
 * 文 件 名:  KafkaUtils.java
 * 版    权: 
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/18
 */
package org.test.kafka;

import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2019/01/18 09:32]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class KafkaUtils {
    /**
     * 生产者
     */
    private static KafkaProducer<String, String> kp;
    
    /**
     * 消费者
     */
    private static KafkaConsumer<String, String> kc;

    public static KafkaProducer<String, String> getProducer() {
        if (kp == null) {
            Properties props = new Properties();
            props.put("bootstrap.servers", "192.168.206.129:9092,192.168.206.129:9093,192.168.206.129:9094");
            props.put("acks", "1");
            props.put("retries", 0);
            props.put("batch.size", 16384);
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            kp = new KafkaProducer<String, String>(props);
        }
        return kp;
    }
    
    public static KafkaConsumer<String, String> getConsumer() {
        if(kc == null) {
            Properties props = new Properties();
            props.put("bootstrap.servers", "192.168.206.129:9092,192.168.206.129:9093,192.168.206.129:9094");
            props.put("group.id", "1");
            props.put("enable.auto.commit", "true");
            props.put("auto.commit.interval.ms", "1000");
            props.put("session.timeout.ms", "30000");
            props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            kc = new KafkaConsumer<String, String>(props);
        }
        return kc;
    }
}
