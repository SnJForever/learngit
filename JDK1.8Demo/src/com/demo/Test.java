package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	/**
     * 复制文件
     * 从源路径到目标文件夹路径，文件名保持一致
     * 如果目标文件夹不存在则自动创建
     * 如果文件已经存在则自动编号-copy n
     *
     * @param srcFile 源文件绝对路径
     * @param dstDir  目标文件夹绝对路径
     * @return 是否成功复制文件
     */
    public static boolean copyFile(File srcFile, File dstDir) {
        if (!srcFile.exists() || srcFile.isDirectory()) {
            return false;
        }
        if (!dstDir.exists()) {
            dstDir.mkdirs();
        }
        String oldFileName = srcFile.getName();
        Pattern suffixPattern = Pattern.compile("\\.\\w+");
        Matcher matcher = suffixPattern.matcher(oldFileName);
        String nameBody;
        String suffix;
        if (matcher.find()) {
            nameBody = oldFileName.substring(0, matcher.start());
            suffix = oldFileName.substring(matcher.start());
        } else {
            nameBody = oldFileName;
            suffix = "";
        }
        int fileNumber = 0;
        File newFile = new File(dstDir, oldFileName);
        while (newFile.exists()) {
            fileNumber++;
            String newFileName = nameBody + "-copy" + fileNumber + suffix;
            newFile = new File(dstDir, newFileName);
        }
        try {
            FileChannel fileIn = new FileInputStream(srcFile).getChannel();
            FileChannel fileOut = new FileOutputStream(newFile).getChannel();
            fileIn.transferTo(0, fileIn.size(), fileOut);
            fileIn.close();
            fileOut.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    
    /**
     * 移动(剪切)文件
     *
     * @param srcFile
     * @param dstDir
     * @return
     */
    public static boolean moveFile(File srcFile, File dstDir) {
        if (!srcFile.exists() || srcFile.isDirectory()) {
            return false;
        }
        if (!dstDir.exists()) {
            dstDir.mkdirs();
        }
        String oldFileName = srcFile.getName();
        File dstFile = new File(dstDir, oldFileName);
        if (srcFile.renameTo(dstFile)) {// 直接重命名绝对路径速度更快
            return true;
        } else {// 文件已经存在，需要自动编号复制再删除源文件
            copyFile(srcFile, dstDir);
            srcFile.delete();
        }
        return true;
    }
    
    //获取扩展名
    public static String getExtensionName(String filename) { 
        if ((filename != null) && (filename.length() > 0)) { 
            int dot = filename.lastIndexOf('.'); 
            if ((dot >-1) && (dot < (filename.length() - 1))) { 
                return filename.substring(dot + 1); 
            } 
        } 
        return filename;
    }
   
    public static void main(String[] args) {
		copyFile(new File("/data"), new File("/data/jpg"));
		
			
	}
    
}
