package com.atminzhi.mongotest.entity;

import lombok.Data;

/**
 * @Auther: ljg
 * @Date: 2020/10/27 09:47
 * @Description:
 * 任务标签实体类
 */
@Data
public class TaskTag {
    //private String _id;
    private String  name;
    private String  value;
    private String  color;
}
