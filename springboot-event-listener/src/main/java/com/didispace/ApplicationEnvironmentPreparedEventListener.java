package com.didispace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019/9/7 20:27
 */
@Slf4j
public class ApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        log.info("......ApplicationEnvironmentPreparedEvent......");
    }

}
