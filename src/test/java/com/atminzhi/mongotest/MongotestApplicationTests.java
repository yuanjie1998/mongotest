package com.atminzhi.mongotest;

import com.atminzhi.mongotest.Service.MapService;
import com.atminzhi.mongotest.controller.TestController;
import com.atminzhi.mongotest.controller.YuanJieController;
import com.atminzhi.mongotest.test.Calendar1;
import com.atminzhi.mongotest.util.EmailClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class MongotestApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(MongotestApplicationTests.class);

    @Autowired
    YuanJieController yuanJieController;
    @Autowired
    TestController testController;
    @Autowired
    EmailClient emailClient;
    @Autowired
    TemplateEngine templateEngine;
    @Autowired
    MapService mapService;
    @Autowired
    Calendar1 calendar1;

    @Test
    void contextLoads() {
    }
    @Test
    public void getAll(){
        System.out.println("kkkkk");
        testController.findUserByName();
    }
    //测试发送邮件
//    @Test
//    public void testEmail(){
//        //只发送文本
//        emailClient.sendMail("1916819402@qq.com","test测试发邮件","Welcom");
//    }

    //发送html邮件
//    @Test
//    public void testHtmlMail(){
//        Context context = new Context();
//        context.setVariable("username","袁杰");
//
//        String content = templateEngine.process("/demo", context);
//        System.out.println(content);
//
//        emailClient.sendMail("1916819402@qq.com","HTML",content);
//    }
//    测试map集合的取值与存值
    @Test
    public void maSelect(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("姓名","袁杰");
        map1.put("年龄",22);
        map1.put("爱好","篮球");
        map1.put("身高",1.80);
        map1.put("性别","man");
        list.add(map1);

        map1 = new HashMap<>();
        map1.put("姓名","闫妮");
        map1.put("年龄",35);
        map1.put("爱好","化妆");
        map1.put("身高",1.65);
        map1.put("性别","woman");
        list.add(map1);

        map1 = new HashMap<>();
        map1.put("姓名","王俊凯");
        map1.put("年龄",26);
        map1.put("爱好","拍电影");
        map1.put("身高",1.87);
        map1.put("性别","man");
        list.add(map1);

        System.out.println("测试类中的循环："+list);
        int state = mapService.getMap(list);
        if (state==1){
            logger.info("map集合的值查询成功!");
        }else {
            logger.info("map集合的值查询失败！");
        }
    }
    @Test
    public void getUuid(){
        UUID s = UUID.randomUUID();
        UUID b = UUID.randomUUID();
        UUID c = UUID.randomUUID();
        System.out.println(s+"——"+b+"——"+c);
    }
    @Test
//    计算是否为周末 周日或周六
    public void jiSuan () throws ParseException {
        //测试是周末的date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = dateFormat.parse("2021-03-06");
        System.out.println("parse"+parse);

        int weeked = calendar1.isWeeked(parse);//new Date()
        System.out.println("今天是否为周末："+weeked);
    }
}
