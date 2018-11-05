/*
 * 文 件 名:  UserService.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/05 14:42
 */
package com.ztesoft.brain.simple.service;

import java.util.List;

import com.ztesoft.brain.simple.businessdomain.UserVO;

/**
 * $业务操作接口
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/05 14:42]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface UserService {
    /**
     * $保存
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    void save(UserVO userVO);
    
    /**
     * $删除
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    void remove(String id);
    
    /**
     * $修改
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    void update(UserVO userVO);
    
    /**
     * $查询
     * <功能详细描述>
     * @param id
     * @see [类、类#方法、类#成员]
     */
    UserVO get(String id);
    
    /**
     * $查询所有
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    List<UserVO> getAll();
}
