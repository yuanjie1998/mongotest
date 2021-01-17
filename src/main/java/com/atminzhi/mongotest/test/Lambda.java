package com.atminzhi.mongotest.test;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
java中的箭头语法
 */
public class Lambda {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        System.out.println(f.apply(1));

        BiFunction<Integer, Integer, Integer> g = (x, y) -> x + y;
        System.out.println(g.apply(1, 2));
    }
}
