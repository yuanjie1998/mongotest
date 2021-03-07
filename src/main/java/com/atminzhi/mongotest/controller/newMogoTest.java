package com.atminzhi.mongotest.controller;

import com.atminzhi.mongotest.constant.Mapconstant;
import com.atminzhi.mongotest.entity.Hobby;
import com.atminzhi.mongotest.entity.TestPlus;
import com.atminzhi.mongotest.entity.enums.MongoStatusEnum;
import com.google.common.collect.Maps;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/*
测试数据库的集合中list、对象类型的数据crud
 */
@Api("测试从前台拿到JSON数据到mongo中获取数据")
@RestController
public class newMogoTest {
    private static Logger logger = LoggerFactory.getLogger(newMogoTest.class);

    @Autowired
    MongoTemplate mongoTemplate;

    //新增数据
    @ApiOperation("新增数据")
    @PostMapping("/insert")
    public void insertCommodity(@RequestBody TestPlus testPlus){
        System.out.println("进入新增方法...");
        TestPlus autoinsert = mongoTemplate.save(testPlus, "autoinsert ");
        System.out.println(autoinsert);
        if (!StringUtils.isEmpty(autoinsert)){
            logger.info(MongoStatusEnum.SUCCESS_INFO.getMongoTatusDescribe()); //Mapconstant.SUCCESS_INSERT
        }else {
            logger.info(MongoStatusEnum.ERROR_INFO.getMongoTatusDescribe()); //Mapconstant.ERROR_INSERT
        }
    }

    //修改对象里的数据
    @ApiOperation("修改对象里的数据")
    @PostMapping("/updateObj")
    public void updateObj (){
        Query query = new Query();
        query.addCriteria(Criteria.where("height").is("1.56").and("age").is("25"));
        Update update = new Update();
        update.set("hobby.name","火箭1").set("hobby.size","88").set("hobby.color","blue");
        UpdateResult result = mongoTemplate.updateFirst(query,update,TestPlus.class,"autoinsert ");
        if (!StringUtils.isEmpty(result)){
            logger.info("数据修改成功！");
            System.out.println("修改的数据："+result);
        }else {
            logger.info("数据修改失败!");
        }
    }

