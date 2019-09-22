package com.didispace.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019-09-22 09:42
 */
@Slf4j
@Component
public class InitializingBeanImpl implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean...");
    }
}
