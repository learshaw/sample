/*
 * 文 件 名:  PropertyUtils.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/12/19
 */
package org.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/12/19 10:31]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class PropertyUtils {
    Properties prop = null;
    
    private static PropertyUtils propertyUtils = new PropertyUtils();
    
    private PropertyUtils() {
        try {
            prop = new Properties();
            File file = new File(this.getClass().getClassLoader().getResource("config.properties").getPath());
            InputStream in = new FileInputStream(file);
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static PropertyUtils getInstance() {
        return propertyUtils;
    }
    
    public String getValue(String key) {
        return prop.getProperty(key);
    }
    
    public String getValue(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }
}
