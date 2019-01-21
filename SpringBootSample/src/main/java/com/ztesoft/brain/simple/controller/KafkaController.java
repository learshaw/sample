/*
 * 文 件 名:  KafkaController.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/18
 */
package com.ztesoft.brain.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2019/01/18 14:33]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send(@RequestParam(name = "topic") String topic, 
        @RequestParam(name = "key") String key,
        @RequestParam(name = "msg") String message) {
        try {
            kafkaTemplate.send(topic, key, message);
            return "发送kafka成功";
        } catch (Exception e) {
            return "发送kafka失败" + e.getMessage();
        }
    }
}
