/*
 * 文 件 名:  User.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/02 14:40
 */
package com.ztesoft.brain.simple.businessdomain;

import lombok.Data;

/**
 * 用户领域对象
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/02 14:40]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Data
public class UserVO {
    private String id;
    
    private String name;
}
