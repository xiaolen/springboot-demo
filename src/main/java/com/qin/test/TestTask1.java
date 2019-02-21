package com.qin.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;


/**
 * @Author: 秦渊渊
 * @Date: 2018/12/1 13:05
 */
@Component
public class TestTask1 {
    private int count = 0;

    //定时任务注解详细查看注解参数
    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        Date date = new Date();
        try {
            Thread.sleep(100L);
//            System.out.println(date + "[" + Thread.currentThread().getName() + "]" + "this is scheduler task runing  " + (count++));
            String path = "http://localhost:8993/api/json";
            //创建对象HttpClient
            HttpClient httpclient = new HttpClient();
            //创建Get请求对象
            GetMethod get = new GetMethod(path);
            //发送get请求
            int st1 = httpclient.executeMethod(get);
            System.out.println(st1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
