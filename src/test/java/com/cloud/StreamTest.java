package com.cloud;

import com.cloud.confid.Student;
import com.cloud.confid.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {


    public List<Student> testStream() {
        List<Student> list = Arrays.asList(
                new Student("李星云", 18, 0, "渝州", new BigDecimal(1000)),
                new Student("陆林轩", 16, 1, "渝州", new BigDecimal(500)),
                new Student("姬如雪", 17, 1, "幻音坊", new BigDecimal(800)),
                new Student("袁天罡", 99, 0, "藏兵谷", new BigDecimal(100000)),
                new Student("张子凡", 19, 0, "天师府", new BigDecimal(900)),
                new Student("陆佑劫", 45, 0, "不良人", new BigDecimal(600)),
                new Student("张天师", 48, 0, "天师府", new BigDecimal(1100)),
                new Student("蚩梦", 18, 1, "万毒窟", new BigDecimal(800))
        );
        return list;
    }
}
