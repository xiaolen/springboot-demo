package com.qin;


import com.alibaba.fastjson.JSONObject;
import com.qin.entity.User;
import org.junit.Test;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/11 17:39
 */
public class JsonToObject01 {



    @Test
    public void jsonObject(){

        User user = new User();

        user.setUsername("张三");
        user.setPassword("1425869");


        //对象转json
        JSONObject jsonObject = user.toJson();

        //json转对象
        User user1 = JSONObject.toJavaObject(jsonObject,User.class);

        System.out.println(user1.getPassword());

    }
}
