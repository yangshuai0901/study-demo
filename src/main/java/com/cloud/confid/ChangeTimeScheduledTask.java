package com.cloud.confid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 可动态更改时间的定时任务
 */
public class ChangeTimeScheduledTask implements SchedulingConfigurer{
    private static final Logger logger = LoggerFactory.getLogger(ChangeTimeScheduledTask.class);

    // cron表达式，我们动态更改此属性的值即可更改定时任务的执行时间
    private String expression = "0/5 * * * * ?";

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        Runnable task = () -> logger.info(">>> configureTasks ...");
    }
}