    //修改集合里的数据
    @ApiOperation("修改集合里的数据")
    @PostMapping("/updateList")
    public void updateList(@RequestBody List<String> monthlysalary){
        System.out.println("进入修改集合数据方法....");
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("小黑").and("age").is("63"));
        Update update = new Update();
        update.set("monthlysalary",monthlysalary);
        UpdateResult result = mongoTemplate.updateFirst(query,update,TestPlus.class,"autoinsert ");
        if (!StringUtils.isEmpty(result)){
            logger.info("数据修改成功！");
            System.out.println("修改的数据："+result);
        }else {
            logger.info("数据修改失败!");
        }
    }

    //根据姓名删除数据库的一条数据
    @ApiOperation("根据姓名删除数据库的一条数据")
    @GetMapping("/deleteOne")
    public void deleteOne(){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("25"));
        DeleteResult commodity_ = mongoTemplate.remove(query, TestPlus.class, "autoinsert ");
        if (!StringUtils.isEmpty(commodity_)){
            System.out.println(commodity_);
            logger.info("数据删除成功");
        }else {
            logger.info("数据删除失败！");
        }
    }

    //循环前端传来的map集合并打印在控制台
    //可以直接通过map的key获取值
    @ApiOperation("测试前端传来的map集合并打印在控制台")
    @PostMapping("/pringln")
    public void pringlen(@RequestBody Map<String,Object> data){
        Object monthlysalary = data.get("monthlysalary");
        System.out.println("monthlysalary"+monthlysalary);
        for(String key:data.keySet()){
            String value = data.get(key).toString();
            System.out.println("key："+key+" vlaue:"+value);
        }
        System.out.println("集合中获取的monthlysalary："+data.get("monthlysalary"));
    }

    //循环前端传来的List<map<String,Object>>集合并打印在控制台
    //*若map集合外包裹着list集合，只需要遍历集合，然后map通过keyget出值
    @ApiOperation("测试前端传来的List<map<String,Object>>集合并打印在控制台")
    @GetMapping("/pringlnList")
    public void pringlnList(@RequestBody List<Map<String,Object>> listMap1){
        //第一种方式foreach遍历,先遍历listmap1
        for (Map<String,Object> map : listMap1) {
            //循环map集合,获取map中的值
//            for (String key : map.keySet()) {
//                System.out.println("循环获取hobby对象的值："+map.get("hobby"));
//            }
//            List<Object> a =  new ArrayList<>();
//                  a.add(map.get("monthlysalary"));
            System.out.println("不循环map获得hobby对象的值："+map.get("hobby"));
            System.out.println("不循环map获得ssex的值："+map.get("ssex"));
            System.out.println("不循环map获得monthlysalary集合的值："+map.get("monthlysalary"));
            System.out.println("不循环map获得height的值："+map.get("height"));
        }

    }

    //测试前台数据(数据名称、类型 对应)放在实体对象中，然后取值(给业务层数据库的crud作为条件)
    @ApiOperation("测试参数为实体类时传参")
    @PostMapping("/dataEntity")
    public Map<String,Object> dataEntity(@RequestBody TestPlus testPlus){
        Map<String,Object> map = new HashMap<>();
        //得到map到实体类中的参数值
        List<String> monthlysalary = testPlus.getMonthlysalary();
        List<String> name = testPlus.getName();
        String age = testPlus.getAge();
        Hobby hobby = testPlus.getHobby();
        //打印倒控制台
        System.out.println("monthlysalary："+monthlysalary);
        System.out.println("name："+name);
        System.out.println("age："+age);
        System.out.println("hobby:"+hobby);
        //将结果放入map集合中返回
        map.put("monthlysalary",monthlysalary);
        map.put("name",name);
        map.put("age",age);
        map.put("hobby",hobby);
        return map;
    }

    //使用参数在路径上的接口
    @ApiOperation("使用参数在路径上的接口")
    @GetMapping(value="/user/{username}")
    public String userProfile(@PathVariable(value="username") String username) {
        System.out.println("前台参数直接写在请求的路径上"+username);
        return "user"+username;
    }

    @ApiOperation("(排序)查询所有数据，并根据age进行倒序输出数据")
    @GetMapping("/delectSort")
    public Map<String,Object> delectSort(){
        Map<String,Object> map = new HashMap<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").ne(null));
//        Sort sort = new Sort(Sort.Direction.DESC,"age");
        //desc倒序  asc升序
        query.with(Sort.by(Sort.Order.asc("age")));
        List<TestPlus> autoinsertList = mongoTemplate.find(query, TestPlus.class, "autoinsert ");
        //循环结果集合，并给增加的属性赋值
        autoinsertList.forEach(x->{
            x.setColor("红色");
        });
        map.put("autoinsertList",autoinsertList);
        System.out.println(map);
        if (!StringUtils.isEmpty(autoinsertList)){
            map.put("stuta", Mapconstant.ERREY_FIVE);
            return map;
        }else {
            map.put("stata",Mapconstant.ERREY_SIX);
            return null;
        }

    }
    /**
     * 排序
     */
//    public Query dealCondition(String taskType, String search, Integer page, Integer size, String projectId) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("partUsers").is(UserUtil.getCurrentUserName()));
//        if (TaskType.today.value.equals(taskType)) {
//            //根据截止日期排序
//            DateTime begin = DateUtil.beginOfDay(DateUtil.date());
//            DateTime end = DateUtil.endOfDay(DateUtil.date());
////            String begin = DateUtil.format(DateUtil.beginOfDay(DateUtil.date()), DatePattern.NORM_DATETIME_PATTERN);
////            String end = DateUtil.format(DateUtil.endOfDay(DateUtil.date()), DatePattern.NORM_DATETIME_PATTERN);
//            Criteria criteria = Criteria.where("endTime").gte(begin).lte(end);

