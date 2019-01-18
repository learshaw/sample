/*
 * 文 件 名:  WordController.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/15 14:45
 */
package com.ztesoft.wordsegmenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ztesoft.wordsegmenter.service.WordService;
import com.ztesoft.wordsegmenter.vo.TextData;

/**
 * $Api接口 <功能详细描述>
 * 
 * @author LvWenbin
 * @version [版本号, 2018/11/15 14:45]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class WordController {
    @Autowired
    private WordService wordService;
    
    @RequestMapping(value = {"/seg/{algorithmStr}"}, method = {
        org.springframework.web.bind.annotation.RequestMethod.GET})
    public List<String> seg(@RequestParam(name = "text") String text,
        @PathVariable("algorithmStr") String algorithmStr) {
        List<String> retList = null;
        
        if (StringUtils.equals("MaximumMatching", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.MaximumMatching);
        } else if (StringUtils.equals("ReverseMaximumMatching", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.ReverseMaximumMatching);
        } else if (StringUtils.equals("MinimumMatching", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.MinimumMatching);
        } else if (StringUtils.equals("ReverseMinimumMatching", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.ReverseMinimumMatching);
        } else if (StringUtils.equals("BidirectionalMaximumMatching", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.BidirectionalMaximumMatching);
        } else if (StringUtils.equals("BidirectionalMinimumMatching", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.BidirectionalMinimumMatching);
        } else if (StringUtils.equals("BidirectionalMaximumMinimumMatching", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.BidirectionalMaximumMinimumMatching);
        } else if (StringUtils.equals("FullSegmentation", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.FullSegmentation);
        } else if (StringUtils.equals("MinimalWordCount", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.MinimalWordCount);
        } else if (StringUtils.equals("MaxNgramScore", algorithmStr)) {
            retList = this.wordService.seg(text, SegmentationAlgorithm.MaxNgramScore);
        } else {
            retList = new ArrayList<>();
        }
        
        return retList;
    }
    
    @RequestMapping(value = {"/seg"}, method = {RequestMethod.GET})
    public List<String> seg(@RequestParam(name = "text") String text) {
        return this.wordService.seg(text);
    }
    
    @RequestMapping(value = {"/segwithstopwords"}, method = {RequestMethod.GET})
    public List<String> segWithStopWords(@RequestParam(name = "text") String text) {
        return this.wordService.segWithStopWords(text);
    }
    
    @RequestMapping(value = {"/segbigtext"}, method = {RequestMethod.POST})
    public List<String> segBigText(@RequestBody TextData input) {
        return this.wordService.seg(input.getText());
    }
    
    @RequestMapping(value = {"/segbigtextwithstopwords"}, method = {RequestMethod.POST})
    public List<String> segBigTextWithStopWords(@RequestBody TextData input) {
        return this.wordService.segWithStopWords(input.getText());
    }
}
