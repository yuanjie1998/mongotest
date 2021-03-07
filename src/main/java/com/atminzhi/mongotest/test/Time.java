package com.atminzhi.mongotest.test;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
测试时间转换
 */
public class Time {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();
        System.out.println(date); //Mon Feb 01 16:07:43 CST 2021
        //由date转换字符
        String time = df.format(date);//2021-02-01 16:07:43
        //由字符转换date
        Date parse2 = df.parse(time);
        System.out.println("由字符转换date："+parse2);
        System.out.println("由字符转换date："+time);

//        解析日期时间
        System.out.println("---- 解析日期时间-----");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = dateFormat.parse("2020-12-28 19:00:00");
        System.out.println("解析后："+parse); //Mon Dec 28 19:00:00 CST 2020
        //将日期格式转换为毫秒
        long parse1 = dateFormat.parse("2021-12-23 20:00:00").getTime();
        System.out.println("将Date转换为毫秒格式："+parse1); //1640260800000

//格式化时间
        System.out.println("----格式化时间-----");
        long millis = System.currentTimeMillis();
        System.out.println("系统当前时间："+millis); //1612166863616
        String format = dateFormat.format(millis);
        System.out.println(format);//2021-02-01 16:07:43
        System.out.println("------得到前第30天的日期------");

        //得到前第30天的日期
        Date now = new Date();
        String nowDate = dateFormat.format(now);
        System.out.println("当前时间："+nowDate);
        Date startDate = DateUtils.addDays(now, -30);
        String beforeDate = dateFormat.format(startDate);
        System.out.println("beforeDate："+beforeDate);

        System.out.println("过去一个月："+DateMonth());

    }
    //过去一月的时间
    public static String DateMonth (){
        SimpleDateFormat month = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        //过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = month.format(m);
        return mon;
    }

}
