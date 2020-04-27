package com.dhm.quartz.action;

import com.dhm.quartz.entity.QuartzEntity;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/10 14:57
 */
@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {

    @Autowired
    private static Scheduler scheduler;

    static {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/list")
    public Scheduler list() {
        log.info("任务列表");
        return scheduler;
    }

    @RequestMapping("/add")
    public Scheduler add(QuartzEntity quartzEntity) throws SchedulerException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        log.info("新增任务");

        JobKey jobKey = new JobKey(quartzEntity.getJobName(), quartzEntity.getJobGroup());
        TriggerKey triggerKey = new TriggerKey(quartzEntity.getJobName(), quartzEntity.getJobGroup());

        Class cls = Class.forName(quartzEntity.getJobClassName());
        cls.newInstance();

        JobDetail jobDetail = JobBuilder
                .newJob(cls)
                .withIdentity(jobKey)
                .withDescription(quartzEntity.getDescription())
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(triggerKey)
                .withSchedule(CronScheduleBuilder.cronSchedule(quartzEntity.getCronExpression()))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        return scheduler;
    }

    @RequestMapping("/update")
    public Scheduler update(QuartzEntity quartzEntity) throws SchedulerException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        log.info("修改任务");

        JobKey jobKey = new JobKey(quartzEntity.getJobName(), quartzEntity.getJobGroup());
        TriggerKey triggerKey = new TriggerKey(quartzEntity.getJobName(), quartzEntity.getJobGroup());

        Class cls = Class.forName(quartzEntity.getJobClassName());
        cls.newInstance();

        JobDetail jobDetail = JobBuilder
                .newJob(cls)
                .withIdentity(jobKey)
                .withDescription(quartzEntity.getDescription())
                .build();
        Trigger cronTrigger = TriggerBuilder
                .newTrigger()
                .withIdentity(triggerKey)
                .withSchedule(CronScheduleBuilder.cronSchedule(quartzEntity.getCronExpression()))
                .build();
        // Trigger fresh
        HashSet<Trigger> triggerSet = new HashSet<Trigger>();
        triggerSet.add(cronTrigger);

        scheduler.scheduleJob(jobDetail, triggerSet, true);
        return scheduler;
    }

    @RequestMapping("/trigger")
    public Scheduler trigger(QuartzEntity quartzEntity) throws SchedulerException {

        log.info("触发任务");

        JobKey jobKey = new JobKey(quartzEntity.getJobName(),quartzEntity.getJobGroup());
        scheduler.triggerJob(jobKey);
        return scheduler;
    }

    @RequestMapping("/pause")
    public Scheduler pause(QuartzEntity quartzEntity) throws SchedulerException {

        log.info("停止任务");

        JobKey jobKey = new JobKey(quartzEntity.getJobName(), quartzEntity.getJobGroup());
        scheduler.pauseJob(jobKey);
        return scheduler;
    }

    @RequestMapping("/resume")
    public Scheduler resume(QuartzEntity quartzEntity) throws SchedulerException {

        log.info("恢复任务");

        JobKey jobKey = new JobKey(quartzEntity.getJobName(), quartzEntity.getJobGroup());
        scheduler.resumeJob(jobKey);
        return scheduler;
    }

    @RequestMapping("/remove")
    public Scheduler remove(QuartzEntity quartzEntity) throws SchedulerException {

        log.info("移除任务");

        JobKey jobKey = new JobKey(quartzEntity.getJobName(),quartzEntity.getJobGroup());
        TriggerKey triggerKey = new TriggerKey(quartzEntity.getJobName(), quartzEntity.getJobGroup());

        // 停止触发器
        scheduler.pauseTrigger(triggerKey);
        // 移除触发器
        scheduler.unscheduleJob(triggerKey);
        // 删除任务
        scheduler.deleteJob(jobKey);
        return scheduler;
    }
}