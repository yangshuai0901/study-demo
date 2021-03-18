package com.cloud.confid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.TimeZone;

@Component
public class ScheduledTask {

    private Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    //@Scheduled(cron = "0/5 * * * * ?",zone = "Asia/Shanghai")
    public void testSchedule6(){
        TimeZone zone = TimeZone.getDefault();
        logger.info("定时任务启动6"+zone.getID());
        //打印出可取得的所有时区ID
        String[] iDs = TimeZone.getAvailableIDs();
        System.out.println(Arrays.toString(iDs));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //@Scheduled(fixedDelay = 1000l,initialDelay = 3000l)//加上initialDelay 代表是
    //第一次执行这个任务延迟多长时间开始执行 需配合fixDelay 或者fixRate使用
    public void testSchedule5(){
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("定时任务启动5");
    }
    //@Scheduled(fixedRateString = "${cron}")//同时也支持占位符的表达方式
    public void testSchedule4(){
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("定时任务启动4");
    }
//    @Scheduled(fixedRate = 1000)//支持占位符这种表达方式   是L型
//    @Async("myExecutor")
    public void testSchedule3(){
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("定时任务启动3");
    }
    //@Scheduled(fixedDelayString = "${cron}")//支持占位符这种表达方式   是L型
    public void testSchedule2(){
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("定时任务启动2");
    }
    //@Scheduled(fixedDelay = 1000l)
    public void testSchedule1(){
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("定时任务启动1");
    }

    //@Scheduled(cron = "${schedules}") //支持占位符这种表达方式
    public void testSchedule(){
        logger.info("定时任务启动");
    }

}
