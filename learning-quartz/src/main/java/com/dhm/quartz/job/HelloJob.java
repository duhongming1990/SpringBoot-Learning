package com.dhm.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/7 15:01
 */
@Slf4j
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("HelloJob");
    }
}