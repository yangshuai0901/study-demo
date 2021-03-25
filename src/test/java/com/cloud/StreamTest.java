package com.cloud;

import com.cloud.confid.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {

    //flatMap(T -> Stream<R>)
    @Test
    public void testSt7(){

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
