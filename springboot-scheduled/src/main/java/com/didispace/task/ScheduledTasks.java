package com.didispace.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019/9/10 15:24
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * ms
     */
    @Scheduled(initialDelay=1000, fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("当前时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "${spring.boot.cron}")
    public void showCurrentTime() {
        System.out.println("当前时间：" + dateFormat.format(new Date()));
    }

}
