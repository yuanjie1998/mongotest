package com.atminzhi.mongotest.entity;

import lombok.Data;

/**
 * @Auther: ljg
 * @Date: 2020/10/27 09:45
 * @Description:
 */
//任务优先级实体
@Data
public class TaskPriority {
    // private String _id;
    // private String priorityKey;
    // private String PriorityValue;
    // private String PriorityColor;
    private String  name;
    private String  value;
    private String  color;
}
