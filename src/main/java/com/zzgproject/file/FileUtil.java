package com.zzgproject.file;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

public class FileUtil {

    
    /**
     * 
     * 引入commons-io-xx.jar
     * 使用包中封装的FileUtils工具类
     * 
     */
    
    public static void main(String[] args) throws IOException{
        
        String root = "E:" + File.separator;
        
        File dir = new File(root + "aaa");
        System.out.println(dir.exists());
        
        /**
         * FileUtils.cleanDirectory(dir) : 清空文件夹中的所有文件和文件夹，但不包括文件夹本身
         */
        if(dir.exists()) FileUtils.cleanDirectory(dir);
        
        /**
         * 注意：使用JDK的File对象是无法直接删除文件夹的
         * 
         * FileUtils.deleteDirectory(dir) : 直接删除文件夹
         */
        if(dir.exists()) FileUtils.deleteDirectory(dir);
        
        /**
         * FileUtils.deleteQuietly(dir) : 快速删除，不抛出任何异常
         */
        if(dir.exists()) FileUtils.deleteQuietly(dir);
        
        /**
         * 读取文本文件
         */
        File file = new File(root + "代帐易.sql");
        List<String> list = FileUtils.readLines(file, "GBK");
        System.out.println(list);
        
        String str = FileUtils.readFileToString(file, "GBK");
//        System.out.println(str);
        
        System.out.println(file.getPath());
        
        /**
         * 复制文件以及复制文件夹
         */
        FileUtils.copyFile(file, new File(root + "abc.sql"));
        
        File srcDir = new File(root + "chromDownload");
        File destDir = new File(root + "chromDownload2");
//        FileUtils.copyDirectory(srcDir, destDir);
        
        FileUtils.copyFile(file, new File(root + "abc2.sql"));
        
        
        System.out.println(FilenameUtils.getName(file.getPath()));
        
    }
    
    
    
}
