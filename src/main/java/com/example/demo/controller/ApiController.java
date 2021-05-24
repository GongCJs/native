package com.example.demo.controller;

import com.example.demo.common.bean.Result;
import com.example.demo.common.util.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GongCJ
 * @version 1.0
 * @description TODO API
 * @data 2021/5/20 15:30
 */
@RestController
@RequestMapping(value = "api/")
public class ApiController {

    @Value("${native.staticFilePatch}")
    private String filePath;


    @GetMapping("/static/files")
    public Result hello(HttpServletRequest request) {
        List result = new ArrayList<>();
        File file = new File(filePath);
        FileUtils.getAllFiles(result,file,file.getPath(), (item)->true);
        return Result.ok(result);
    }
}
