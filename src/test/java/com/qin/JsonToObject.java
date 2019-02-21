package com.qin;

import com.alibaba.fastjson.JSONObject;
import com.qin.entity.User;
import org.junit.Test;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/11 17:31
 */
public class JsonToObject {


    @Test
    public void jsonObject(){

        User user = new User();

        user.setUsername("张三");
        user.setPassword("1425869");

        JSONObject json = (JSONObject) JSONObject.toJSON(user);

        System.out.println(json);

    }

}
