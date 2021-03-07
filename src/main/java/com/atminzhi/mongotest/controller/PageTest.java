package com.atminzhi.mongotest.controller;

import com.atminzhi.mongotest.constant.Mapconstant;
import com.atminzhi.mongotest.entity.Page;
import com.atminzhi.mongotest.entity.TestPlus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
分页
 */
@Api(value = "分页测试")
@RestController
public class PageTest {
    @Autowired
    MongoTemplate template;

    private static Logger logger = LoggerFactory.getLogger(PageTest.class);

    @ApiOperation("测试分页的方法")
    @GetMapping("/selectPageOne")
    public Map<String,Object> selectPageOne( int current, int limit){
        Map<String,Object> map = new HashMap<>();

        Page page = new Page();
//        int limit = page.getLimit();
//        int offset = page.getOffset();
        page.setCurrent(current);
        page.setLimit(limit);
        int offset = page.getOffset();
        //把分页查询limit、skip
        Query query = new Query().limit(limit).skip(offset);
        List<TestPlus> autoinser_tList = template.find(query, TestPlus.class, "autoinsert ");
        //查询数据库数据总条数
        Query query1 = new Query(Criteria.where("_id").ne(""));
        long count = template.count(query1, TestPlus.class, "autoinsert ");

        System.out.println("long类型数据库总条数为："+count);
        //将long类型数据转为String类型再转为int类型
        int i = Integer.parseInt(String.valueOf(count));
        //将数据总条数赋值
        page.setRows(i);
        System.out.println("int类型数据总条数为："+page.getRows());
        System.out.println("总页数为："+page.getTotal());

        System.out.println("分页结果为："+autoinser_tList);
        map.put("autoinser_tList",autoinser_tList);
        //给map集合中加入其它返回的值
        map.put("msg","恭喜分页功能操作完毕");
        map.put("数据总条数为：",page.getRows());
        map.put("展示的总页数为：",page.getTotal());
        map.put("statu", Mapconstant.ERREY_FOUR);
        System.out.println("分的总页数(调用api)："+(int) Math.ceil(count / page.getLimit()));
        return map;
    }
}
