/*
 * 文 件 名:  KafkaConsumerTest.java
 * 版    权: 
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/18
 */
package org.test.kafka;

import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * Kafka消费者测试
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2019/01/18 10:29]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class KafkaConsumerTest {
    public static void main(String[] args) {
        ConsumerThread thread = new ConsumerThread();
        thread.start();
    }
}

class ConsumerThread extends Thread{
    @Override
    public void run() {
        KafkaConsumer<String, String> consumer = KafkaUtils.getConsumer();
        consumer.subscribe(Arrays.asList("test"));
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for(ConsumerRecord<String, String> record : records) {
                System.out.println("fetched from partition " + record.partition() + ", offset: " + record.offset() + ", message: " + record.value());
            }
        }
    }
}
