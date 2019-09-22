package com.duhongming.config;

import com.duhongming.config.weight.WeightConverter;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-08-01 21:18
 */
@Configuration
public class PropertiesConfig {

    @Bean
    //让SpringBoot知道使用该转换器做数据绑定
    @ConfigurationPropertiesBinding
    public WeightConverter weightConverter(){
        return new WeightConverter();
    }
}
