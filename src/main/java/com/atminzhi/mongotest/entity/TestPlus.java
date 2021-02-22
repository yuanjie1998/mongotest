package com.atminzhi.mongotest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPlus {
    private String _id;
    private List<String> name;
    private String age;
    private String ssex;
    private List<String> monthlysalary ;
    private String height;
    private Hobby hobby ;

    //@Transient 建实体类的时候，有时候实体类的属性和数据库表字段不一致，比如多一个属性，那不加这个注解就会报错,数据库中不会新增此字段
    @Transient
    private String color;

}
