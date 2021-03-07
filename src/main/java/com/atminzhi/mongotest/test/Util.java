package com.atminzhi.mongotest.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Random;
import java.util.UUID;

public class Util {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        System.out.println("=============");
        long l = System.currentTimeMillis();
        System.out.println(l);
        System.out.println("=============");
        Random random = new Random();
        int i = random.nextInt(9999);
        System.out.println(i);

        String yuanjie [] = new String[3];
        Integer nom [] = new Integer[] {1,2,3,};
        for (int j = 0; j <nom.length ; j++) {
            System.out.print("循环nom数组："+nom[j]);
        }
    }
}
