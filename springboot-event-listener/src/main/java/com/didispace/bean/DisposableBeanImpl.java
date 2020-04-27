package com.didispace.constructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019-09-22 09:43
 */
@Slf4j
@Component
public class DisposableBeanImpl implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean...");
    }
}
