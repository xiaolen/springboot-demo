package com.qin.util;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.net.URL;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/4 9:54
 */
public class MassageUtil {
    /**
     * 调用短信接口
     * @param phone
     * @return
     */
    public String getMassage(String phone) {
        String pageUrl = "http://192.168.1.185:14567/api/access/verifyCode/";
        try {
            //创建对象HttpClient
            HttpClient httpclient = new HttpClient();
            //创建Get请求对象
            GetMethod get = new GetMethod(pageUrl + phone);
            //发送get请求
            int i = httpclient.executeMethod(get);
//            处理 HTTP 响应内容
//            HTTP响应头部信息，这里简单打印
            if (i == 200) {
//                Header[] headers = get.getResponseHeaders();
//                for (Header h : headers) {
//                System.out.println(h.getName() + "------------ " + h.getValue());
                // 读取 HTTP 响应内容，这里简单打印网页内容
                byte[] responseBody = get.getResponseBody();// 读取为字节数组
                String response = new String(responseBody);
                System.out.println("----------response:" + response);
                return response;
            }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
