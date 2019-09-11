package com.didispace.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019/9/7 20:27
 */
@Slf4j
@Component
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Value("${spring.test.data}")
    private String data;

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        log.info(data);
        log.info("......ApplicationPreparedEvent......");
    }

}
