/*
 * 文 件 名:  WordService.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/15 14:51
 */
package com.ztesoft.wordsegmenter.service;

import java.io.File;
import java.util.List;

import org.apdplat.word.segmentation.SegmentationAlgorithm;

/**
 * 分词服务层
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/15 14:51]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public interface WordService {
    /**
     * $分词-指定算法
     * <功能详细描述>
     * @param paramString
     * @param paramSegmentationAlgorithm
     * @return
     * @see [类、类#方法、类#成员]
     */
    public abstract List<String> seg(String paramString, SegmentationAlgorithm paramSegmentationAlgorithm);

    /**
     * $分词-移除停用词
     * <功能详细描述>
     * @param paramString
     * @return
     * @see [类、类#方法、类#成员]
     */
    public abstract List<String> seg(String paramString);

    /**
     * $分词-保留停用词
     * <功能详细描述>
     * @param paramString
     * @return
     * @see [类、类#方法、类#成员]
     */
    public abstract List<String> segWithStopWords(String paramString);

    /**
     * $大文本分词-移除停用词
     * <功能详细描述>
     * @param paramString
     * @return
     * @see [类、类#方法、类#成员]
     */
    public abstract void seg(File paramFile1, File paramFile2);

    /**
     * $大文本分词-移除保留停用词
     * <功能详细描述>
     * @param paramString
     * @return
     * @see [类、类#方法、类#成员]
     */
    public abstract void segWithStopWords(File paramFile1, File paramFile2);
}
