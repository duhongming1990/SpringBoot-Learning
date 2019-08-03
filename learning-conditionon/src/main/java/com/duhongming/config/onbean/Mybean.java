package com.duhongming.config.onbean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-08-03 22:45
 */
@Configuration
/**
 * 当OtherBean已经存在上下文才会加载
 */
@ConditionalOnBean(OtherBean.class)
public class Mybean {

    public String getMybeanName(){
        return "getMybeanName";
    }

}
