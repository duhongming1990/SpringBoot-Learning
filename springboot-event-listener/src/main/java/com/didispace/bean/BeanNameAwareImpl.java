package com.didispace.constructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019-09-22 09:36
 */
@Slf4j
@Component
public class BeanNameAwareImpl implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        log.info("BeanNameAware...");
    }
}
