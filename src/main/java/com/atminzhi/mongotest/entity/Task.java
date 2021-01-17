package com.atminzhi.mongotest.entity;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @Auther: ljg
 * @Date: 2020/10/27 09:49
 * @Description: 任务表   (利用插件进行编译lombok)
 */
@Data
public class Task {
    private String _id;    //主键id
    private String taskNo; //任务编号
    private String title;  //标题
    private Set<String> assignList;//分配人列表list
    private String assignedUser;    //被分配人
    private String assignTime;      //分配时间,用于筛选 分配人列表
    private Set<String> execUser;   //执行人列表
    private Integer acceptStatus;   //接受状态 0 待接收 1 已接受 2已拒绝
    private String  acceptTime;     //接受时间
    private String expectedStartTime; //期望开始时间
    private String expectedEndTime;   //期望结束时间
    private String startTime;       //开始时间
    private String endTime;         //结束时间
    private String actualStartTime; //实际开始时间
    private String actualEndTime;   //实际结束时间
    private Integer isHasSubtask;   //是否拥有子任务 0没有 1拥有
    private Set<String> checkUsers; //验收人
    private String describe;        //任务描述
    private TaskPriority priority;  //优先级
    private List<TaskTag> tags;     //任务标签
    private Integer taskStatus;     //任务状态
    private String flowStatus;      //流程状态
    private String parentId;        //父任务id 大任务统一为"0"
    private Set<String> partUsers;  //参与人: 创建人，接收人，验收人，
    private String projectId;       //项目id
    private String productId;       //产品id
    private String createUser;      //创建人
    private String createTime;      //创建时间
    private Long outTimes;          //逾期时间时间搓
    private String outTimeString;   //解析后逾期时间
    private Integer outTimeStatus;  //逾期状态  0 未定义  1 已逾期任务  2 未逾期任务
    private Integer outTimeDay;     //逾期天数
    private Integer level;          //任务层级 1 2 3 分别对应相应层级
    private String levelCode;       //层级   parentTask123,subTask123,sunTask123
}
