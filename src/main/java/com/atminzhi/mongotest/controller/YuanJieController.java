package com.atminzhi.mongotest.controller;

import com.atminzhi.mongotest.Service.TestTask;
import com.atminzhi.mongotest.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
测试
 */
@RestController
@RequestMapping("/yuanjie")
public class YuanJieController {
    @Autowired
    TestTask testTask;
    //记录本类的日志
    private Logger logger = LoggerFactory.getLogger(YuanJieController.class);


    @GetMapping("/getAllTask")
    public List<Task> getTest(){
            logger.info("获取所有的任务信息----");
            return testTask.getAllTask();
    }

}
