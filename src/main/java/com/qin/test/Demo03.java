package com.qin.test;

import org.junit.Test;
import org.springframework.data.domain.Page;

import java.util.*;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/27 16:22
 */
public class Demo03 {
    private Map<String, List<Page>> contentPagesMap = new HashMap();

    @Test
    public void test01() {

        List list = new ArrayList();
        List list1 = new ArrayList();
        list.add(010101);
        list.add(020202);
        list.add(030303);
        list.add(040404);
        list.add(050505);
        contentPagesMap.put("q", list);
        list1.add(030303);
        list1.add(040404);
        list1.add(050505);
        contentPagesMap.put("w", list1);
        System.out.println(contentPagesMap);

    }

    @Test
    public void test02() {

//        System.out.println(Math.random());
//
//        System.out.println(new Random().nextDouble());

        Double i = Double.valueOf("85")/20.00;
        float number = 21 % 20;
//        System.out.println(i);
        System.out.println(Math.ceil(i));
        int renewNum = (int)Math.ceil(number);
//        System.out.println(renewNum);

    }

    @Test
    public void test03() {

        String arr[] = new String[3];
        arr[0] = "<!--列表标题--><th>序号</th><th>上网区域</th><th>主叫号码</th><th>登录帐户</th><th>开始时间</th><th>时长</th><th>流量</th><th>费用(元)</th><th>话单类型</th><th>网络类型</th><th>上网地</th><th>使用业务</th>";

        arr[1] = "<td>1</td><td>国内</td><td>18942577652</td><td>ctwap@mycdma.cn</td><td>2018-12-1517:19:41</td><td>12秒</td><td>15KB</td><td>0</td><td>手机上网</td><td>CDMA1X</td><td>太原</td><td>其他</td>";

        arr[2] = "<td>2</td><td>国内</td><td>18942577652</td><td>ctwap@mycdma.cn</td><td>2018-12-2016:14:07</td><td>11秒</td><td>15KB</td><td>0</td><td>手机上网</td><td>CDMA1X</td><td>太原</td><td>其他</td>";

        for (String tr : arr) {
            if (!tr.contains("<th>")) {
                tr = tr.replaceAll("<td(.*?)>", "");
                String[] tds = tr.split("</td>");

                for (int i = 0; i < tds.length; i++) {
                    System.out.println(tds[i]+"==="+i);
                }

                List<String> strings = Arrays.asList(tds.toString().replaceAll(" ", ""));
                if (tds.length > 7) {
//                    cndi = new CarrierNetDetailInfo();
//                                    cndi.setMappingId(ci.getMappingId());//映射id
                    StringBuilder startDateNew;
                    if (tds[1].trim().length() > 20) {
                        System.out.println(tds[1]+"=============");
                        startDateNew = new StringBuilder(tds[1].trim().substring(10, tds[1].length()));
//                        流量使用时间
//                        cndi.setTime(startDateNew.insert(10, " ").toString());
//
                    } else {
                        startDateNew = new StringBuilder(tds[1].trim());
//                        流量使用时间
//                        cndi.setTime(startDateNew.insert(10, " ").toString());
                    }

                }
            }
        }


        System.out.println(Arrays.asList(arr));

    }
}
