package com.atminzhi.mongotest.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pastAndGet")
public class PostAndGet {

    @GetMapping("/getEmp")
    public List<Map<String,Object>> getEmp(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",20);
        map.put("salary",8000.00);
        list.add(map);

        map = new HashMap<>();
        map.put("name","李四");
        map.put("age",25);
        map.put("salary",6000.00);
        list.add(map);

        map = new HashMap<>();
        map.put("name","王五");
        map.put("age",27);
        map.put("salary",3000.00);
        list.add(map);

        map = new HashMap<>();
        map.put("name","袁杰");
        map.put("age",28);
        map.put("salary",5263.00);
        list.add(map);
        return list;
    }
}
