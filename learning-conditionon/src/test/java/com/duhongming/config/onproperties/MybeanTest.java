package com.duhongming.config.onproperties;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybeanTest {

    @Resource
    private Mybean mybean;

    @Test
    public void testMyBean(){
        log.info("mybean:{}",mybean.getMybeanName());
    }

}