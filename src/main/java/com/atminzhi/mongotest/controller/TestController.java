package com.atminzhi.mongotest.controller;

import com.atminzhi.mongotest.entity.Test;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test01")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);
//    @Autowired
//    TestService testService;

    @Autowired
    MongoTemplate mongoTemplate;
    //按条件查找操作
    @GetMapping("/test")
    public List<Test> test(){
        logger.info("查找成功,拿到了....");
        Query query = new Query(Criteria.where("name").is("袁杰"));
        query.addCriteria(Criteria.where("age").is(22));
        List<Test> Tests = mongoTemplate.find(query, Test.class,"commodity ");
        System.out.println(Tests);
        if (!StringUtils.isEmpty(Tests)){
            System.out.println("查找成功");
        }
        return Tests;
    }
    //查询所有
    @GetMapping("/findAll")
    public List<Test> findAll(){
        List<Test> all = mongoTemplate.findAll(Test.class,"commodity ");
        System.out.println(all);
        if (!StringUtils.isEmpty(all)){
            System.out.println("查找成功");
        }
        return all;
    }
    //新增数据
    @PostMapping("/addOne")
    public void add(@RequestBody Test test){
        System.out.println("iiiiii");
//        Test test = new Test();
//        test.set_id("333");
//        test.setAge(25.3);
//        test.setHeight(1.66);
//        test.setMonthlysalary(2253.0);
//        test.setName("刘军");
//        test.setSsex("man");
        Test result = mongoTemplate.save(test, "commodity ");
        if (!StringUtils.isEmpty(result)){
            System.out.println("数据新增成功！");
        }
       
//        testService.saveUser(test);
    }
    //通过名字删除数据
    @PostMapping("/delete")
    public void delete(){
        Query query = new Query(Criteria.where("name").is("xixi"));
        DeleteResult deleteResult = mongoTemplate.remove(query, "commodity ");
        if (!StringUtils.isEmpty(deleteResult)){
            System.out.println("删除成功!");
        }
    }
    //通过名字查找数据
    @GetMapping("/find")
    public void findUserByName(){
        Query query = new Query(Criteria.where("name").is("王佳佳"));
        query.addCriteria(Criteria.where("ssex").is("woman"));
        Test test = mongoTemplate.findOne(query, Test.class,"commodity ");
        System.out.println(test);
    }
    //修改数据
    @PostMapping("/update111")
    public void updateUser(){
        Query query = new Query(Criteria.where("name").is("旺旺"));
        Update update = new Update().set("name","王五嘎嘎").set("monthlysalary",666);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Test.class,"commodity ");
        if (!StringUtils.isEmpty(result)){
            System.out.println("数据修改成功：");
        }
    }
    @PostMapping("/kaka")
    public Test fingAll(Test test){
        Test test1 = new Test();
        test1.setName(test.getName());
        test1.setAge(test.getAge());
        System.out.println(test1);
        return test1;
    }
}
