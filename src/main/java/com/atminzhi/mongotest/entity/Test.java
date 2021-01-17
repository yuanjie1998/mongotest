package com.atminzhi.mongotest.entity;

import lombok.Data;

@Data
public class Test {
    private String _id;
    private String name;
    private Double age;
    private String ssex;
    private Double monthlysalary;
    private Double height;

//    public test() {
//    }
//
//    public test(String _id, String name, Double age, String ssex, Double monthlysalary, Double height) {
//        this._id = _id;
//        this.name = name;
//        this.age = age;
//        this.ssex = ssex;
//        this.monthlysalary = monthlysalary;
//        this.height = height;
//    }
//
//    public String get_id() {
//        return _id;
//    }
//
//    public void set_id(String _id) {
//        this._id = _id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getAge() {
//        return age;
//    }
//
//    public void setAge(Double age) {
//        this.age = age;
//    }
//
//    public String getSsex() {
//        return ssex;
//    }
//
//    public void setSsex(String ssex) {
//        this.ssex = ssex;
//    }
//
//    public Double getMonthlysalary() {
//        return monthlysalary;
//    }
//
//    public void setMonthlysalary(Double monthlysalary) {
//        this.monthlysalary = monthlysalary;
//    }
//
//    public Double getHeight() {
//        return height;
//    }
//
//    public void setHeight(Double height) {
//        this.height = height;
//    }
//
//    @Override
//    public String toString() {
//        return "test{" +
//                "_id='" + _id + '\'' +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", ssex='" + ssex + '\'' +
//                ", monthlysalary=" + monthlysalary +
//                ", height=" + height +
//                '}';
//    }
}
