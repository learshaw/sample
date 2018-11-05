/*
 * 文 件 名:  UserMapper.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/05 14:27
 */
package com.ztesoft.brain.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ztesoft.brain.simple.podomain.User;

/**
 * $用户匹配
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/05 14:27]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface UserMapper {
    /**
     * $增
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    void insert(User user);
    
    /**
     * $删
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    void delete(@Param(value = "id")String id);
    
    /**
     * $改
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    void update(User user);
    
    /**
     * $查
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    User select(@Param(value = "id")String id);
    
    /**
     * $查列表
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<User> selectAll();
}
