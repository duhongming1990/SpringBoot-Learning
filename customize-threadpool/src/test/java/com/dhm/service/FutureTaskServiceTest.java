package com.dhm.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FutureTaskServiceTest {

    @Autowired
    private FutureTaskService futureTaskService;

    @Test
    public void test() throws Exception {
        Future<String> taskOneFuture = futureTaskService.doTaskOne();
        String futureResult = taskOneFuture.get(5,TimeUnit.SECONDS);
        log.info(futureResult);
    }

}