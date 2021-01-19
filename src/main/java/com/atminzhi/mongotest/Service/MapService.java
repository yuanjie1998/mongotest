package com.atminzhi.mongotest.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MapService {
    public int getMap(List<Map<String,Object>> maps){
        //得到map的值只要进行数组的遍历即可,通过key得到value
        for (Map<String, Object> mapp: maps
             ) {
            String n = mapp.get("姓名").toString();
            String age = mapp.get("年龄").toString();
            String h = mapp.get("爱好").toString();
            String t = mapp.get("身高").toString();
            String ssex = mapp.get("性别").toString();
            System.out.println("Service类中的循环："+n+"-"+age+"-"+h+"-"+t+"-"+ssex);
            System.out.println("没有toString："+mapp.get("姓名"));
        }
        if(maps.get(0).get("姓名").equals("袁杰")){
            //通过数组的下标及key得到map的value值
            System.out.println("Service中的判断："+maps.get(1).get("姓名"));
            return 1;
        }
        return 0;
    }
}
