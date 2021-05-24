package com.example.demo.common.util;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author GongCJ
 * @version 1.0
 * @description TODO 文件处理工具
 * @data 2021/5/24 15:33
 */
public class FileUtils {


    /**
     *  @description TODO 根据文件路径获取文件所有
     *  @author GongCJ
     *  @data 2021-05-24 15:33
     *  @version 1.0
     *  @return
    */
    @Deprecated
    public static List getAllFiles001(File rootFile, final String rootPath, Predicate predicate){
        List result = new ArrayList();
        File[] files = rootFile.listFiles();
        //存放该目录下面所有的文件
        List filesR = new ArrayList<>();
        for(File file:files){
            Map resultM = new HashMap<>();
            //若是目录，则递归打印该目录下的文件
            if(file.isDirectory()){
                FileDetails fileDetails = new FileDetails(file.getName(), getAllFiles001(file, rootPath, predicate));
                resultM.put("directorys",fileDetails);
                result.add(resultM);
            }
            //若是文件
            if(file.isFile()){
                if (predicate.test(file.getName())) {
                    filesR.add(file.getPath().replace(rootPath+"\\",""));
                }
            }
        }
        Map filesRM = new HashMap<>();
        filesRM.put("files",filesR);
        result.add(filesRM);
        return result;
    }

    /**
     *  @description TODO 根据文件路径获取文件所有
     *  @author GongCJ
     *  @data 2021-05-24 15:33
     *  @version 1.0
     *  @return
     */
    public static void getAllFiles(List result,File rootFile, final String rootPath, Predicate predicate){
        File[] files = rootFile.listFiles();
        //存放该目录下面所有的文件
        for(File file:files){
            //若是目录，则递归打印该目录下的文件
            if(file.isDirectory()){
                getAllFiles(result,file, rootPath, predicate);
            }
            //若是文件
            if(file.isFile()){
                if (predicate.test(file.getName())) {
                    result.add(file.getPath().replace(rootPath+"\\",""));
                }
            }
        }
    }
}
class FileDetails implements Serializable {
    private String directoryName;
    private Object details;

    public FileDetails() {
    }

    public FileDetails(String directoryName, Object details) {
        this.directoryName = directoryName;
        this.details = details;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }
}
