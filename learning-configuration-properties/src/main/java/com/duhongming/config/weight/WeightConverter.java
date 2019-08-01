package com.duhongming.config.weight;

import org.springframework.core.convert.converter.Converter;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-08-01 21:15
 */
public class WeightConverter implements Converter<String, WeightSize> {
    @Override
    public WeightSize convert(String s) {
        return WeightSize.parse(s);
    }
}
