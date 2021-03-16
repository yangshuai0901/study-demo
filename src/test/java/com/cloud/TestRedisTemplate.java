package com.cloud;

import com.cloud.confid.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate<String,Serializable> redisTemplate;


    private Logger logger = LoggerFactory.getLogger(TestRedisTemplate.class);

    @Test
    public  void testJedis(){
        redisTemplate.opsForValue().set("123",15,20, TimeUnit.SECONDS);

    }
}
