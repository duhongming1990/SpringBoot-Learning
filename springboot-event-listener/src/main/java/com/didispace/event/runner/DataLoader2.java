package com.didispace.event.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019/9/10 13:46
 */
@Component
@Order(2)
@Slf4j
public class DataLoader2 implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        log.info("Loading data2...");
    }
}