package com.qin.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qin.util.ExecuteScript;
import com.qin.util.JavaScriptUtils;
import com.qin.util.Methods;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: 秦渊渊
 * @Date: 2019/1/12 11:21
 */
public class Test03 {


    public static final String GBK = "GBK";

    @Test
    public void demo01() {
        String pwd = "gf0016";
//        String encryptPwd = JavaScriptUtils.invoker("js/BeiJingCmccShopEncrypt.js", "encryptStr","123321",key);
        String encryptPwd = JavaScriptUtils.invoker("js/helloJs.js", "individualSubmitForm", pwd);
        System.out.println(encryptPwd);
    }

    @Test
    public void jsMathod() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        String jsFileName = "D:\\wwp\\springboot\\src\\main\\resources\\js\\BeiJingCmccShopEncrypt.js";   // 读取js文件
        FileReader reader = new FileReader(jsFileName);   // 执行指定脚本
        engine.eval(reader);
        String pwd = "123456";
        if (engine instanceof Invocable) {
            Invocable invoke = (Invocable) engine;    // 调用merge方法，并传入两个参数
            Double c = (Double) invoke.invokeFunction(pwd);
            System.out.println("c = " + c);
        }
        reader.close();

    }

    @Test
    public void demo99() throws IOException {

        ExecuteScript executeScript = new ExecuteScript();
        String path = "D:\\wwp\\springboot\\src\\main\\resources\\js\\helloJs.js";
//        String fileLocation=path + "conwork.js";
        //通过下面一行代码就可以获取指定接口中方法的实例
        Methods method = executeScript.getMethod(path, Methods.class);
        String result = method.individualSubmitForm("123456");
        System.out.println(result);
    }

    @Test
    public void demo09() {

        String formData = "{\"_ACCNAME\":\"孙洪军\",\"_SENDTIME\":\"2019-01-23\",\"_PAGEID\":\"step1\",\"CURRENT_SYSTEM_DATE\":\"2019-01-23\",\"_DEPUTYIDCARDNUM\":\"220106198310091018\",\"_IS\":\"-5170589\",\"_UNITACCNAME\":\"北京平安盛世信息咨询有限公司秦皇岛分公司\",\"_SENDOPERID\":\"220106198310091018\",\"_ISCROP\":\"0\",\"_PORCNAME\":\"个人明细账查询\",\"_PROCID\":\"60020007\",\"_ACCNUM\":\"113659871510\",\"_BRANCHKIND\":\"0\",\"_SENDDATE\":\"2019-01-23\",\"_TYPE\":\"init\",\"_WITHKEY\":\"0\",\"$page\":\"/ydpx/60020007/602007_01.ydpx\",\"_LOGIP\":\"218.26.185.2\",\"_UNITACCNUM\":\"111004476680\",\"isSamePer\":\"true\"}";

        JSONObject jsonObject = JSONObject.parseObject(formData);

        System.out.println(formData);
        Object page = jsonObject.get("$page");
        System.out.println(page.toString());
    }

    @Test
    public void demo094() throws UnsupportedEncodingException {

        String formData = "{\"data\":{\"msg\":\"\\u6210\\u529f\",\"_ACCNUM\":\"113659871510\",\"Unitprop\":\"\",\"unitaccname\":\"\\u5317\\u4eac\\u5e73\\u5b89\\u76db\\u4e16\\u4fe1\\u606f\\u54a8\\u8be2\\u6709\\u9650\\u516c\\u53f8\\u79e6\\u7687\\u5c9b\\u5206\\u516c\\u53f8\",\"_UNITACCNUM\":\"111004476680\",\"UnitAccNum\":\"111004476680\",\"_PAGEID\":\"step1\",\"indipayamt\":\"115.50\",\"accname\":\"\\u5b59\\u6d2a\\u519b\",\"AccName\":\"113659871510\",\"bal\":\"56.31\",\"indipaysum\":\"313.50\",\"_SENDOPERID\":\"220106198310091018\",\"_PROCID\":\"60020007\",\"state\":\"1\",\"basenum\":\"1650.00\",\"_SENDDATE\":\"2019-01-24\",\"year4\":\"\",\"year5\":\"\",\"_TYPE\":\"init\",\"frzflag\":\"0\",\"proptype\":\"1\",\"recode\":\"000000\",\"certinum\":\"220106198310091018\",\"CertiNum\":\"220106198310091018\",\"unitpayamt\":\"198.00\",\"_UNITACCNAME\":\"\\u9356\\u693e\\u542b\\u9a9e\\u51b2\\u7568\\u9429\\u6d97\\u7b18\\u6dc7\\u2103\\u4f05\\u935c\\u3128\\ue1d7\\u93c8\\u5910\\u6aba\\u934f\\ue100\\u5f83\\u7ec9\\ufe3e\\u6b97\\u5b80\\u6d98\\u578e\\u934f\\ue100\\u5f83\",\"_ACCNAME\":\"\\u701b\\u6b10\\u693d\\u9350\\ufffd\",\"custid\":\"AP03999345\",\"lpaym\":\"201611\",\"_DEPUTYIDCARDNUM\":\"220106198310091018\",\"$page\":\"\\/ydpx\\/60020007\\/602007_01.ydpx\",\"_SENDTIME\":\"2019-01-24\",\"OpenDate\":\"\",\"ajaxid\":\"query1\",\"uuid\":\"1548295521464\",\"RspCode\":\"000000\",\"Balance\":\"\",\"_IS\":\"-5173878\",\"_LOGIP\":\"218.26.185.2\",\"indiprop\":\"0.070\",\"isSamePer\":\"true\",\"RspMsg\":\"\\u6210\\u529f\",\"_BRANCHKIND\":\"0\",\"CURRENT_SYSTEM_DATE\":\"2019-01-24\",\"_ISCROP\":\"0\",\"frzamt\":\"0.00\",\"_PORCNAME\":\"\\u6d93\\ue043\\u6c49\\u93c4\\u5ea3\\u7c8f\\u7490\\ufe3d\\u7161\\u7487\\ufffd\",\"opnaccdate\":\"2014-08-14\",\"accnum\":\"113659871510\",\"AccNum\":\"113659871510\",\"unitprop\":\"0.120\",\"UnitAccName\":\"\\u9356\\u693e\\u542b\\u9a9e\\u51b2\\u7568\\u9429\\u6d97\\u7b18\\u6dc7\\u2103\\u4f05\\u935c\\u3128\\ue1d7\\u93c8\\u5910\\u6aba\\u934f\\ue100\\u5f83\\u7ec9\\ufe3e\\u6b97\\u5b80\\u6d98\\u578e\\u934f\\ue100\\u5f83\",\"unitaccnum\":\"111004476680\",\"Indiprop\":\"\",\"url\":\"\\/ydpx\\/60020007\\/602007_01.ydpx\",\"Basenum\":\"\",\"_WITHKEY\":\"0\",\"certitype\":\"1\"},\"returnCode\":\"0\"}";

        JSONObject jsonObject = JSONObject.parseObject(formData);

        String sss = jsonObject.toString();
        byte[] gbks = sss.getBytes("UTF-8");
        String aaa = new String(gbks, "GBK");
        System.out.println(jsonObject.toString());
//        Object page = jsonObject.get("$page");
//        System.out.println(page.toString());
    }

    @Test
    public void demo095() throws UnsupportedEncodingException {

        String formData = "<textarea name=\"DATAlISTGHOST\" style=\"display:none\">rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAAK\n" +
                "c3IAJWNvbS55ZHlkLm5icC5lbmdpbmUucHViLkRhdGFMaXN0R2hvc3RCsjhA3j2pwwIAA0wAAmRz\n" +
                "dAASTGphdmEvbGFuZy9TdHJpbmc7TAAEbmFtZXEAfgADTAADc3FscQB+AAN4cHQAEHdvcmtmbG93\n" +
                "LmNmZy54bWx0AAVsaXN0MXQAwT0ic2VsZWN0IChjYXNlIHRyYW5zZGF0ZSB3aGVuICcxODk5LTEy\n" +
                "LTMxJyB0aGVuIG51bGwgZWxzZSB0cmFuc2RhdGUgZW5kKSBhcyB0cmFuc2RhdGUsIGNlcnRpbnVt\n" +
                "LCBhbXQyLCBhbXQxLCBiYXNlbnVtLCBiZWd5bSwgZW5keW0sIGluc3RhbmNlIGZyb20gZHAwNzcg\n" +
                "d2hlcmUgaW5zdGFuY2UgPSAiK19JUyArIiBvcmRlciBieSBzZXFubyJ4</textarea>\n" +
                "<textarea name=\"_DATAPOOL_\" style=\"display:none\">rO0ABXNyABZjb20ueWR5ZC5wb29sLkRhdGFQb29sp4pd0OzirDkCAAZMAAdTWVNEQVRFdAASTGph\n" +
                "dmEvbGFuZy9TdHJpbmc7TAAGU1lTREFZcQB+AAFMAAhTWVNNT05USHEAfgABTAAHU1lTVElNRXEA\n" +
                "fgABTAAHU1lTV0VFS3EAfgABTAAHU1lTWUVBUnEAfgABeHIAEWphdmEudXRpbC5IYXNoTWFwBQfa\n" +
                "wcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAAGHcIAAAAIAAAABZ0AAhf\n" +
                "QnJjQ29kZXB0AAdfQUNDTlVNdAAMMTEzNjU5ODcxNTEwdAALX1VOSVRBQ0NOVU10AAwxMTEwMDQ0\n" +
                "NzY2ODB0AAdfUEFHRUlEdAAFc3RlcDF0AANfSVNzcgAOamF2YS5sYW5nLkxvbmc7i+SQzI8j3wIA\n" +
                "AUoABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhw//////+xC6J0AAxfVU5J\n" +
                "VEFDQ05BTUV0ADzljJfkuqzlubPlronnm5vkuJbkv6Hmga/lkqjor6LmnInpmZDlhazlj7jnp6bn\n" +
                "moflspvliIblhazlj7h0AAZfTE9HSVB0AAwyMTguMjYuMTg1LjJ0AAhfQUNDTkFNRXQACeWtmea0\n" +
                "quWGm3QACWlzU2FtZVBlcnQABHRydWV0AAlfQ0VOVEVSSURwdAALX1NFTkRPUEVSSUR0ABIyMjAx\n" +
                "MDYxOTgzMTAwOTEwMTh0AAdfUFJPQ0lEdAAINjAwMjAwMDd0ABBfREVQVVRZSURDQVJETlVNcQB+\n" +
                "ABl0AAlfU0VORFRJTUV0AAoyMDE5LTAxLTI0dAAJX1NFTkREQVRFdAAKMjAxOS0wMS0yNHQAC19C\n" +
                "UkFOQ0hLSU5EdAABMHQAE0NVUlJFTlRfU1lTVEVNX0RBVEVxAH4AIHQABV9UWVBFdAAEaW5pdHQA\n" +
                "B19JU0NST1BxAH4AInQACV9QT1JDTkFNRXQAFeS4quS6uuaYjue7hui0puafpeivonQAB19VU0JL\n" +
                "RVlwdAAIX1dJVEhLRVlxAH4AInh0AAhAU3lzRGF0ZXQAB0BTeXNEYXl0AAlAU3lzTW9udGh0AAhA\n" +
                "U3lzVGltZXQACEBTeXNXZWVrdAAIQFN5c1llYXI=</textarea>";

        String[] dataStr = new String[2];
        String[] split = formData.split("none\">");
        String[] split1 = split[1].split("</textarea>");
        dataStr[0] = split1[0];
//        System.out.println(split1[0]+"-------------");
        String[] split2 = split[2].split("</textarea>");
        dataStr[1] = split2[0];
//        System.out.println(split2[0]+"-------------");
        System.out.println(Arrays.asList(dataStr));
    }

    @Test
    public void demo097() {

        String formData = "ydl.init.dataList({\n" +
                "\tid: 'list1',\n" +
                "\tdesc: '个人明细账',\n" +
                "\tpaging: true,\n" +
                "\tcurrentPage: 1,\n" +
                "\tpageSize: 10,\n" +
                "\tmaxSize: 100,\n" +
                "\tallowImport: false,\n" +
                "\tallowExport: false,\n" +
                "\tallowInsert: false,\n" +
                "\tallowUpdate: false,\n" +
                "\tallowDelete: false,\n" +
                "\tshowRowId: true,\n" +
                "\tsaveImportFile: false,\n" +
                "\tdialogEdit: 0,\n" +
                "\tcolumns: [\n" +
                "\t\t{id: 'certinum', desc: '摘要', dataType: 'validchar', maxLength: '', required: false, colType: 1, decLen: '', size: '', ischar: false, hidden: false},\n" +
                "\t\t{id: 'amt2', desc: '收入金额', dataType: 'money', maxLength: '', required: false, colType: 1, decLen: '', size: '', ischar: false, hidden: false},\n" +
                "\t\t{id: 'amt1', desc: '支出金额', dataType: 'money', maxLength: '', required: false, colType: 1, decLen: '', size: '', ischar: false, hidden: false},\n" +
                "\t\t{id: 'basenum', desc: '余额', dataType: 'money', maxLength: '', required: false, colType: 1, decLen: '', size: '', ischar: false, hidden: false},\n" +
                "\t\t{id: 'begym', desc: '缴存开始年月', dataType: 'yyyymm', maxLength: '', required: false, colType: 1, decLen: '', size: '', ischar: false, hidden: false},\n" +
                "\t\t{id: 'endym', desc: '缴存截止年月', dataType: 'yyyymm', maxLength: '', required: false, colType: 1, decLen: '', size: '', ischar: false, hidden: false},\n" +
                "\t\t{id: 'transdate', desc: '交易日期', dataType: 'date', maxLength: '', required: false, colType: 1, decLen: '', size: '', ischar: false, hidden: false},\n" +
                "\t\t{id: 'instance', desc: '实例号', dataType: 'int', maxLength: '', required: false, colType: 3, decLen: '', size: '', ischar: false, hidden: true}\n" +
                "\t],\n" +
                "\tdata: [\n" +
                "\n" +
                "\t],\n" +
                "\ttotalCount: 0,\n" +
                "\tpageCount: 0\n" +
                "});\n";
        String[] split = formData.split("dataList\\(");
        String[] split1 = split[1].split("\\);");
        System.out.println(split1[0]);
    }

    @Test
    public void demo098() throws IOException {

        File file = new File("C:\\Users\\mayn\\Desktop\\dd.html");
        Document document = Jsoup.parse(file, "utf-8");
        Element loancontrnum = document.getElementById("loancontrnum");
        //获取标签中的value值
        System.out.println(loancontrnum.val());
    }

    @Test
    public void demo07() throws IOException {

        String aa = "{\"returnCode\":\"0\",\"data\":{\"msg\":\"成功\",\"year5\":\"2019\",\"_ACCNAME\":\"瀛欐椽鍐�\",\"_SENDTIME\":\"2019-01-25\",\"CertiNum\":\"220106198310091018\",\"CURRENT_SYSTEM_DATE\":\"2019-01-25\",\"accnum\":\"113659871510\",\"instance\":\"-5181705\",\"payyear\":\"2019\",\"year\":\"2015\",\"OpenDate\":\"2014-08-14\",\"_IS\":\"-5181705\",\"trancode\":\"118140\",\"_PORCNAME\":\"涓\uE043汉鏄庣粏璐︽煡璇�\",\"_PROCID\":\"60020007\",\"UnitAccNum\":\"111004476680\",\"uuid\":\"1548397163592\",\"year4\":\"2015\",\"Basenum\":\"1650.00\",\"_WITHKEY\":\"0\",\"$page\":\"/ydpx/60020007/602007_01.ydpx\",\"_UNITACCNUM\":\"111004476680\",\"isSamePer\":\"true\",\"_PAGEID\":\"step1\",\"RspMsg\":\"成功\",\"_DEPUTYIDCARDNUM\":\"220106198310091018\",\"recode\":\"000000\",\"unitaccnum\":\"111004476680\",\"_UNITACCNAME\":\"鍖椾含骞冲畨鐩涗笘淇℃伅鍜ㄨ\uE1D7鏈夐檺鍏\uE100徃绉︾殗宀涘垎鍏\uE100徃\",\"Indiprop\":\"0.070\",\"_SENDOPERID\":\"220106198310091018\",\"_ISCROP\":\"0\",\"_ACCNUM\":\"113659871510\",\"url\":\"/ydpx/60020007/602007_01.ydpx\",\"_BRANCHKIND\":\"0\",\"AccName\":\"113659871510\",\"Unitprop\":\"0.120\",\"filename\":\"dpprtf6001_10.2019012504576206\",\"_SENDDATE\":\"2019-01-25\",\"RspCode\":\"000000\",\"_TYPE\":\"init\",\"_LOGIP\":\"218.26.185.2\",\"UnitAccName\":\"鍖椾含骞冲畨鐩涗笘淇℃伅鍜ㄨ\uE1D7鏈夐檺鍏\uE100徃绉︾殗宀涘垎鍏\uE100徃\",\"Balance\":\"56.31\"}}";
        String toCn = toUTF_8(aa);
        System.out.println(toCn);
    }


    @Test
    public void demo087() throws IOException {

        String aa = "[{\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"917.99\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"648.74\",\n" +
                "\t\"transdate\": \"2018-12-07\",\n" +
                "\t\"peoplenum\": \"35\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}, {\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"919.74\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"646.99\",\n" +
                "\t\"transdate\": \"2018-11-07\",\n" +
                "\t\"peoplenum\": \"34\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}, {\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"921.49\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"645.24\",\n" +
                "\t\"transdate\": \"2018-10-09\",\n" +
                "\t\"peoplenum\": \"33\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}, {\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"923.23\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"643.50\",\n" +
                "\t\"transdate\": \"2018-09-07\",\n" +
                "\t\"peoplenum\": \"32\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}, {\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"924.97\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"641.76\",\n" +
                "\t\"transdate\": \"2018-08-07\",\n" +
                "\t\"peoplenum\": \"31\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}, {\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"926.71\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"640.02\",\n" +
                "\t\"transdate\": \"2018-07-09\",\n" +
                "\t\"peoplenum\": \"30\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}, {\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"928.44\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"638.29\",\n" +
                "\t\"transdate\": \"2018-06-07\",\n" +
                "\t\"peoplenum\": \"29\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}, {\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"930.16\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"636.57\",\n" +
                "\t\"transdate\": \"2018-05-08\",\n" +
                "\t\"peoplenum\": \"28\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}, {\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"931.88\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"634.85\",\n" +
                "\t\"transdate\": \"2018-04-09\",\n" +
                "\t\"peoplenum\": \"27\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}, {\n" +
                "\t\"accname1\": \"孙洪军\",\n" +
                "\t\"fundsouflag\": \"1\",\n" +
                "\t\"amt1\": \"933.59\",\n" +
                "\t\"certinum\": \"\",\n" +
                "\t\"amt2\": \"0.00\",\n" +
                "\t\"freeuse2\": \"633.14\",\n" +
                "\t\"transdate\": \"2018-03-07\",\n" +
                "\t\"peoplenum\": \"26\",\n" +
                "\t\"sumamt\": \"1566.73\"\n" +
                "}]";
        JSONArray parse = (JSONArray) JSONArray.parse(aa);
        for (int i = 0; i < parse.size(); i++) {

            System.out.println(parse.get(i));
        }

    }


    public String toUTF_8(String str) throws UnsupportedEncodingException {

        return this.changeCharset(str, GBK);

    }


    /**
     * 字符串编码转换的实现方法
     *
     * @param str        待转换编码的字符串
     * @param newCharset 目标编码
     * @return
     * @throws UnsupportedEncodingException
     */
    public String changeCharset(String str, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            //用默认字符编码解码字符串。
            byte[] bs = str.getBytes();
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }

    /**
     * 字符串编码转换的实现方法
     *
     * @param str        待转换编码的字符串
     * @param oldCharset 原编码
     * @param newCharset 目标编码
     * @return
     * @throws UnsupportedEncodingException
     */
    public String changeCharset(String str, String oldCharset, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            //用旧的字符编码解码字符串。解码可能会出现异常。
            byte[] bs = str.getBytes(oldCharset);
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }

    @Test
    public void test03() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        Calendar c = Calendar.getInstance();
        //过去一年
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        String year = df.format(y);
        System.out.println("过去一年：" + year);
    }
}