//            query.addCriteria(criteria).with(new Sort(Sort.Direction.DESC, "endTime").and(new Sort(Sort.Direction.ASC,"taskStatus")));
//            System.out.println(query.toString());
//        }
//        if (TaskType.undone.value.equals(taskType)) {
//            //根据创建日期排序
//            List<Integer> integerList = Arrays.asList(TaskStatusEnum.UNRECIEVED.getCode(),
//                    TaskStatusEnum.ACCEPTED.getCode(), TaskStatusEnum.EXECUTING.getCode());
//            Criteria in = Criteria.where("taskStatus").in(integerList);
//            query.addCriteria(in);
//            query.with(new Sort(Sort.Direction.ASC,"taskStatus").and(new Sort(Sort.Direction.DESC,"createTime")));
//        }
//        if (TaskType.week.value.equals(taskType)) {
//            //截止日期在本周  日期正序从小到大
//            DateTime end = DateUtil.endOfWeek(DateUtil.date());
//            DateTime begin = DateUtil.beginOfWeek(DateUtil.date());
//            //String end = DateUtil.format(DateUtil.endOfWeek(DateUtil.date()), DatePattern.NORM_DATETIME_PATTERN);
//            Criteria criteria = Criteria.where("endTime").lte(end).gte(begin);
//            query.addCriteria(criteria);
//            query.with(new Sort(Sort.Direction.ASC,"taskStatus").and(new Sort(Sort.Direction.DESC,"endTime")));
//        }
//        if (TaskType.overdue.value.equals(taskType)) {
//            query.addCriteria(Criteria.where("outTimeStatus").is(1).and("taskStatus").ne(TaskStatusEnum.COMPLETE.getCode()));
//            query.with(new Sort(Sort.Direction.ASC,"taskStatus").and(new Sort(Sort.Direction.DESC,"taskPriority","endTime")));
//        }
//        if (TaskType.all.value.equals(taskType)) {
//            query.with(new Sort(Sort.Direction.ASC,"taskStatus").and(new Sort(Sort.Direction.DESC,"endTime","taskPriority")));
//        }
//
//
//        if (TaskType.least.value.equals(taskType)) {
//            query.with(new Sort(Sort.Direction.ASC,"taskStatus").and(new Sort(Sort.Direction.DESC,"createTime")));
//        }
//        if (StrUtil.isNotEmpty(search)) {
//            query.addCriteria(Criteria.where("title").regex(search));
//        }
//        if (StrUtil.isNotEmpty(projectId)) {
//            query.addCriteria(Criteria.where("relatedProject").is(projectId));
//        }
//        query.addCriteria(Criteria.where("isHasSubtask").is(0));
//        query.skip((page - 1) * size).limit(size);
//        return query;
//    }

    /**查询数据库的所有数据(模糊查询)
     * 这里使用的正则表达式的方式
     * 第二个参数Pattern.CASE_INSENSITIVE是对字符大小写不明感匹配
     */
    @ApiOperation("模糊查询数据库的所有数据")
    @GetMapping("/selectAll")
    public Map<String,Object> testPluses (){
        Map<String, Object> map = new HashMap<>();
//        Pattern pattern = Pattern.compile("^.*"+"球"+".*$",Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("hobby.name").regex("跳"));
        List<TestPlus> allList = mongoTemplate.find(query, TestPlus.class, "autoinsert ");
        map.put("addData",allList);
        map.put("addnews","除数据库数据外新添加的");
        if (!StringUtils.isEmpty(allList)){
            System.out.println("模糊查询的数据为："+map);
            logger.info("所有数据查询成功！");
        }else {
            logger.info("数据查询失败！");
        }
        return map;
    }

    /**
     * 测试查询 0< age <30区间的数据
     * 查询结果的排序
     * @return
     */
    @ApiOperation("查询某个区间的数据")
    @GetMapping("/findBySection")
    public Map<String,Object> findBySection (){
        Map<String,Object> map = Maps.newHashMap();
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte("0").andOperator(Criteria.where("age").lte("30")));
        //设置查询结果的排序
        query.with(Sort.by(Sort.Order.desc("age")));
        List<TestPlus> testPlusList = mongoTemplate.find(query, TestPlus.class, "autoinsert ");
        logger.info("查询的数据为："+testPlusList);
        //查询数据条数
        long count = mongoTemplate.count(query, TestPlus.class, "autoinsert ");

        if (!StringUtils.isEmpty(testPlusList)){
            map.put("testPlusList",testPlusList);
            map.put("msg","查询成功！");
            map.put("code",200);
            map.put("数据总条数：",count);
            return map;
        }else {
            map.put("testPlusList",testPlusList);
            map.put("msg","查询失败！");
            return map;
        }
    }
}
