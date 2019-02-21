package com.qin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: 秦渊渊
 * @Date: 2018/11/27 19:51
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//定时任务
@EnableScheduling
//@EnableEurekaClient
public class DataprossApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataprossApplication.class, args);

    }
}
