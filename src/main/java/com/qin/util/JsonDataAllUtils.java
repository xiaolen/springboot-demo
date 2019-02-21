package com.qin.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j;

/**
 * @Author: 秦渊渊
 * @Date: 2019/2/13 10:45
 */
public class JsonDataAllUtils {
    /**
     * 获取json数据
     * @return
     */
    public static String getDataJsonArray(String jsonObject, String key){
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
        }
        return null;
    }


    /**
     * 获取json数据
     * @return
     */
    public static String getData(JSONObject jsonObject, String key){
        try {
            if(jsonObject != null && key != null){
                String dataValue = jsonObject.get(key).toString();
                return dataValue;
            }
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * 获取json数据
     * @return
     */
    public static JSONObject getDataJson(JSONObject jsonObject,String key){
        try {
            if (jsonObject != null && key != null){
                String dataValue = jsonObject.get(key).toString();
                return getJsonObject(dataValue);
            }
        } catch (Exception ex) {
        }
        return null;
    }
    /**
     * 将字符串转换成json对象
     * @param data
     * @return
     */
    public static JSONObject getJsonObject(String data){
        try {
            if(data != null){
                JSONObject jsonObject = JSONObject.parseObject(data);
                return jsonObject;
            }
        } catch (Exception ex) {
        }
        return null;
    }
}
