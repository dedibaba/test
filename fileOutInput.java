package com.manyi.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 */
public class fileOutInput {
    //将字符串写入文件
    public static void writeToFile(String text, String url) throws FileNotFoundException, UnsupportedEncodingException, Exception {
        File f = new File(url);
        FileOutputStream fop = new FileOutputStream(f, true);
        // 构建FileOutputStream对象,文件不存在会自动新建
//        fop.write(text.getBytes("UTF-8"));

        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
        writer.append(text);
        // 写入到缓冲区
        writer.append("\r\n");
        //换行                  FileOutputStream
        writer.append(text);
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
        writer.close();
        //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
        fop.close();
        // 关闭输出流,释放系统资源
//        FileInputStream fip = new FileInputStream(f);
//        // 构建FileInputStream对象
//        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
//        // 构建InputStreamReader对象,编码与写入相同
//        StringBuffer sb = new StringBuffer();
//        while (reader.ready()) {
//            sb.append((char) reader.read());
//            // 转成char加到StringBuffer对象中
//        }
//        System.out.println(sb.toString());
//        reader.close();
//        // 关闭读取流
//        fip.close();
        // 关闭输入流,释放系统资源
    }
    //把A里的内容写入B中
    public static void copyAToB(String urlA, String urlB) throws Exception {
        FileInputStream fip = new FileInputStream(urlA);
        // 构建FileInputStream对象 ,windows默认的编码时GBK，所以先用GBK获取，在转换成UTF-8输出
        InputStreamReader reader = new InputStreamReader(fip, "GBK");
        // 构建InputStreamReader对象,编码与写入相同
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // 转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        File f = new File(urlB);
        FileOutputStream fop = new FileOutputStream(f, true);
        // 构建FileOutputStream对象,文件不存在会自动新建
//        fop.write(text.getBytes("UTF-8"));
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
        writer.append(sb.toString());
        // 写入到缓冲区
        writer.append("\r\n");
        //换行                  FileOutputStream
        writer.append(sb.toString());
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
        writer.close();
        //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
        fop.close();
        reader.close();
        // 关闭读取流
        fip.close();
        // 关闭输入流,释放系统资源
    }
    public static void main(String[] args) throws Exception {
//        fileOutInput.copyAToB("C:\\Users\\Administrator\\Desktop\\text.txt","C:\\Users\\Administrator\\Desktop\\test.txt");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

    }
}