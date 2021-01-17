package com.atminzhi.mongotest.Service;


import com.atminzhi.mongotest.entity.Task;

import java.util.List;

public interface TestTask {
    //查询task任务列表所有数据
    List<Task> getAllTask();
}
