package com.qin.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: 秦渊渊
 * @Date: 2019/2/13 10:27
 */
@Slf4j
public class Demo04 {


    @Test
    public void DataJson(){

        String data = "{\n" +
                "    \"code\": \"0000\",\n" +
                "    \"message\": \"查询成功！\",\n" +
                "    \"searchCount\": [{\n" +
                "        \"count\": 85,\n" +
                "        \"listSum\": \"\",\n" +
                "        \"listType\": \"\",\n" +
                "        \"listTypeId\": \"2\"\n" +
                "    }],\n" +
                "    \"searchItems\": [{\n" +
                "        \"collectColArr\": \"\",\n" +
                "        \"collectOfferCheap\": \"\",\n" +
                "        \"collectRateFlow\": \"\",\n" +
                "        \"collectRateTime\": \"\",\n" +
                "        \"data\": [\"2018-12-15\", \"1|2018-12-15 14:33:51|主叫|035110000|16秒|太原|0.0|国内通话\", \"2|2018-12-15 14:34:13|主叫|035110000|2分9秒|太原|0.0|国内通话\", \"3|2018-12-15 17:20:38|主叫|15735655149|10秒|太原|0.0|国内通话\", \"2018-12-18\", \"4|2018-12-18 14:03:13|主叫|13730027947|38秒|太原|0.0|国内通话\", \"5|2018-12-18 14:16:20|主叫|18213465176|41秒|太原|0.0|国内通话\", \"6|2018-12-18 14:17:13|主叫|13422413501|44秒|太原|0.0|国内通话\", \"7|2018-12-18 14:18:26|主叫|18429012553|47秒|太原|0.0|国内通话\", \"8|2018-12-18 14:21:01|主叫|18328547065|46秒|太原|0.0|国内通话\", \"9|2018-12-18 14:22:50|主叫|15865260246|50秒|太原|0.0|国内通话\", \"10|2018-12-18 14:24:07|主叫|18250089362|36秒|太原|0.0|国内通话\", \"11|2018-12-18 14:26:21|主叫|15022500139|42秒|太原|0.0|国内通话\", \"12|2018-12-18 14:28:33|主叫|13648643068|45秒|太原|0.0|国内通话\", \"13|2018-12-18 14:29:53|主叫|15754961407|45秒|太原|0.0|国内通话\", \"14|2018-12-18 14:31:20|主叫|13545113261|50秒|太原|0.0|国内通话\", \"15|2018-12-18 14:33:29|主叫|17872037295|38秒|太原|0.0|国内通话\", \"16|2018-12-18 14:35:27|主叫|13627675205|37秒|太原|0.0|国内通话\", \"17|2018-12-18 14:43:35|主叫|15246745040|48秒|太原|0.0|国内通话\", \"18|2018-12-18 14:44:33|主叫|15739330698|40秒|太原|0.0|国内通话\", \"19|2018-12-18 14:45:23|主叫|18294958853|43秒|太原|0.0|国内通话\", \"20|2018-12-18 14:46:18|主叫|15109505328|30秒|太原|0.0|国内通话\"],\n" +
                "        \"fildname\": [\"序号\", \"通话时间\", \"类型\", \"对方号码\", \"时长\", \"通话地区\", \"费用(元)\", \"话单类型\"],\n" +
                "        \"listType\": \"移动语音清单\",\n" +
                "        \"listTypeId\": \"2\",\n" +
                "        \"offerCheapTotle\": \"\",\n" +
                "        \"rateFlowTotle\": \"\",\n" +
                "        \"rateTimeTotle\": \"\"\n" +
                "    }],\n" +
                "    \"searchSum\": [{\n" +
                "        \"accNum\": \"18942577652\",\n" +
                "        \"listRType\": \"2\",\n" +
                "        \"totalAmount\": \"0.0\",\n" +
                "        \"totalCnt\": \"85\"\n" +
                "    }]\n" +
                "}";

        JSONObject jsonObject = getJsonObject(data);
//        System.out.println(jsonObject);
        String searchSum = getData(jsonObject, "searchSum");
//        System.out.println(searchSum);
        String totalCnt = getDataJsonArray(searchSum, "totalCnt");
        System.out.println(totalCnt);

    }
    /**
     * 获取json数据
     * @return
     */
    public String getDataJsonArray(String jsonObject, String key){
        try {
            if(jsonObject != null && key != null){
                JSONArray jsonArray = (JSONArray) JSONArray.parse(jsonObject);
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject json = (JSONObject) jsonArray.get(i);
                    String dataValue = getData(json, key);
                    return dataValue;
                }
                return null;
            }
        } catch (Exception ex) {
            log.error("bean转化为json失败", ex);
        }
        return null;
    }


    /**
     * 获取json数据
     * @return
     */
    public String getData(JSONObject jsonObject, String key){
        try {
            if(jsonObject != null && key != null){
                String dataValue = jsonObject.get(key).toString();
                return dataValue;
            }
        } catch (Exception ex) {
            log.error("bean转化为json失败", ex);
        }
        return null;
    }

    /**
     * 获取json数据
     * @return
     */
    public JSONObject getDataJson(JSONObject jsonObject,String key){
        try {
            if (jsonObject != null && key != null){
                String dataValue = jsonObject.get(key).toString();
                return getJsonObject(dataValue);
            }
        } catch (Exception ex) {
            log.error("bean转化为json失败", ex);
        }
        return null;
    }
    /**
     * 将字符串转换成json对象
     * @param data
     * @return
     */
    public JSONObject getJsonObject(String data){
        try {
            if(data != null){
                JSONObject jsonObject = JSONObject.parseObject(data);
                return jsonObject;
            }
        } catch (Exception ex) {
            log.error("bean转化为json失败", ex);
        }
        return null;
    }
}
