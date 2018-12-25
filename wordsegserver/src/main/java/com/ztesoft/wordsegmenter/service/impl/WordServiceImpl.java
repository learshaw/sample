/*
 * 文 件 名:  WordServiceImpl.java
 * 版    权:  浩鲸云科技股份有限公司
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/15 14:54
 */
package com.ztesoft.wordsegmenter.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;
import org.springframework.stereotype.Service;

import com.ztesoft.wordsegmenter.service.WordService;

/**
 * $分词实现
 * 
 * @author LvWenbin
 * @version [版本号, 2018/11/15 14:54]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class WordServiceImpl implements WordService {
    private static final Logger logger = LogManager.getLogger(WordServiceImpl.class);
    
    @PostConstruct
    public void init() {
        WordSegmenter.segWithStopWords("智慧交通");
    }
    
    public List<String> seg(String text, SegmentationAlgorithm sa) {
        List<Word> words = WordSegmenter.seg(text, SegmentationAlgorithm.BidirectionalMaximumMatching);
        return convertText(words);
    }
    
    public List<String> seg(String text) {
        List<Word> words = WordSegmenter.seg(text);
        return convertText(words);
    }
    
    public List<String> segWithStopWords(String text) {
        List<Word> words = WordSegmenter.segWithStopWords(text);
        return convertText(words);
    }
    
    public void seg(File input, File output) {
        try {
            WordSegmenter.seg(input, output);
        } catch (Exception e) {
            logger.error("WordServiceImpl seg file fail!: {} \n 堆栈信息: {}", e.getMessage(), e.getStackTrace());
        }
    }
    
    public void segWithStopWords(File input, File output) {
        try {
            WordSegmenter.segWithStopWords(input, output);
        } catch (Exception e) {
            logger.error("WordServiceImpl seg file fail!: {} \n 堆栈信息: {}", e.getMessage(), e.getStackTrace());
        }
    }
    
    private List<String> convertText(List<Word> words) {
        List<String> retList = new ArrayList<>();
        
        if (CollectionUtils.isNotEmpty(words)) {
            for (Word word : words) {
                retList.add(word.getText());
            }
        }
        
        return retList;
    }
}
