package com.atminzhi.mongotest.test;

import lombok.Data;

@Data
public final class Animal<T> {
    private int age;
    private String name;
    private Double height;
    private T bode;

    public Animal(int age, String name, Double height, T bode) {
        this.age = age;
        this.name = name;
        this.height = height;
        this.bode = bode;
    }

    public Animal() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public T getBode() {
        return bode;
    }

    public void setBode(T bode) {
        this.bode = bode;
    }
}
