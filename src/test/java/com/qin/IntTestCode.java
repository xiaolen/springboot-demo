package com.qin;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/10 20:15
 */
public class IntTestCode {

    @Test
    public void intCode(){

        List<Integer> list = new ArrayList();

        int a = 56855255;
        long startTime = System.currentTimeMillis();
        for (int i =0;i<100000000;i++){
            list.add(i);
        }
        long start = System.currentTimeMillis();

        System.out.println(start+startTime+"添加数据所用时间");
        long startTime01 = System.currentTimeMillis();
        if (list.contains(a)){
            System.out.println(a+"存在");
        }
        long end = System.currentTimeMillis();
        long use = end - startTime01;
        System.out.println(use + "查找所用时间");

//        for (Integer ii : list ) {
//            if(a == ii){
//                System.out.println(a+"存在");
//            }
//            System.out.println(ii+"集合数据");
//        }
    }

}
