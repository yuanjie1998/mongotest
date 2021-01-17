package com.atminzhi.mongotest;

import com.atminzhi.mongotest.controller.TestController;
import com.atminzhi.mongotest.controller.YuanJieController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongotestApplicationTests {
    @Autowired
    YuanJieController yuanJieController;
    @Autowired
    TestController testController;

    @Test
    void contextLoads() {
    }
    @Test
    public void getAll(){
        System.out.println("kkkkk");
        testController.findUserByName();
    }

}
