package com.example.demo;

import com.example.demo.common.util.FileUtils;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author GongCJ
 * @version 1.0
 * @description TODO 简单测试
 * @data 2021/5/24 14:56
 */
public class SimpleTest {
    @Test
    public void test001(){
        List result = new ArrayList<>();
        File file = new File("E:\\GongCJ\\2021综合基础知识");
//        File file = new File("E:\\mes");
        FileUtils.getAllFiles(result,file,file.getPath(), (item)->true);
        result.forEach(System.out::println);
    }
}
