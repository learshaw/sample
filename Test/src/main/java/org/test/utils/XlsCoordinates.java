/*
 * 文 件 名:  sss.java
 * 版    权:  江苏智通交通科技
 * 描    述:  <描述>
 * 修 改 人:  learshaw
 * 修改时间:  2014年9月19日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package org.test.utils;


/**
 * Excel坐标
 * <功能详细描述>
 * 
 * @author  learshaw
 * @version  [版本号, 2014年9月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class XlsCoordinates
{
    /**
     * 列
     */
    private int column;
    
    /**
     * 行
     */
    private int row;
    
    public XlsCoordinates()
    {
    }
    
    public XlsCoordinates(int column, int row)
    {
        this.column = column;
        this.row = row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }
}
