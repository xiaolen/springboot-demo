package com.qin.test;

import com.qin.util.MassageUtil;
import org.junit.Test;

/**
 * @Author: 秦晓渊
        * @Date: 2018/12/4 11:12
        */
public class TestMassage {
    @Test
    public void testMassage() {
        String phone ="18235139875";
        //massage工具类
        MassageUtil massageUtil = new MassageUtil();
        String smsCode = massageUtil.getMassage(phone);
        System.out.println(smsCode + "获取短信验证码=============================================");
    }
}
