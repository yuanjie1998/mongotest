package com.atminzhi.mongotest.entity.enums;
/*
测试数据库的枚举类(一个字段的所有状态的列表)
 */
public enum MongoStatusEnum {
    SUCCESS_INFO("0","数据新增成功！"),
    ERROR_INFO("1","数据新增失败！");

    private String mongoTatusCode;
    private String mongoTatusDescribe;
    //需要构造函数
    MongoStatusEnum(String mongoTatusCode, String mongoTatusDescribe) {
        this.mongoTatusCode = mongoTatusCode;
        this.mongoTatusDescribe = mongoTatusDescribe;
    }

    public String getMongoTatusCode() {
        return mongoTatusCode;
    }

    public String getMongoTatusDescribe() {
        return mongoTatusDescribe;
    }
}
