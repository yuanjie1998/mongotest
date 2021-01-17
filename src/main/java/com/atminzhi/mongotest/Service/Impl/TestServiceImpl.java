package com.atminzhi.mongotest.Service.Impl;

import com.atminzhi.mongotest.Service.TestService;
import com.atminzhi.mongotest.entity.Test;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    MongoTemplate mongoTemplate;

    //新增数据
    @Override
    public void saveUser(Test test) {
        Test save = mongoTemplate.save(test, "commodity ");
        System.out.println("新增文档："+save);
    }
    //通过名字删除数据
    @Override
    public void removeUser() {
        //删除name为刘军的文档
        Query query = new Query(Criteria.where("name").is("刘军"));
        DeleteResult remove = mongoTemplate.remove(query, Test.class);
        System.out.println("删除文档："+remove);
    }
    //通过名字查找数据
    @Override
    public Test findUserByName() {
        Query query = new Query(Criteria.where("name").is("王佳佳"));
        Test test = mongoTemplate.findOne(query, Test.class);
        System.out.println("查找的数据为："+test);
        return test;
    }
    //修改数据
    @Override
    public int updateUser() {
        Query query = new Query(Criteria.where("name").is("王五"));
        Update update = new Update().set("name","旺旺").set("monthlysalary",8888);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Test.class);
        System.out.println("数据修改："+result);
        if (result!=null){
            return (int) result.getModifiedCount();
        }else
        return 0;
    }
}
