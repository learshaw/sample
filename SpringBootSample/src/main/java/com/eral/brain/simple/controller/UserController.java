/*
 * 文 件 名:  UserController.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/05 15:07
 */
package com.eral.brain.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.earl.brain.simple.businessdomain.UserVO;
import com.ztesoft.brain.simple.service.UserService;

/**
 * $用户服务
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/05 15:07]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody UserVO user) {
        userService.save(user);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestParam(name = "id") String id) {
        userService.remove(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody UserVO user) {
        userService.update(user);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public UserVO get(@RequestParam(name = "id") String id) {
        return userService.get(id);
    }
    
    @RequestMapping(value="/getall", method = RequestMethod.GET)
    public List<UserVO> getAll() {
        return userService.getAll();
    }
}
