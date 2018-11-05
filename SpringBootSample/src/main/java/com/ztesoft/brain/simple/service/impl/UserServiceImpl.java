/*
 * 文 件 名:  UserServiceImpl.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/05 14:49
 */
package com.ztesoft.brain.simple.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.brain.simple.businessdomain.UserVO;
import com.ztesoft.brain.simple.mapper.UserMapper;
import com.ztesoft.brain.simple.podomain.User;
import com.ztesoft.brain.simple.service.UserService;

/**
 * $接口实现
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/05 14:49]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public void save(UserVO userVO) {
        User user = new User();
        user.setId(userVO.getId());
        user.setName(userVO.getName());
        userMapper.insert(user);
    }

    @Override
    public void remove(String id) {
        userMapper.delete(id);
    }

    @Override
    public void update(UserVO userVO) {
        User user = new User();
        user.setId(userVO.getId());
        user.setName(userVO.getName());
        userMapper.update(user);
    }

    @Override
    public UserVO get(String id) {
        User user = userMapper.select(id);
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setName(user.getName());
        return userVO;
    }

    @Override
    public List<UserVO> getAll() {
        List<User> users = userMapper.selectAll();
        List<UserVO> retList = new ArrayList<>();
        
        if (null != users && users.size() > 0) {
            for (User user : users) {
                UserVO userVO = new UserVO();
                userVO.setId(user.getId());
                userVO.setName(user.getName());
                retList.add(userVO);
            }
        }
        
        return retList;
    }
}
