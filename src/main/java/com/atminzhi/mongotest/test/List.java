package com.atminzhi.mongotest.test;


import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author yuan jie
 * @Date 2021/3/5 17:15
 */
public class List {
    /**
     * list集合去重
     * @param args
     */
    public static void main(String[] args) {
        java.util.List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.forEach(System.out::print);
        System.out.println("--------------------");
        //list集合去重转成流，并由流转集合，流只能使用一次
        java.util.List<String> collect1 = list.stream().distinct().collect(Collectors.toList());
        collect1.forEach(System.out::print);

    }
}
