package com.atminzhi.mongotest.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestPlus {
    private String _id;
    private List<String> name;
    private String age;
    private String ssex;
    private List<String> monthlysalary ;
    private String height;
    private Hobby hobby ;
}
