/*
 * 文 件 名:  IndexController.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/01 16:57
 */
package com.eral.brain.simple.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earl.brain.simple.businessdomain.UserVO;


/**
 * Web接口样板 <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/11/01 16:57]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class IndexController {
    @GetMapping("/index")
    public ResponseEntity<String> helloWord() {
        return ResponseEntity.ok("hello word");
    }
    
    @RequestMapping("/getUser")
    public UserVO getUser() {
        UserVO user = new UserVO();
        user.setId("1111");
        user.setName("喵");
        return user;
    }
}
