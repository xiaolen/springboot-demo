package com.qin.entity;


import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/22 11:35
 */

@Data
@Component
public class DemoEntity {

    private List<MonthData> monthDataList = new ArrayList<>();

    private List<MonthData> qitaDataList = new ArrayList<>();
}
