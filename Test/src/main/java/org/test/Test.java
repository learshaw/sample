/*
 * 文 件 名:  Test.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/08 18:17
 */
package org.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.test.oracle.DBConn;
import org.test.utils.ExcelUtil;
import org.test.utils.PropertyUtils;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/08 18:17]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Test {
    public static void main(String[] args) {
        String path = PropertyUtils.getInstance().getValue("sys.excel.ipath");
        System.out.println("####加载文件:" + path);
        HSSFWorkbook hssfWorkbook = ExcelUtil.readXls(path);
        System.out.println("####读取Excel:" + hssfWorkbook);
        HSSFSheet sheet = ExcelUtil.getSheet(hssfWorkbook, "Sheet1");
        System.out.println("####读取Sheet:" + sheet);
        int row = sheet.getLastRowNum();
        System.out.println("####有效行数:" + (row + 1));
        
        if (row > 0) {
            DBConn dbConn = new DBConn();
            Connection conn = dbConn.getConn();
            
            HSSFWorkbook ohssfWorkbook = new HSSFWorkbook();
            HSSFSheet mzsheet = ExcelUtil.getSheet(ohssfWorkbook, "mz");
            HSSFSheet zysheet = ExcelUtil.getSheet(ohssfWorkbook, "zy");
            int mzCount = 0;
            int zyCount = 0;
            
            for (int i=1; i <= row; i++) {
                // 病例号
                String patientId = ExcelUtil.getSheetCellValue(sheet, i, 0);
                // 教学日期
                String date = ExcelUtil.getSheetCellValue(sheet, i, 1);
                // 检查类型
                String checkType = ExcelUtil.getSheetCellValue(sheet, i, 2);
                
                String[] ret = query(conn, patientId);

                if (null != ret) {
                    String diagnosekind = ret[5];
                    
                    if (StringUtils.equals(diagnosekind, "1") || StringUtils.equals(diagnosekind, "2") || StringUtils.equals(diagnosekind, "3")) {
                        ExcelUtil.setSheetCellValue(mzsheet, mzCount, 0, patientId);
                        ExcelUtil.setSheetCellValue(mzsheet, mzCount, 1, convertDate(date));
                        ExcelUtil.setSheetCellValue(mzsheet, mzCount, 2, checkType);
                        ExcelUtil.setSheetCellValue(mzsheet, mzCount, 3, ret[1]);
                        ExcelUtil.setSheetCellValue(mzsheet, mzCount, 4, ret[2]);
                        ExcelUtil.setSheetCellValue(mzsheet, mzCount, 5, convertZB(ret[5]));
                        System.out.println("mz item +1 id:" + patientId);
                        mzCount++;
                    } else if (StringUtils.equals(diagnosekind, "4")) {
                        ExcelUtil.setSheetCellValue(zysheet, zyCount, 0, patientId);
                        ExcelUtil.setSheetCellValue(zysheet, zyCount, 1, convertDate(date));
                        ExcelUtil.setSheetCellValue(zysheet, zyCount, 2, checkType);
                        ExcelUtil.setSheetCellValue(zysheet, zyCount, 3, ret[1]);
                        ExcelUtil.setSheetCellValue(zysheet, zyCount, 4, ret[2]);
                        ExcelUtil.setSheetCellValue(zysheet, zyCount, 5, convertZB(ret[5]));
                        System.out.println("zy item +1 id:" + patientId);
                        zyCount++;
                    }
                }
            }
            
            String opath = PropertyUtils.getInstance().getValue("sys.excel.opath");
            ExcelUtil.writeXls(ohssfWorkbook, opath);
            
            dbConn.closeConn();
        }
    }
    
    private static String convertDate(String date) {
        String[] tmp = StringUtils.split(date, "-");
        tmp[1] = String.format("%02d", Integer.parseInt(tmp[1]));
        tmp[2] = String.format("%02d", Integer.parseInt(tmp[2]));
        
        return StringUtils.join(tmp, "-");
    }

    private static String convertZB(String diagnosekind) {
        String ret = null;
        
        if (StringUtils.equals(diagnosekind, "1")) {
            ret = "门诊";
        } else if (StringUtils.equals(diagnosekind, "2")) {
            ret = "急诊";
        } else if (StringUtils.equals(diagnosekind, "3")) {
            ret = "体检";
        } else if (StringUtils.equals(diagnosekind, "4")) {
            ret = "住院";
        }
        
        return ret;
    }

    public static String[] query(Connection conn, String patientId) {
        String[] ret = null;
        
        // 创建表的sql语句
        String sql = "select t.patientid,t.patientname,t.age,t.modtype,t.exedt,t.diagnosekind from RISSTUDIES t where t.patientid=? and t.modtype in ('CT','DR','MR','MG','RF','CR')";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patientId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                ret = new String[6];
                ret[0] = rs.getString(1);
                ret[1] = rs.getString(2);
                ret[2] = rs.getString(3);
                ret[3] = rs.getString(4);
                ret[4] = rs.getString(5);
                ret[5] = rs.getString(6);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ret;
    }
}
