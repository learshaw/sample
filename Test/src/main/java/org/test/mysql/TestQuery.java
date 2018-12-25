/*
 * 文 件 名:  TestQuery.java
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/06 13:59
 */
package org.test.mysql;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/11/06 13:59]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestQuery {
    public static void main(String[] args) {
        TestQuery exec = new TestQuery();
        Connection conn = DBConn.getInstance().getConn();
        exec.select(conn);
    }
    
    public void select(Connection conn) {
        String sql = "select t.* from adm_eh_amap_jam_event t"; // 查询usrInfo表中的信息
        String sql2 = "select t.* from adm_eh_amap_jam_event_detail t where t.event_id=? order by xy";
        File file = new File("e:\\data.txt");
        
        try {
            Statement stmt = (Statement)conn.createStatement();
            ResultSet rs = (ResultSet)stmt.executeQuery(sql); // 得到的是结果的集合
          
            while (rs.next()) {
                String eventId = rs.getString("event_id");
                
                PreparedStatement stmt2 = conn.prepareStatement(sql2);   
                stmt2.setString(1, eventId);
                ResultSet rs2 = (ResultSet)stmt2.executeQuery();
                String data = "eventId:" + eventId + "\n";
                FileUtils.writeStringToFile(file, data, "UTF-8", true);
                
                while (rs2.next()) {
                    String roadName = rs2.getString("road_name");
                    String time = rs2.getString("create_time");
                    String xy = rs2.getString("xy");
                    String linkId = rs2.getString("link_id");
                    data = "  detail|- linkId:" + linkId + ", time:" + time+ ", xy:" + xy + ", roadName:" + roadName + "\n";
                    FileUtils.writeStringToFile(file, data, "UTF-8", true);
                }
                
                stmt2.close();
            }
            
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
