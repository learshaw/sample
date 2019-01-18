/*
 * 文 件 名:  BatchWord.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/15 14:59
 */
package com.ztesoft.wordsegmenter.vo;

import java.util.List;

import lombok.Data;

/**
 * $批量提交
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/15 14:59]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Data
public class BatchWord {
    private List<String> words;
}
