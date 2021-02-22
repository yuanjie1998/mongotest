package com.atminzhi.mongotest.test;

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
    }
}
