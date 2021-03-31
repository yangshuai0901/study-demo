package com.cloud;

import com.cloud.config.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class LambdaTest {


    @Test
    public void testStringFormat(){

    }
    //数组引用
    @Test
    public void testLa5(){
        //匿名内部类
        Function<Integer, String[]> fu1 = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };
        System.out.println(fu1.apply(10).length);
        //lambda表达式
        Function<Integer,String[]> fu2 = (x)->new String[x];
        System.out.println(fu2.apply(8).length);
        //数组引用
        Function<Integer,String[]> fu3 = String[]::new;
        System.out.println(fu3.apply(6).length);
    }
    //构造器引用
    @Test
    public void testLa4(){
        Supplier<User> su1 = new Supplier<User>() {
            @Override
            public User get() {
                return new User();
            }
        };
        System.out.println(su1.get());
        //lambda表达式
        Supplier<User> su2 = ()-> new User();
        System.out.println(su2.get());
        //构造器引用
        Supplier<User> su3 = User::new;
        System.out.println(su3.get());
        //有参构造  匿名内部类
        Function<String, User> fu1 = new Function<String, User>(){
            @Override
            public User apply(String s) {
                return new User(s);
            }
        };
        System.out.println(fu1.apply("zhangsan").getUsername());
        //有参构造  lambda表达式
        Function<String,User> fu2 = (name)->new User(name);
        System.out.println(fu2.apply("lisi").getUsername());
        //有参构造器  构造器引用
        Function<String,User> fu3 = User::new;
        System.out.println(fu3.apply("wangwu").getUsername());
    }
    // 类 实例方法名
    @Test
    public void testLa3(){
        /*BiPredicate<String, String> predicate = new BiPredicate<String, String>(){
            @Override
            public boolean test(String s, String s2) {
                return s.equals(s2);
            }
        };
        System.out.println(predicate.test("12","12"));*/
        /*BiPredicate<String,String> predicate = (x,y)->{return x.equals(y);};
        System.out.println(predicate.test("12","13"));*/
        BiPredicate <String,String> predicate = String::equals;
        System.out.println(predicate.test("12", "12"));
    }
    // 类 静态方法名
    @Test
    public void testLa2(){
//        Comparator<Integer> com = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1,o2);
//            }
//        };
//        System.out.println( com.compare(12,13));
        //lambda 表达式方法
       /* Comparator<Integer> com = (x,y)-> {return Integer.compare(x,y);};
        System.out.println( com.compare(12,13));*/
        // 方法引用方式
        Comparator<Integer> com = Integer::compare;
        System.out.println(com.compare(12,13));
    }
    //对象  实例方法名
    @Test
    public void testLa1(){
        User user = new User();
        user.setUsername("zhangsan");
        Supplier<String> supplier = user::getUsername;
        System.out.println(supplier.get());
      /*  Supplier<String> supplier = ()-> user.getUsername();
        System.out.println(supplier.get());*/
//        Supplier<String> supplier =()->{return user.getUsername();};
////        System.out.println(supplier.get());
        /*Supplier<String> supplier = new Supplier<String>(){
            @Override
            public String get() {
                return user.getUsername();
            }
        };
        System.out.println(supplier.get());*/
//        Consumer<String> consumer = new Consumer<String>(){
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        consumer.accept("lambda");
       /* Consumer<String> con = (s)-> System.out.println(s);
        con.accept("lambda");*/
      /* Consumer<String> con = System.out::println;
       con.accept("lambda");*/
    }

    @Test
    public void testDate() throws Exception {
    String s = "{\"lastSubmitTime\":1614823329000,\"failedNos\":[\"R000021030120\",\"R000021030130\",\"R000021030124\",\"R000021030123\",\"R000021030122\",\"R000021030121\"]}";
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap = mapper.readValue(s,HashMap.class);
        Object failedNos = hashMap.get("failedNos");
        System.out.println(failedNos);
//        Set<Map.Entry<String, Object>> entries = hashMap.entrySet();
//        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Object> entry = iterator.next();
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//        Set<String> strings = hashMap.keySet();
//        for (String string : strings) {
//            Object o = hashMap.get(string);
//            System.out.println(o);
//        }
//        Set<Map.Entry<String, Object>> entries = hashMap.entrySet();
//        for (Map.Entry<String, Object> entry : entries) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
    }
    //Predicate<T> 断言型接口(有一个参数,返回值为波尔类型)		boolean test(T t);
    @Test
    public void testLam10(){
        List<String> list = Arrays.asList("Hello","world","MY","NAME","IS","MOTI");
        List<String> result = filterStr(list, (str) -> {
            return str.equals("Hello") || str.equals("world");
        });
        result.forEach(System.out::println);
    }
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> resultList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)){
                resultList.add(s);
            }
        }
        return resultList;
    }

    @Test
    public void testLam9(){
        String result  = strHandler("nihao", (str) -> {
            return str += ",dejf";
        });
        System.out.println(result);
    }
    //Function<T,R> 函数型接口(有一个参数,有返回值)		R apply(T t);
    public String strHandler(String str , Function<String,String> fun){
        String apply = fun.apply(str);
        return apply;
    }
    //Supplier<T> 供给型接口(无参数,但是有返回值)		T get();
    @Test
    public void testLam8(){
        List<Integer> integers = getRandomNum(20, () -> (int) (Math.random() * 100));
        integers.forEach(System.out::println);
    }
    public List<Integer> getRandomNum(int num , Supplier<Integer> sup){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }
    //Consumer<T> 消费型接口(有一个参数,但是无返回值)		void accept(T t);
    @Test
    public void testLam7(){
        happy(2000,(money)-> System.out.println(money));
    }
    public void happy(double money,Consumer<Double> consumer){
        consumer.accept(money);
    }
    @Test
    public void testLam6(){
        //lambda表达式的参数列表数据类型可以不写,jvm自动推断(推荐不写)
       Comparator<Integer> com = (Integer x,Integer y)->Integer.compare(x,y);
        System.out.println(com.compare(11,12));
    }
    @Test
    public void testLam5(){
        //若有多个参数并且有返回值,只有一条语句(return 和大括号都可以省略)
       Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        System.out.println(com.compare(12,11));
    }

    @Test
    public void testLam4(){
        //若有多个参数,并且lambda体中有多个语句,并且有返回值
        Comparator<Integer> com = (x,y)->{
            System.out.println("有多个参数 , 并且lambda体有多个语句, 必须使用大括号");
            return Integer.compare(x,y);
        };
        System.out.println(com.compare(12,15));
    }

    @Test
    public void testLam3(){
      //若只有一个参数则参数的小括号可以不写,(推荐还是写上)
        Consumer<String> consumer = x-> System.out.println(x);
        consumer.accept("hello");
    }
    @Test
    public void testLam2(){
        //有一个参数,无返回值
        Consumer<String> consumer = (x)-> System.out.println(x);
        consumer.accept("OK");
    }
    @Test
    public void testLam1(){
        //无参数   无返回值
        Runnable r1 = () -> System.out.println("Hello Lambda");
        r1.run();
    }
}
