package com.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosTest {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @RequestMapping("/getMessage")
    public String getMessage(){
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        return "url:" + url + "</br>username:" + username + "</br>password:" + password;
    }

}
