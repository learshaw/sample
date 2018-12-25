/*
 * 文 件 名:  TestQuery.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/12/19
 */
package org.test.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/12/19 10:26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestQuery {
    public static void main(String[] args) {
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.getConn();
        search(conn);
        dbConn.closeConn();
    }
    
    // 查询
    public static void search(Connection conn) {
        // 创建表的sql语句
        String sql = "SELECT * FROM AA_TEST";
        
        try {
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String stuname = rs.getString(2);
                String stusex = rs.getString(3);
                System.out.println(id + "," + stuname + "," + stusex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
