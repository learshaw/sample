/*
 * 文 件 名:  Test2.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/12/20
 */
package org.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.test.utils.ExcelUtil;
import org.test.utils.PropertyUtils;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/12/20 09:16]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Test2 {
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
            HSSFWorkbook ohssfWorkbook = new HSSFWorkbook();
            HSSFSheet mzsheet = ExcelUtil.getSheet(ohssfWorkbook, "Sheet1");
            
            for (int i=0; i <= row; i++) {
                // 病例号
                String patientId = ExcelUtil.getSheetCellValue(sheet, i, 0);
                // 教学日期
                String date = ExcelUtil.getSheetCellValue(sheet, i, 1);
                // 检查类型
                String checkType = ExcelUtil.getSheetCellValue(sheet, i, 2);
                System.out.println(patientId);
                ExcelUtil.setSheetCellValue(mzsheet, i, 0, patientId);
                ExcelUtil.setSheetCellValue(mzsheet, i, 1, i==0 ? date : convertDate(date));
                ExcelUtil.setSheetCellValue(mzsheet, i, 2, checkType);
            }
            
            String opath = PropertyUtils.getInstance().getValue("sys.excel.opath");
            ExcelUtil.writeXls(ohssfWorkbook, opath);
        }
    }
    
    private static String convertDate(String date) {
        String[] tmp = StringUtils.split(date, "-");
        tmp[1] = String.format("%02d", Integer.parseInt(tmp[1]));
        tmp[2] = String.format("%02d", Integer.parseInt(tmp[2]));
        
        return StringUtils.join(tmp, "-");
    }
}
