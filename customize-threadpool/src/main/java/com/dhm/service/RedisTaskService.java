package com.dhm.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/8/15 11:05
 */
@Slf4j
@Component
public class RedisTaskService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Async("redisTaskExecutor")
    public void doTaskOne() {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async("redisTaskExecutor")
    public void doTaskTwo() {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async("redisTaskExecutor")
    public void doTaskThree() {
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
    }
}