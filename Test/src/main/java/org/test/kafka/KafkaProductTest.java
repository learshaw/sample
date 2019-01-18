/*
 * 文 件 名:  KafkaTest.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/18
 */
package org.test.kafka;

import java.lang.Thread;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Kafka生产者测试
 * 
 * @author LvWenbin
 * @version [版本号, 2019/01/18 09:35]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class KafkaProductTest {
    /**
     * <一句话功能简述> <功能详细描述>
     * 
     * @param args
     * @throws InterruptedException 
     * @see [类、类#方法、类#成员]
     */
    public static void main(String[] args) throws InterruptedException {
        ProductThread thread = new ProductThread();
        thread.start();
    }
}

class ProductThread extends Thread{
    @Override
    public void run() {
        Producer<String, String> producer = KafkaUtils.getProducer();
        int i = 0;
        while (true) {
            ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("test", String.valueOf(i), "this is message" + i);
            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e != null)
                        e.printStackTrace();
                    System.out.println(
                        "message send to partition " + metadata.partition() + ", offset: " + metadata.offset());
                }
            });
            i++;
            sleep();
        }
    }
    
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
