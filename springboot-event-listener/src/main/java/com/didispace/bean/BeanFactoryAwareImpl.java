package com.didispace.constructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019-09-22 09:45
 */
@Slf4j
@Component
public class BeanFactoryAwareImpl implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("BeanFactoryAware...");
    }
}
