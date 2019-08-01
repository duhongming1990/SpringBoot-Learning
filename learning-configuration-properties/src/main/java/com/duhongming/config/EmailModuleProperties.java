package com.duhongming.config;

import com.duhongming.config.weight.WeightSize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @Author duhongming
 * @Email 935720334@qq.com
 * @Date 2019-08-01 20:34
 */
@NoArgsConstructor
@Getter
@Setter
@ToString

//启动时校验@ConfigurationProperties
@Validated
//激活@ConfigurationProperties
@Component
//ignoreInvalidFields无法转换的属性忽略掉
//ignoreUnknownFields未知的属性不忽略掉
@ConfigurationProperties(prefix = "myapp.email",ignoreInvalidFields = true,ignoreUnknownFields = false)
public class EmailModuleProperties {
    private boolean enabled = Boolean.FALSE;

    private String defaultSubject;

    //Spring 宽松绑定规则（relaxed binding）
    private String hostName1;
    private String hostName2;
    private String hostName3;
    private String hostName4;
    private String hostName5;

    //复杂属性类型
    private List<String> smtpServers;

    /**
     * ns 纳秒
     * us 微秒
     * ms 毫秒(默认)
     * s 秒
     * m 分
     * h 时
     * d 天
     * 配置文件不写单位，默认为毫秒，可以通过@DurationUnit来指定单位
     */
    @DurationUnit(ChronoUnit.MILLIS)
    private Duration pauseBetweenMails = Duration.ofSeconds(2);

    /**
     * B(默认)
     * KB
     * MB
     * GB
     * TB
     * 配置文件不写单位，默认为B，可以通过@DataSizeUnit来指定单位
     */
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize maxAttachmentSize = DataSize.ofMegabytes(2);

    private WeightSize maxAttachmentWeight;

    /**
     * 标记配置属性为Deprecated
     * @return
     */
    @DeprecatedConfigurationProperty(reason = "change name",replacement = "none")
    public String getDefaultSubject(){
        return defaultSubject;
    }
}
