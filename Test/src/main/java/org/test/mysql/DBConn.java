/*
 * 文 件 名:  DBConn.java
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/06 13:53
 */
package org.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.test.utils.PropertyUtils;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/11/06 13:53]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DBConn {
    private static DBConn instance = new DBConn();
    
    private static Connection conn = null;
    
    private DBConn() {
    }
    
    private static void initDBConn() {
        PropertyUtils propertyUtils = PropertyUtils.getInstance();
        // 数据库驱动类
        String dbDriver = propertyUtils.getValue("jdbc.mysql.driver");
        // 连接数据库url
        String dbURL = propertyUtils.getValue("jdbc.mysql.url");
        // 连接数据库用户名
        String dbUser = propertyUtils.getValue("jdbc.mysql.username");
        // 连接数据库密码
        String dbPwd = propertyUtils.getValue("jdbc.mysql.password");
        
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
        }
        // 捕获加载驱动程序异常
        catch (ClassNotFoundException cnfex) {
            System.err.println("装载 JDBC/ODBC 驱动程序失败。");
            cnfex.printStackTrace();
        }
        // 捕获连接数据库异常
        catch (SQLException sqlex) {
            System.err.println("无法连接数据库");
            sqlex.printStackTrace();
        }
    }
    
    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static DBConn getInstance() {
        if (conn == null) {
            initDBConn();
        }
        return instance;
    }
    
    public Connection getConn() {
        return conn;
    }
}
