package com.cloud;

import com.cloud.config.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {

    public void testMap(){

    }

    //maxBy minBy 最大值和最小值
    @Test
    public void testSt14(){
        List<Student> students = testStream();
        Optional<Student> max = students.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getAge)));
        Optional<Student> min = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        System.out.println(max+"--"+min);
    }
    //count 统计总数
    @Test
    public void testSt13(){
        List<Student> students = testStream();
        long count = students.stream().count();
        System.out.println(count);
    }
    //findAny 找到任意一个元素
    @Test
    public void testSt12(){
        List<Student> students = testStream();
        Optional<Student> student = students.stream().findAny();
        System.out.println(student.toString());
    }
    //findFirst 找到第一个元素
    @Test
    public void testSt11(){
        List<Student> students = testStream();
        Optional<Student> first = students.stream().sorted(Comparator.comparingInt(Student::getAge)).findFirst();
        System.out.println(first.toString());
    }
    //noneMatchT 流中是否有元素匹配给定的T
    @Test
    public void testSt10(){
        List<Student> list = testStream();
        boolean b = list.stream().noneMatch(student -> student.getAddress().contains("郑州"));
        System.out.println(b);
    }
    //anyMatch 检测是否有任意元素满足给定的条件
    @Test
    public void testSt9(){
        List<Student> students = testStream();
        boolean b = students.stream().anyMatch(student -> student.getSex() == 1);
        System.out.println(b);
    }
    //allMatch 检测是否全部满足参数行为
    @Test
    public void testSt8(){
        List<Student> list = testStream();
        boolean b = list.stream().allMatch(student -> student.getAge() >= 17);
        System.out.println(b);
    }
    //flatMap(T -> Stream<R>)
    @Test
    public void testSt7()  {
        List<String> flatmap = new ArrayList<>();
        flatmap.add("常宣灵,常昊灵");
        flatmap.add("孟婆,判官红,判官蓝");
         flatmap = flatmap.stream()
                .map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        for (String s : flatmap) {
            System.out.println(s);
        }

    }

    //map(T->R)
    @Test
    public void testSt6(){
        List<Student> students = testStream();
        List<String> collect = students.stream().map(Student::getName).distinct().collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
    }
    //skip前去除n个元素
    @Test
    public void testSt5(){
        List<Student> students = testStream();
        List<Student> collect = students.stream().sorted(Comparator.comparingInt(Student::getAge)).skip(2).collect(Collectors.toList());
        for (Student student : collect) {
            System.out.println(student.getName()+"--"+student.getAge());
        }
    }

    //limit前返回n个元素
    @Test
    public void testSt4(){
        List<Student> students = testStream();
        List<Student> collect = students.stream().sorted(Comparator.comparingInt(Student::getAge)).limit(2).collect(Collectors.toList());
        for (Student student : collect) {
            System.out.println(student.getName()+"--"+student.getAge());
        }

    }
    //sorted排序
    @Test
    public void testSt3(){
        List<Student> students = testStream();
        List<Student> collect = students.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
        for (Student student : collect) {
            System.out.println(student.getName()+"--"+student.getAge());
        }

    }
    //distinct 去重
    @Test
    public void testSt2(){
        List<Student> list = testStream();
        List<Student> students = list.stream().distinct().collect(Collectors.toList());
        for (Student student : students) {
            System.out.println(student.getName()+"--"+student.getAge());
        }

    }
    // filter 过滤实例
    //数据源中复制new Student("李星云", 18, 0, "渝州",new BigDecimal(1000)) 并粘贴两个
    @Test
    public void testSt1(){
        List<Student> list = testStream();
        List<Student> newList = list.stream().filter(user -> user.getAge() > 20)
                .collect(Collectors.toList());
        for (Student student : newList) {
            System.out.println(student.getName()+"--"+student.getAge());
        }
    }

    public List<Student> testStream() {
        List<Student> list = Arrays.asList(
                new Student("李星云", 18, 0, "渝州", new BigDecimal(1000)),
                new Student("陆林轩", 16, 1, "渝州", new BigDecimal(500)),
                new Student("姬如雪", 17, 1, "幻音坊", new BigDecimal(800)),
                new Student("袁天罡", 99, 0, "藏兵谷", new BigDecimal(100000)),
                new Student("张子凡", 19, 0, "天师府", new BigDecimal(900)),
                new Student("陆佑劫", 45, 0, "不良人", new BigDecimal(600)),
                new Student("张天师", 48, 0, "天师府", new BigDecimal(1100)),
                new Student("李星云", 18, 0, "渝州",new BigDecimal(1000)),
                new Student("李星云", 18, 0, "渝州",new BigDecimal(1000)),
                new Student("蚩梦", 18, 1, "万毒窟", new BigDecimal(800))

        );
        return list;
    }
}
