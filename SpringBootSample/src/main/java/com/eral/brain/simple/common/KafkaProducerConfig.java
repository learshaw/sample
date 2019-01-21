/*
 * 文 件 名:  KafkaProducerConfig.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/18
 */
package com.eral.brain.simple.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2019/01/18 14:20]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
@EnableKafka
public class KafkaProducerConfig {
    @Value("${kafka.producer.servers}")
    private String servers;
    
    @Value("${kafka.producer.retries}")
    private int retries;
    
    @Value("${kafka.producer.batch.size}")
    private int batchSize;
    
    @Value("${kafka.producer.linger}")
    private int linger;
    
    @Value("${kafka.producer.buffer.memory}")
    private int bufferMemory;
    
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }
    
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }
    
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        props.put(ProducerConfig.LINGER_MS_CONFIG, linger);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }
}
