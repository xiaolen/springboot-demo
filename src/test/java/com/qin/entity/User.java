package com.qin.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/11 17:32
 */

@Getter
@Setter
public class User {

    private String username;
    private String password;


    // create by build json plugin
    public JSONObject toJson() {
        JSONObject jo = new JSONObject();
        jo.put("username", username);
        jo.put("password", password);
        return jo;
    }

    @Override
    public String toString() {
        return toJson().toString();
    }
}
