/*
 * 文 件 名:  SinkSenderInter.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/22
 */
package com.eral.brain.simple.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Kafka生产者定义
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2019/01/22 16:21]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Component
public interface SinkSenderInter {
    String OUTPUT="output";
    String OUTPUT2="output2";
 
    @Output(OUTPUT)   // 在这里设置输出通道，配置在application.yml里
    MessageChannel output();
 
    @Output(OUTPUT2)
    MessageChannel output2();
}
