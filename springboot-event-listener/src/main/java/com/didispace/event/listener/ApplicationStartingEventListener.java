package com.didispace.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019/9/7 20:27
 */
@Slf4j
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        log.info("......ApplicationStartingEvent......");
    }

}
