package com.qin.test;

import com.alibaba.fastjson.JSONObject;
import com.qin.util.JsonDataAllUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/12 13:58
 */
public class Demo02 {

    final static String salutation = "Hello! ";

//    public static void main(String args[]) {
//        GreetingService greetService1 = message ->
//                System.out.println(salutation + message);
//        greetService1.sayMessage("Runoob");
//    }

    interface GreetingService {
        void sayMessage(String message);
    }


    @Test
    public void demo01() {
        String ddd = "{\n" +
                "\t\"code\": \"0000\",\n" +
                "\t\"message\": \"查询成功！\",\n" +
                "\t\"searchItems\": [{\n" +
                "\t\t\"collectColArr\": \"\",\n" +
                "\t\t\"collectOfferCheap\": \"\",\n" +
                "\t\t\"collectRateFlow\": \"\",\n" +
                "\t\t\"collectRateTime\": \"\",\n" +
                "\t\t\"data\": [\"2018-12-20\", \"41|2018-12-20 10:38:53|被叫|15739330698|35秒|太原|0.0|国内通话\", \"42|2018-12-20 10:39:37|被叫|18294958853|42秒|太原|0.0|国内通话\", \"43|2018-12-20 10:40:28|被叫|18649519875|42秒|太原|0.0|国内通话\", \"44|2018-12-20 10:41:19|被叫|13817610984|48秒|太原|0.0|国内通话\", \"45|2018-12-20 10:42:16|被叫|15109505328|45秒|太原|0.0|国内通话\", \"46|2018-12-20 10:43:10|被叫|13557833234|43秒|太原|0.0|国内通话\", \"47|2018-12-20 10:44:00|被叫|18211732523|30秒|太原|0.0|国内通话\", \"48|2018-12-20 10:44:39|被叫|15209705476|48秒|太原|0.0|国内通话\", \"49|2018-12-20 10:45:35|被叫|17880166493|45秒|太原|0.0|国内通话\", \"50|2018-12-20 10:46:29|被叫|15841660347|43秒|太原|0.0|国内通话\", \"2018-12-22\", \"51|2018-12-22 09:34:04|被叫|13730027947|44秒|太原|0.0|国内通话\", \"52|2018-12-22 09:36:53|被叫|18213465176|39秒|太原|0.0|国内通话\", \"53|2018-12-22 09:46:24|被叫|18429012553|36秒|太原|0.0|国内通话\", \"54|2018-12-22 09:47:35|被叫|18328547065|35秒|太原|0.0|国内通话\", \"55|2018-12-22 09:49:49|被叫|15865260246|38秒|太原|0.0|国内通话\", \"56|2018-12-22 09:50:46|被叫|18250089362|36秒|太原|0.0|国内通话\", \"57|2018-12-22 09:51:32|被叫|15022500139|35秒|太原|0.0|国内通话\", \"58|2018-12-22 09:52:30|被叫|13648643068|36秒|太原|0.0|国内通话\", \"59|2018-12-22 09:54:07|被叫|15754961407|40秒|太原|0.0|国内通话\", \"60|2018-12-22 10:04:07|被叫|17872037295|42秒|太原|0.0|国内通话\"],\n" +
                "\t\t\"fildname\": [\"序号\", \"通话时间\", \"类型\", \"对方号码\", \"时长\", \"通话地区\", \"费用(元)\", \"话单类型\"],\n" +
                "\t\t\"listType\": \"移动语音清单\",\n" +
                "\t\t\"listTypeId\": \"2\",\n" +
                "\t\t\"offerCheapTotle\": \"\",\n" +
                "\t\t\"rateFlowTotle\": \"\",\n" +
                "\t\t\"rateTimeTotle\": \"\"\n" +
                "\t}]\n" +
                "}";
        JSONObject jsStr = JSONObject.parseObject(ddd);
        String searchItems = JsonDataAllUtils.getData(jsStr, "searchItems");
        String substring = searchItems.substring(1, searchItems.length() - 1);

        String data = JsonDataAllUtils.getData(JsonDataAllUtils.getJsonObject(substring), "data");

        String substring1 = data.substring(1, data.length() - 1);
        String[] splitdd = substring1.split(",");
        for (int i = 0; i < splitdd.length; i++) {
            if(splitdd[i].contains("|")) {
                String[] split = splitdd[i].replaceAll("\"","").split("\\|");
                System.out.println(splitdd[i]);
//                for (int j = 0; j < split.length; j++) {
//                    System.out.println(split[j]+"=====");
//                }
            }
        }

    }
    @Test
    public void demo04() {
        String ddd = "{\n" +
                "\t\"code\": \"0000\",\n" +
                "\t\"message\": \"查询成功！\",\n" +
                "\t\"searchCount\": [{\n" +
                "\t\t\"count\": 10,\n" +
                "\t\t\"listSum\": \"\",\n" +
                "\t\t\"listType\": \"\",\n" +
                "\t\t\"listTypeId\": \"12\"\n" +
                "\t}],\n" +
                "\t\"searchItems\": [{\n" +
                "\t\t\"collectColArr\": \"\",\n" +
                "\t\t\"collectOfferCheap\": \"\",\n" +
                "\t\t\"collectRateFlow\": \"\",\n" +
                "\t\t\"collectRateTime\": \"\",\n" +
                "\t\t\"data\": [\"1|2019-02-01 09:01:34|国内发|18942577652|18007121506|0.1|网内短信|140081\", \"2|2019-02-02 09:19:42|国内发|18942577652|18007121506|0.1|网内短信|140081\", \"3|2019-02-11 09:28:04|国内发|18942577652|18007121506|0.1|网内短信|140081\", \"4|2019-02-12 08:49:44|国内发|18942577652|18007121506|0.1|网内短信|140081\", \"5|2019-02-14 08:49:03|国内发|18942577652|18007121506|0.1|网内短信|140081\", \"6|2019-02-15 09:02:18|国内发|18942577652|18007121506|0.1|网内短信|140081\", \"7|2019-02-16 09:00:41|国内发|18942577652|18007121506|0.1|网内短信|140081\", \"8|2019-02-16 09:01:23|国内发|18942577652|18007121506|0.1|网内短信|140081\", \"9|2019-02-16 09:01:30|国内发|18942577652|18007121506|0.1|网内短信|140081\", \"10|2019-02-18 08:56:58|国内发|18942577652|18007121506|0.1|网内短信|140081\"],\n" +
                "\t\t\"fildname\": [\"序号\", \"发送开始时间\", \"收发类型\", \"本机号码\", \"对方号码\", \"费用(元)\", \"话单类型\", \"帐目类型\"],\n" +
                "\t\t\"listType\": \"短信彩信清单\",\n" +
                "\t\t\"listTypeId\": \"12\",\n" +
                "\t\t\"offerCheapTotle\": \"\",\n" +
                "\t\t\"rateFlowTotle\": \"\",\n" +
                "\t\t\"rateTimeTotle\": \"\"\n" +
                "\t}],\n" +
                "\t\"searchSum\": [{\n" +
                "\t\t\"accNum\": \"18942577652\",\n" +
                "\t\t\"listRType\": \"12\",\n" +
                "\t\t\"totalAmount\": \"0.9999999999999999\",\n" +
                "\t\t\"totalCnt\": \"10\"\n" +
                "\t}]\n" +
                "}";
        JSONObject jsStr = JSONObject.parseObject(ddd);
        String searchItems = JsonDataAllUtils.getData(jsStr, "searchItems");
        String substring = searchItems.substring(1, searchItems.length() - 1);

        String data = JsonDataAllUtils.getData(JsonDataAllUtils.getJsonObject(substring), "data");

        String substring1 = data.substring(1, data.length() - 1);
        String[] splitdd = substring1.split(",");
//        for (int i = 0; i < splitdd.length; i++) {
            if(splitdd[1].contains("|")) {
                String[] split = splitdd[1].replaceAll("\"","").split("\\|");
//                System.out.println(splitdd[i]);
                for (int j = 0; j < split.length; j++) {
                    System.out.println(split[j]+"=====");
                }
//            }
        }

    }
    @Test
    public void demo05() {
        String ddd = "{\n" +
                "\t\"code\": \"0000\",\n" +
                "\t\"message\": \"查询成功！\",\n" +
                "\t\"searchCount\": [{\n" +
                "\t\t\"count\": 0,\n" +
                "\t\t\"listSum\": \"\",\n" +
                "\t\t\"listType\": \"\",\n" +
                "\t\t\"listTypeId\": \"8\"\n" +
                "\t}, {\n" +
                "\t\t\"count\": 8,\n" +
                "\t\t\"listSum\": \"\",\n" +
                "\t\t\"listType\": \"\",\n" +
                "\t\t\"listTypeId\": \"13\"\n" +
                "\t}, {\n" +
                "\t\t\"count\": 0,\n" +
                "\t\t\"listSum\": \"\",\n" +
                "\t\t\"listType\": \"\",\n" +
                "\t\t\"listTypeId\": \"14\"\n" +
                "\t}],\n" +
                "\t\"searchItems\": [{\n" +
                "\t\t\"collectColArr\": \"\",\n" +
                "\t\t\"collectOfferCheap\": \"\",\n" +
                "\t\t\"collectRateFlow\": \"\",\n" +
                "\t\t\"collectRateTime\": \"\",\n" +
                "\t\t\"data\": [\"2018-12-15\", \"1|2018-12-15 16:58:19|18942577652|| ||0|0.0||SP短信|141000\", \"2018-12-17\", \"2|2018-12-17 14:08:00|18942577652|| ||0|0.0||SP短信|141000\", \"3|2018-12-17 16:27:37|18942577652|| ||0|0.0||SP短信|141000\", \"4|2018-12-17 17:01:30|18942577652|| ||0|0.0||SP短信|141000\", \"5|2018-12-17 17:06:07|18942577652|| ||0|0.0||SP短信|141000\", \"6|2018-12-17 17:08:23|18942577652|| ||0|0.0||SP短信|141000\", \"7|2018-12-17 17:20:33|18942577652|| ||0|0.0||SP短信|141000\", \"2018-12-26\", \"8|2018-12-26 12:47:06|18942577652|| ||0|0.0||SP短信|141000\"],\n" +
                "\t\t\"fildname\": [\"序号\", \"通信时间\", \"对方号码\", \"SP代码\", \"SP业务名称\", \"SP业务类型\", \"通信费(元)\", \"信息费(元)\", \"提供商\", \"话单类型\", \"帐目类型\"],\n" +
                "\t\t\"listType\": \"SP短信彩信清单\",\n" +
                "\t\t\"listTypeId\": \"13\",\n" +
                "\t\t\"offerCheapTotle\": \"\",\n" +
                "\t\t\"rateFlowTotle\": \"\",\n" +
                "\t\t\"rateTimeTotle\": \"\"\n" +
                "\t}],\n" +
                "\t\"searchSum\": [{\n" +
                "\t\t\"accNum\": \"18942577652\",\n" +
                "\t\t\"listRType\": \"8\",\n" +
                "\t\t\"totalAmount\": \"0.0\",\n" +
                "\t\t\"totalCnt\": \"0\"\n" +
                "\t}, {\n" +
                "\t\t\"accNum\": \"18942577652\",\n" +
                "\t\t\"listRType\": \"13\",\n" +
                "\t\t\"totalAmount\": \"0.0\",\n" +
                "\t\t\"totalCnt\": \"8\"\n" +
                "\t}, {\n" +
                "\t\t\"accNum\": \"18942577652\",\n" +
                "\t\t\"listRType\": \"14\",\n" +
                "\t\t\"totalAmount\": \"0.0\",\n" +
                "\t\t\"totalCnt\": \"0\"\n" +
                "\t}]\n" +
                "}";
        JSONObject jsStr = JSONObject.parseObject(ddd);
        String searchItems = JsonDataAllUtils.getData(jsStr, "searchItems");
        String substring = searchItems.substring(1, searchItems.length() - 1);

        String data = JsonDataAllUtils.getData(JsonDataAllUtils.getJsonObject(substring), "data");

        String substring1 = data.substring(1, data.length() - 1);
        String[] splitdd = substring1.split(",");
//        for (int i = 0; i < splitdd.length; i++) {
            if(splitdd[1].contains("|")) {
                String[] split = splitdd[1].replaceAll("\"","").split("\\|");
//                System.out.println(splitdd[i]);
                for (int j = 0; j < split.length; j++) {
                    System.out.println(split[j]+"=="+j+"===");
                }
//            }
        }

    }
    @Test
    public void demo06() {
        String ddd = "{\n" +
                "\t\"code\": \"0000\",\n" +
                "\t\"message\": \"查询成功！\",\n" +
                "\t\"searchCount\": [{\n" +
                "\t\t\"count\": 2,\n" +
                "\t\t\"listSum\": \"\",\n" +
                "\t\t\"listType\": \"\",\n" +
                "\t\t\"listTypeId\": \"9\"\n" +
                "\t}],\n" +
                "\t\"searchItems\": [{\n" +
                "\t\t\"collectColArr\": \"\",\n" +
                "\t\t\"collectOfferCheap\": \"\",\n" +
                "\t\t\"collectRateFlow\": \"\",\n" +
                "\t\t\"collectRateTime\": \"\",\n" +
                "\t\t\"data\": [\"2018-12-15\", \"1|省际漫游|18942577652|ctwap@mycdma.cn|2018-12-15 17:19:41|12秒|15KB|0.0|手机上网|CDMA1X|太原|其他\", \"2018-12-20\", \"2|省际漫游|18942577652|ctwap@mycdma.cn|2018-12-20 16:14:07|11秒|15KB|0.0|手机上网|CDMA1X|太原|其他\"],\n" +
                "\t\t\"fildname\": [\"序号\", \"上网区域\", \"主叫号码\", \"登录帐户\", \"开始时间\", \"时长\", \"流量\", \"费用(元)\", \"话单类型\", \"网络类型\", \"上网地\", \"使用业务\"],\n" +
                "\t\t\"listType\": \"移动数据清单\",\n" +
                "\t\t\"listTypeId\": \"9\",\n" +
                "\t\t\"offerCheapTotle\": \"\",\n" +
                "\t\t\"rateFlowTotle\": \"\",\n" +
                "\t\t\"rateTimeTotle\": \"\"\n" +
                "\t}],\n" +
                "\t\"searchSum\": [{\n" +
                "\t\t\"accNum\": \"18942577652\",\n" +
                "\t\t\"listRType\": \"9\",\n" +
                "\t\t\"totalAmount\": \"0.0\",\n" +
                "\t\t\"totalCnt\": \"30\"\n" +
                "\t}]\n" +
                "}";
        JSONObject jsStr = JSONObject.parseObject(ddd);
        String searchItems = JsonDataAllUtils.getData(jsStr, "searchItems");
        String substring = searchItems.substring(1, searchItems.length() - 1);

        String data = JsonDataAllUtils.getData(JsonDataAllUtils.getJsonObject(substring), "data");

        String substring1 = data.substring(1, data.length() - 1);
        String[] splitdd = substring1.split(",");
        for (int i = 0; i < splitdd.length; i++) {
            if(splitdd[i].contains("|")) {
                String[] split = splitdd[1].replaceAll("\"","").split("\\|");
                System.out.println(splitdd[i]);
//                for (int j = 0; j < split.length; j++) {
//                    System.out.println(split[j]+"=="+j+"===");
//                }
            }
        }

    }

}
