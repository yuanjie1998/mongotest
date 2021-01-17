package com.atminzhi.mongotest.Service;

import com.atminzhi.mongotest.entity.Test;


public interface TestService {
    public void saveUser(Test test);    //新增数据
    public void removeUser();    //通过名字删除数据
    public Test findUserByName();    //通过名字查找数据
    public int updateUser();           //修改数据

}
