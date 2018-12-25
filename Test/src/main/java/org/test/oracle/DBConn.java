/*
 * 文 件 名:  DBConn.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/12/19
 */
package org.test.oracle;

import java.sql.Connection;
import java.sql.DriverManager;

import org.test.utils.PropertyUtils;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/12/19 10:19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DBConn {
    // 获取数据库连接方法, 返回Connection对象
    private Connection conn = null;
    
    public Connection getConn() {
        PropertyUtils propertyUtils = PropertyUtils.getInstance();
        // 数据库驱动类
        String dbDriver = propertyUtils.getValue("jdbc.oracle.driver");
        // 连接数据库url
        String dbURL = propertyUtils.getValue("jdbc.oracle.url");
        // 连接数据库用户名
        String dbUser = propertyUtils.getValue("jdbc.oracle.username");
        // 连接数据库密码
        String dbPwd = propertyUtils.getValue("jdbc.oracle.password");
        
        try {
            // 加载数据库驱动
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    
    public void closeConn() {
        try {
            if (null != conn) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
