package com.dhm.quartz.entity;

import lombok.Data;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/11 16:31
 */
@Data
public class QuartzEntity {
    private String jobName;//任务名称
    private String jobGroup;//任务分组
    private String description;//任务描述
    private String jobClassName;//执行类
    private String cronExpression;//执行时间
    private String triggerName;//执行时间
    private String triggerState;//任务状态

    private String oldJobName;//任务名称 用于修改
    private String oldJobGroup;//任务分组 用于修改
}