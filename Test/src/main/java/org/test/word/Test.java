/*
 * 文 件 名:  Test.java
 * 描    述:  <描述>
 * 修 改 人:  LvWenbin
 * 修改时间:  2018/11/13 16:20
 */
package org.test.word;

import java.util.List;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

/**
 * 分词
 * <功能详细描述>
 * 
 * @author  LvWenbin
 * @version  [版本号, 2018/11/13 16:20]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Test {
    public static void main(String[] args) {
        List<Word> words = WordSegmenter.segWithStopWords("杨尚川是APDPlat应用级产品开发平台的作者");
        System.out.println(words);
    }
}
