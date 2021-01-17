package com.atminzhi.mongotest.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
测试时间转换
 */
public class Time {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();
        System.out.println(date);
        System.out.println("时间："+df.format(date));
//        解析日期时间
        System.out.println("---- 解析日期时间-----");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = dateFormat.parse("2020-12-28 19:00:00");
        System.out.println("解析后："+parse);

//格式化时间
        System.out.println("----格式化时间-----");
        long millis = System.currentTimeMillis();
        System.out.println("系统当前时间："+millis);
        String format = dateFormat.format(millis);
        System.out.println(format);
    }
}
