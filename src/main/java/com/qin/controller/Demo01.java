package com.qin.controller;

import com.qin.entity.DemoEntity;
import com.qin.entity.MonthData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
 * @Author: 秦渊渊
 * @Date: 2018/12/22 12:36
 */
public class Demo01 {



    @Test
    public void saveData() {
        DemoEntity demoEntity = new DemoEntity();
        MonthData monthData1 = new MonthData();
        int j = 0;
        int a =1;
        if (j == 0) {
            for (int i = 0; i < 3; i++) {

                monthData1.setMonth("1111");
                monthData1.setData("1111");
                demoEntity.getMonthDataList().add(monthData1);
            }
        }
        if (a == 1){
                for (int k = 0; k < 3; k++) {
                    monthData1.setMonth("2222");
                    monthData1.setData("2222");
                    demoEntity.getQitaDataList().add(monthData1);

                }
        }

        for (MonthData monthData11 : demoEntity.getMonthDataList()){
            System.out.println(monthData11.hashCode());
        }
//        System.out.println(demoEntity.getMonthDataList());
//        System.out.println(demoEntity.getQitaDataList());
    }
}
