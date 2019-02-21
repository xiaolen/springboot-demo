package com.qin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/1 13:05
 */
@Controller
@RequestMapping("/api")
public class JsonObjectController {
    private int count = 0;
    @RequestMapping("/json")
    @ResponseBody
    public String JsonObject(){

        System.out.println("定时刷新任务记录..."+ (count++));
        return "1";
    }

}
