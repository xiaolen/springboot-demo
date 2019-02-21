/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.qin.util;



import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {

    private static final String EMPTY = "";

    /**
     * 判断字符串是否不为空串
     *
     * @param str
     * @return
     */
    public static boolean isNotNULL(String str) {
        return str == null ? false : true;
    }

    /**
     * 判断字符串是否不为空串
     *
     * @param str
     * @return
     */
    public static boolean isNULL(String str) {
        return str == null ? true : false;
    }

    /**
     * 判断字符串是否为空串(null or "")
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    /**
     * 判断字符串是否不为空串
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return (!(isEmpty(str)));
    }

    /**
     * 判断字符串是否为空白串
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if ((str == null) || ((strLen = str.length()) == 0)) {
            return true;
        }
        for (int i = 0; i < strLen; ++i) {
            if (!(Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否不为空白串
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return (!(isBlank(str)));
    }

    /**
     * @param @param  str
     * @param @return
     * @throws
     * @Description:判断字符串不在长度
     */
    public static boolean isNotLeng(String str, int leng) {
        return (!(isLeng(str, leng)));
    }

    public static boolean isNotLeng(String str, int begLen, int leng) {
        return (!(isLeng(str, begLen, leng)));
    }

    /**
     * @param @param  str
     * @param @return
     * @throws
     * @Description:判断字符串在长度里
     */
    public static boolean isLeng(String str, int leng) {
        if (isBlank(str)) {
            return (0 == leng);
        }

        return (length(trim(str)) <= leng);
    }

    /**
     * @param @param  str
     * @param @return
     * @throws
     * @Description:字符串实际长度
     */
    public static int length(String str) {

        if (isBlank(str)) {
            return 0;
        }

        byte[] buf = str.getBytes();
        int len = str.length();

        int count = 0;
        int i = 0;
        for (i = len - 1; i >= 0; i--) {
            if (buf[i] < 0) {
                count++;
            } else {
                break;
            }
        }

        return (len + count);
    }

    /**
     * @param @param  str
     * @param @param  begLen
     * @param @param  endLen
     * @param @return
     * @throws
     * @Description:判断字符串在长度里
     */
    public static boolean isLeng(String str, int begLen, int endLen) {
        if (isBlank(str)) {
            return (0 == endLen);
        }

        if (begLen < 0) {
            return false;
        }

        if ((endLen - begLen) < 0) {
            return false;
        }

        str = trim(str);
        return ((length(str) >= begLen) && (length(str) <= endLen));
    }

    /**
     * trim字符串
     *
     * @param str
     * @return
     */
    public static String trim(String str) {
        return ((str == null) ? null : str.trim());
    }

    /**
     * trim字符串,如果为空串则为null
     *
     * @param str
     * @return
     */
    public static String trimToNull(String str) {
        String ts = trim(str);
        return ((isEmpty(ts)) ? null : ts);
    }

    /**
     * trim字符串,如果为空则变为空串
     *
     * @param str
     * @return
     */
    public static String trimToEmpty(String str) {
        return ((str == null) ? "" : str.trim());
    }

    /**
     * getBytes
     *
     * @param content
     * @param charset
     * @return
     */
    public static byte[] getBytes(String content, String charset) {
        if (StringUtils.isNULL(content)) {
            content = EMPTY;
        }
        if (StringUtils.isBlank(charset)) {
            throw new IllegalArgumentException("charset can not null");
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("charset is not valid,charset is:" + charset);
        }
    }

    /**
     * getBytes
     *
     * @param content
     * @return
     */
    public static byte[] getBytes(String content) {
        if (StringUtils.isNULL(content)) {
            content = EMPTY;
        }
        return content.getBytes();
    }

    public static String getString(byte[] binaryData, String charset) {
        try {
            return new String(binaryData, charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("charset is not valid,charset is:" + charset);
        }
    }

    /**
     * bean 转化为String
     *
     * @param bean
     * @return
     */
//    public static String beanToString(Object bean) {
//        return ToStringBuilder.reflectionToString(bean, ToStringStyle.SHORT_PREFIX_STYLE);
//    }

    /**
     * 字符串填充
     *
     * @param a
     * @param num
     * @return
     */
    public static String fill(char a, int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(a);
        }
        return builder.toString();
    }

    public static String capitalize(final String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }

        final char firstChar = str.charAt(0);
        if (Character.isTitleCase(firstChar)) {
            // already capitalized
            return str;
        }

        return new StringBuilder(strLen)
                .append(Character.toTitleCase(firstChar))
                .append(str.substring(1))
                .toString();
    }

    /**
     * 截断字符串
     *
     * @param str
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public static String truncate(String str, int beginIndex, int endIndex) {

        if (isEmpty(str)) {
            return str;
        }
        if (beginIndex < 0) {
            return str;
        }
        if (endIndex > str.length()) {
            return str;
        }

        if ((endIndex - beginIndex) < 0) {
            return str;
        }

        return str.substring(beginIndex, endIndex);
    }

    /**
     * @param @param  list
     * @param @return
     * @throws
     * @Description:集合转换String
     */
    public static String listConverString(List<String> list) {
        StringBuffer sb = new StringBuffer();
        if (list == null || list.isEmpty()) {
            return "";
        }
        for (String string : list) {
            if (sb.length() > 0 && StringUtils.isNotBlank(string)) {
                sb.append(",");
            }
            if (StringUtils.isNotBlank(string)) {
                sb.append(string);
            }
        }
        return sb.toString();
    }

    /**
     * 源串是否包含目标字符
     *
     * @param source
     * @param destination
     * @return
     */
    public static boolean contains(String source, String destination) {
        if (isBlank(source) || isBlank(destination)) {
            return false;
        }
        return source.contains(destination);
    }

    /**
     * @param @param  html
     * @param @return
     * @throws
     * @Description:替换文本
     */
    public static String replaceHtml(String html) {
        if (StringUtils.isBlank(html)) {
            return "";
        }

        html = html.replaceAll("//\\]\\]\\>", "");
        html = html.replaceAll("//\\<\\!\\[CDATA\\[", "");
        html = html.replaceAll("\\<script.*?\\>|\\</script\\>", "");

        if (StringUtils.isBlank(html)) {
            return "";
        }

        html = html.trim();
        return html;
    }

    /**
     * @param @param  html
     * @param @return
     * @throws
     * @Description:判断某个字符串为数字或者是浮点数
     */
    public static boolean isFloat(String html) {
        if (StringUtils.isBlank(html)) {
            return false;
        }
        return html.matches("[0-9]+\\.?[0-9]*");
    }

    /**
     * 去除HTml标签
     *
     * @param htmlStr
     * @return
     */
    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        String regEx_html = "<[^>]+>";

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");

        return htmlStr.trim();
    }


    /**
     * InputStream转String
     *
     * @param is
     * @return
     */
    public static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {

        } finally {
            try {
                is.close();
            } catch (IOException e) {

            }
        }

        return sb.toString();
    }

    /**
     * String[]转String
     *
     * @param arr
     * @return
     */
    public static String implodeStr(String[] arr, String delimiter) {
        StringBuilder sb = new StringBuilder(arr.length * 3);

        int offset = arr.length - 1;
        for (int i = 0; i < offset; i++) {
            sb.append(arr[i]).append(delimiter);
        }
        sb.append(arr[offset]);

        return sb.toString();
    }

    public static String asciiToNative(String asciicode) {
        String[] asciis = asciicode.split("\\\\u");
        String nativeValue = asciis[0];
        try {
            for (int i = 1; i < asciis.length; i++) {
                String code = asciis[i];
                nativeValue += (char) Integer.parseInt(code.substring(0, 4), 16);
                if (code.length() > 4) {
                    nativeValue += code.substring(4, code.length());
                }
            }
        } catch (NumberFormatException e) {
            return asciicode;
        }
        return nativeValue;
    }

    public static String trimAllWhitespace(String str) {
        if (isBlank(str)) {
            return str;
        } else {
            int len = str.length();
            StringBuilder sb = new StringBuilder(str.length());

            for (int i = 0; i < len; ++i) {
                char c = str.charAt(i);
                if (!Character.isWhitespace(c)) {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }

    /**
     * 过滤字符串中的中文字符
     * @param str
     * @return
     */
    public static String filterChinese(String str){
        if (StringUtils.isBlank(str)){
            return str;
        }
        String reg = "[\u4e00-\u9fa5]";

        Pattern pat = Pattern.compile(reg);

        Matcher mat=pat.matcher(str);

        return mat.replaceAll("");
    }

    /**
     * @Description:判断某个字符串为数字
     * @param @param html
     * @param @return
     * @throws
     * */
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
