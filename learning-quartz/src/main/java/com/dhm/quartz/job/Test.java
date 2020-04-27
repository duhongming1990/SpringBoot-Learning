package com.dhm.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/12 10:21
 */
public class Test extends QuartzJobBean {
    
//    public void startTask() {
//        System.out.println("Hello World!");
//    }

//    public static void main(String[] args) {
//        new Test().startTask();
//    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("Hello World!");
    }
}