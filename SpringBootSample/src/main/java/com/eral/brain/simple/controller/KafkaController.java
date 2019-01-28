/*
 * 文 件 名:  KafkaController.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2019/01/22
 */
package com.eral.brain.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eral.brain.simple.kafka.SinkSender;
import com.eral.brain.simple.kafka.SinkSender2;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2019/01/22 16:37]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping(value="/kafka")
public class KafkaController {
    @Autowired
    private SinkSender sinkSender;
    
    @Autowired
    private SinkSender2 sinkSender2;
    
    @RequestMapping(path="/send", method = RequestMethod.GET)
    public String send(@RequestParam(name = "name") String name, @RequestParam(name = "msg") String msg) {
        sinkSender.sendmessage(name, msg);
        return "success";
    }
    
    @RequestMapping(path="/send2", method = RequestMethod.GET)
    public String send1(@RequestParam(name = "msg") String msg) {
        sinkSender2.sendmessage2(msg);
        return "success";
    }
}
