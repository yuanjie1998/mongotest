package com.atminzhi.mongotest.test;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author yuan jie
 * @Date 2021/2/23 9:30
 */
@Component
public class Calendar1 {
    /**
     * 计算是否为周末 周日或周六
     * @param date 传入的时间
     * @return -1有错误; 0不是周末; 1是周末
     */
    public static int isWeeked(Date date){
        int result = 0;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int week_index = cal.get(Calendar.DAY_OF_WEEK);
            if(week_index==1 || week_index == 7){
                result = 1;
            }
        } catch (Exception e){
            result = -1;
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Date parse = dateFormat.parse("2021-03-08");
        System.out.println("将日期解析为Date类型："+parse);
        String format = dateFormat.format(parse);
        System.out.println("将日期格式化为String类型："+format);

        int weeked = isWeeked(parse); //new Date()
        if (weeked ==1){
            System.out.println("今天是周末！");
        }else if (weeked ==0){
            System.out.println("今天不是周末！");
        }else {
            System.out.println("出错了...");
        }
    }
}
