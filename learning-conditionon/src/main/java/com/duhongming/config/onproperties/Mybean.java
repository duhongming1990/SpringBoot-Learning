package com.duhongming.config.onproperties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-08-03 22:45
 */
@Configuration
/**
 * application.properties或者application.yml文件中
 * onproperties.mybean.enable=true才加载这个bean
 *
 * 如果没有匹配上也会加载
 */
@ConditionalOnProperty(value = "onproperties.mybean.enable",havingValue = "true",matchIfMissing = true)
public class Mybean {

    public String getMybeanName(){
        return "getMybeanName";
    }

}
