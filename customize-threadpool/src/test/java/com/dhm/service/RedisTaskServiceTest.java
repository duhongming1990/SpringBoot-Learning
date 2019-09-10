package com.dhm.service;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTaskServiceTest {

    @Autowired
    private RedisTaskService redisTaskService;

    @Test
    @SneakyThrows
    public void test() {

        for (int i = 0; i < 10000; i++) {
            redisTaskService.doTaskOne();
            redisTaskService.doTaskTwo();
            redisTaskService.doTaskThree();
            if(i == 9999){
                System.exit(0);
            }
        }
    }
}