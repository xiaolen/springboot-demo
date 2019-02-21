package com.qin.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/18 17:30
 */
public class StringSplic {

    public static void main(String[] args) {
//        String page = "\n" +
//                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "<script>\n" +
//                "\tvar CMSbase = \"http://hn.189.cn:80/bussiness\";\n" +
//                "\tvar CMSPath = \"http://hn.189.cn:80/bussiness/cms/content/view?\";\t\n" +
//                "\tvar webRootPath = \"\";\n" +
//                "\tvar czPath = \"http://hn.189.cn:80/\";\n" +
//                "</script>\n" +
//                "\n" +
//                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
//                "    <head>\n" +
//                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
//                "        <meta content=\"\" name=\"description\" />\n" +
//                "        <meta content=\"\" name=\"keywords\" />\n" +
//                "\t\t<title>请稍等</title> \n" +
//                "  \t\t\n" +
//                " \n" +
//                "</head>\n" +
//                "<body> \n" +
//                " \n" +
//                "\t\n" +
//                "<form id=\"redisSession\" action=\"http://hn.189.cn/nself/login/sso\" method=\"post\">\n" +
//                "\t<input type=\"hidden\" name=\"operation\" value=\"\"/> \n" +
//                "\t<input type=\"hidden\" name=\"ssoToken\" value=\"D07E336806BE4CC7B2AD9BB94DEF27E6\"/> \n" +
//                "\t<input type=\"hidden\" name=\"loginState\" value=\"true\"/> \n" +
//                "\t<input type=\"hidden\" name=\"operationType\" value=\"\"/> \n" +
//                "\t<input type=\"hidden\" name=\"channelId\" value=\"\"/>  \n" +
//                "\t<input type=\"hidden\" name=\"rUrl\" value=\"http://hn.189.cn/nself/self/billquery/qryRealTimePati\"/> \n" +
//                "\t\n" +
//                "</form>\t\t  \n" +
//                " \n" +
//                "</body>\n" +
//                "<script type=\"text/javascript\">\n" +
//                "\t\t/* $(document).ready(function(){\n" +
//                "\t\t\t$(\"#redisSession\").submit();\n" +
//                "\t\t}); */\n" +
//                "\t\t  document.getElementById(\"redisSession\").submit();\n" +
//                "\t</script>\n" +
//                "</html>\n";
//

//        String[] split = page.split("<input");
//        System.out.println(split[2]);
//        String[] split1 = split[2].split("value=\"");
//        System.out.println(split1[1]);
//        String replace = split1[1].replace("\"/>", "");
//        System.out.println(replace);

        String ssss = "0. 总记录数：50总页数：3当前页：1首页上一页下一页尾页";

        String s = ssss.replaceAll("\\s*|\t|\r|\n", "");
        System.out.println(s);


    }


    @Test
    public void test01(){
        String options[] = {"2","4","8","9","12","13","14"};
        for (int j = 0; j < options.length; j++) {
            if(options[j].equals("2")){
                System.out.println(options[j]);
            }
        }
    }
    @Test
    public void test02(){
        String ssss = "0. 总记录数：50总页数：3当前页：1首页上一页下一页尾页";
        String s = ssss.replaceAll("\\s*|\t|\r|\n", "");
        String[] split = s.split("总页数：");
        String[] strings = split[1].split("当前页");
        System.out.println(strings[0]);
    }
}
