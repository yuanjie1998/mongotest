package com.atminzhi.mongotest.test;

import com.google.common.collect.Maps;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.List;

/*
测试循环
 */
public class map {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "abc");
        map.put(4, "abd");
        map.put(5, "abe");// 和上面相同 ， 会自己筛选
        System.out.println(map.size());
        System.out.println(map.get(3));
        System.out.println("-----------------");
        System.out.println("第一种：通过Map.keySet遍历key和value：");
        for (Integer in : map.keySet()) {
            //map.keySet()返回的是所有key的值
            String str = map.get(in);//得到每个key多对用value的值
            System.out.println(in + "     " + str);
        }
        System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        java.util.List<String> list = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            String value = entry.getValue();
            list.add(value);

            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        System.out.println("************获取的value值："+list);

        // 第三种：推荐，尤其是容量大时
        System.out.println("第三种：通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
        }
        System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
        System.out.println("list集合============");
        List<String> list1 = new ArrayList<>();
        list1.add("袁杰1");
        list1.add("袁杰2");
        list1.add("袁杰3");
        list1.add("袁杰4");
//       for (int i = 0;i<list.size();i++){
//           System.out.println(list.get(i));
//       }
        System.out.println(list1);
        System.out.println("map集合============");
       Map<String,Object> map1 = Maps.newHashMap();
       map1.put("1","袁杰1");
        map1.put("2","袁杰2");
        map1.put("3","袁杰3");
        map1.put("4","袁杰4");
        map1.put("5","袁杰5");
        for (String aaa: map1.keySet()) {
            Object o = map1.get(aaa);
            System.out.println("key:"+aaa+"===="+"value:"+o);

        }
    }

}
