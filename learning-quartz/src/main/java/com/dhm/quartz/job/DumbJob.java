package com.dhm.quartz.job;

import org.quartz.*;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/7 15:54
 */
public class DumbJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");

        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);

    }
}