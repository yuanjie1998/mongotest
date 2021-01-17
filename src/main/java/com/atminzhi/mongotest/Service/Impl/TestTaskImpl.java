package com.atminzhi.mongotest.Service.Impl;

import com.atminzhi.mongotest.Service.TestTask;
import com.atminzhi.mongotest.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTaskImpl implements TestTask {
    @Autowired
    MongoTemplate mongoTemplate;

    //查询task任务列表所有数据
    @Override
    public List<Task> getAllTask() {

        List<Task> task = mongoTemplate.findAll(Task.class, "task");

        return task;
    }
}
