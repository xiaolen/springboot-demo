package com.qin.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.*;

/**
 * @Author: 秦渊渊
 * @Date: 2018/12/13 10:55
 */
public class demoLambda {


    @Test
    public void LambdaTest() {
//        //匿名内部类
//        Comparator<Integer> cpt = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//
//                return Integer.compare(o1,o2);
//            }
//        };
//        TreeSet<Integer> set = new TreeSet<>(cpt);
//
//        System.out.println(set.toString());
//        System.out.println("======================");
//
//
//        //使用lambda表达式
//        Comparator<Integer> cpt2 = (x,y) -> Integer.compare(x,y);
//        TreeSet<Integer> set2 = new TreeSet<>(cpt2);
//
//        System.out.println(set2);


//        List<String> prods = new ArrayList<>();
//        prods.add("红色");
//        prods.add("lu色");
//        prods.add("lan色");
//        prods.add("红色");
//
//        for (String product : prods){
//            if ("红色".equals(prods)){
//                prods.add(product);
//            }
//        }

//        ()-> System.out.println("helloword");
    }

    @Test
    public void test() {
        changeStr("hello", (str) -> System.out.println(str));
    }

    /**
     * Consumer<T> 消费型接口
     *
     * @param str
     * @param con
     */
    public void changeStr(String str, Consumer<String> con) {
        con.accept(str);
    }

    @Test
    public void test2() {
        String value = getValue(() -> "hello1111");
        System.out.println(value);
    }

    /**
     * Supplier<T> 供给型接口
     *
     * @param sup
     * @return
     */
    public String getValue(Supplier<String> sup) {
        return sup.get();
    }


    @Test
    public void test3() {
        Long result = changeNum(100L, (x) -> x + 200L);
        System.out.println(result);
    }

    /**
     * Function<T,R> 函数式接口
     *
     * @param num
     * @param fun
     * @return
     */
    public Long changeNum(Long num, Function<Long, Long> fun) {
        return fun.apply(num);
    }

    @Test
    public void test4() {
        boolean result = changeBoolean("hello", (str) -> str.length() >= 5);
        System.out.println(result);
    }

    /**
     * Predicate<T> 断言型接口
     *
     * @param str
     * @param pre
     * @return
     */
    public boolean changeBoolean(String str, Predicate<String> pre) {
        return pre.test(str);
    }

    @Test
    public void test5() {
        /**
         *注意：
         *   1.lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
         *   2.若lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
         *
         */
        Consumer<Integer> con = (x) -> System.out.println(x);
        con.accept(100);

        // 方法引用-对象::实例方法
        Consumer<Integer> con2 = System.out::println;
        con2.accept(200);

        // 方法引用-类名::静态方法名
        BiFunction<Integer, Integer, Integer> biFun = (x, y) -> Integer.compare(x, y);
        BiFunction<Integer, Integer, Integer> biFun2 = Integer::compare;
        Integer result = biFun2.apply(100, 200);

        // 方法引用-类名::实例方法名
        BiFunction<String, String, Boolean> fun1 = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> fun2 = String::equals;
        Boolean result2 = fun2.apply("hello", "world");
        System.out.println(result2);
    }

    @Test
    public void test06() {
        List<String> al = Arrays.asList("a", "b", "c", "d");
//        for (String a: al) {
//            System.out.println(a);
//        }
        //下面的for each循环和上面的循环是等价的
        al.forEach(x -> {
            System.out.println(x);
        });
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(dtf.format(dt));
//
//
//
//        Date date = new Date();
//        System.out.println(date.getTime());

//        // 1. Individual values
//        Stream stream = Stream.of("a", "b", "c");
//// 2. Arrays
//        String[] strArray = new String[]{"a", "b", "c"};
//        stream = Stream.of(strArray);
//        System.out.println(stream + "===");
//        stream = Arrays.stream(strArray);
//        System.out.println(stream + "++++");
//// 3. Collections
//        List<String> list = Arrays.asList(strArray);
//        stream = list.stream();
//        System.out.println(stream + "qq");


//        Function<String, Integer> toInteger = Integer::valueOf;
//        Function<String, String> backToString = toInteger.andThen(String::valueOf);
//        backToString.apply("123");
//        System.out.println(toInteger);
//        System.out.println(backToString);
    }

    @Test
    public void timeDay() {
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s = dtf.format(dt).toString();
        System.out.println(s);
    }

    @Test
    public void timeDay01() {
        for (int i = 0; i < 6; i++) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);
            calendar.set(Calendar.MONTH, month - i);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//            System.out.println("上个月最后一天：" + sf.format(calendar.getTime()));
            String s = sf.format(calendar.getTime()).toString();
            System.out.println(s);
        }

    }

    @Test
    public void timeDay02() {
        for (int i = 0; i < 6; i++) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -i);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            System.out.println("上个月第一天：" + format.format(calendar.getTime()));

        }
    }

    @Test
    public void timeDay03() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(format.format(calendar.getTime()));

    }

    @Test
    public void timeDay04() {
        String[] ss = new String[2];
        String a = "sdvdf";
        String b = "qqqqq";
        ss[0] = a;
        ss[1] = b;
        System.out.println(Arrays.asList(ss));
        System.out.println(ss.length);

    }

    @Test
    public void timeDay05() {
        for (int i = 0; i <6 ; i++) {
            String[] time = getTime(i);
            if(i == 0){
                LocalDateTime dt = LocalDateTime.now();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String s = dtf.format(dt).toString();
                System.out.println(s+"等于0");
                System.out.println(time[1]+"等于0");
                System.out.println("===============");
            }else {
                System.out.println(time[1]+"不等于0");
                System.out.println(time[0]+"不等于0");
                System.out.println("------------------");
            }
        }

    }

    private String[] getTime(int day) {

        //存放起始时间的数组
        String[] time = new String[2];
        //每个月的最后一天
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarEnd = Calendar.getInstance();
        int month = calendarEnd.get(Calendar.MONTH);
        calendarEnd.set(Calendar.MONTH, month - day);
        calendarEnd.set(Calendar.DAY_OF_MONTH, calendarEnd.getActualMaximum(Calendar.DAY_OF_MONTH));
//        System.out.println("上个月最后一天："+sf.format(calendarEnd.getTime()).toString());
        time[0] = sf.format(calendarEnd.getTime()).toString();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.add(Calendar.MONTH, -day);
        calendarStart.set(Calendar.DAY_OF_MONTH, 1);
//        System.out.println("上个月第一天："+format.format(calendarStart.getTime()).toString());
        time[1] = format.format(calendarStart.getTime()).toString();
        return time;
    }
}
