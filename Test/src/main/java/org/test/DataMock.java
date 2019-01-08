/*
 * 文 件 名:  DataMock.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/12/26
 */
package org.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.test.mysql.DBConn;

import lombok.Data;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/12/26 17:36]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DataMock {
    public static void main(String[] args) {
        Connection conn = DBConn.getInstance().getConn();
        // 违法代码
        List<CodeWfdm> wfdmList = selectVioCodewfdm(conn);
        // 车辆信息
        List<Vehicle> vehicleList = selectVehicle(conn);
        
        // 生成违法数据
        List<Violation> violationList = buildViolation(wfdmList, vehicleList);
        
        // 保存违法记录
        saveViolation(violationList, conn);
        
        System.out.println(wfdmList.size());
        System.out.println(vehicleList.size());
    }
    
    private static List<Violation> buildViolation(List<CodeWfdm> wfdmList, List<Vehicle> vehicleList) {
        // TODO 生成违法记录
        // ......
        return null;
    }
    
    public static List<CodeWfdm> selectVioCodewfdm(Connection conn) {
        List<CodeWfdm> retList = new ArrayList<CodeWfdm>();
        String sql = "select t.* from vio_codewfdm t"; // 查询违法代码表中的信息
        
        try {
            Statement stmt = (Statement)conn.createStatement();
            ResultSet rs = (ResultSet)stmt.executeQuery(sql); // 得到的是结果的集合
            
            while (rs.next()) {
                String wfxw = rs.getString("wfxw");
                String wfnr = rs.getString("wfnr");
                
                CodeWfdm wfdm = new CodeWfdm();
                wfdm.setWfxw(wfxw);
                wfdm.setWfnr(wfnr);
                retList.add(wfdm);
            }
            
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return retList;
    }
    
    public static List<Vehicle> selectVehicle(Connection conn) {
        List<Vehicle> retList = new ArrayList<Vehicle>();
        String sql = "select t.* from vehicle t"; // 查询车辆表中的信息
        
        try {
            Statement stmt = (Statement)conn.createStatement();
            ResultSet rs = (ResultSet)stmt.executeQuery(sql); // 得到的是结果的集合
            
            while (rs.next()) {
                String hpzl = rs.getString("hpzl");
                String hphm = rs.getString("hphm");
                
                Vehicle vehicle = new Vehicle();
                vehicle.setHpzl(hpzl);
                vehicle.setHphm(hphm);
                retList.add(vehicle);
            }
            
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return retList;
    }
    
    private static void saveViolation(List<Violation> violationList, Connection conn) {
        if (CollectionUtils.isEmpty(violationList)) {
            return;
        }
        
        String sql =
            "INSERT INTO `traffic_analysis`.`vio_violation` (`wfbh`, `jdslb`, `jdsbh`, `wsjyw`, `ryfl`, `jszh`, `dabh`, `fzjg`, `zjcx`, `dsr`, `zsxzqh`, `zsxxdz`, `dh`, `lxfs`, `clfl`, `hpzl`, `hphm`, `jdcsyr`, `syxz`, `jtfs`, `wfsj`, `xzqh`, `dllx`, `glxzdj`, `wfdd`, `lddm`, `ddms`, `ddjdwz`, `wfdz`, `wfxw`, `wfjfs`, `fkje`, `scz`, `bzz`, `znj`, `zqmj`, `jkfs`, `fxjg`, `fxjgmc`, `cljg`, `cljgmc`, `cfzl`, `clsj`, `jkbj`, `jkrq`, `pzbh`, `jsjqbj`, `jllx`, `lrr`, `lrsj`, `jbr1`, `jbr2`, `sgdj`, `cldxbj`, `jdccldxbj`, `zdjlbj`, `xxly`, `xrms`, `dkbj`, `jmznjbj`, `zdbj`, `jsjg`, `fsjg`, `gxsj`, `bz`, `ywjyw`, `zjmc`, `cclzrq`, `nl`, `xb`, `hcbj`, `jd`, `wd`, `ylzz1`, `ylzz2`, `ylzz3`, `ylzz4`, `ylzz5`, `ylzz6`, `ylzz7`, `ylzz8`, `cjfs`, `wfsj1`, `wfdd1`, `lddm1`, `ddms1`, `jsrxz`, `clyt`, `xcfw`, `dzzb`, `sfzdry`, `xysfzmhm`, `xyxm`, `ylzz11`, `ylzz12`, `ylzz13`, `ylzz14`, `ylzz15`, `ylzz16`, `ylzz17`, `ylzz18`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            for (Violation violation : violationList) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, violation.getWfbh());
                stmt.setString(2, violation.getJdslb());
                // stmt.setString(3, violation.getJdsbh());
                // ....
                
                boolean flag = stmt.execute();
                System.out.println(flag);
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Data
class CodeWfdm {
    private String wfxw;
    
    private String wfnr;
}

@Data
class Vehicle {
    private String hpzl;
    
    private String hphm;
}

@Data
class Violation {
    private String wfbh;
    
    private String jdslb;
    // ......
}
