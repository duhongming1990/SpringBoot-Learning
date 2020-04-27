

Quartz API的关键接口是：

    Scheduler - 与调度程序交互的主要API。
    Job - 由希望由调度程序执行的组件实现的接口。
    JobDetail - 用于定义作业的实例。
    Trigger（即触发器） - 定义执行给定作业的计划的组件。
    JobBuilder - 用于定义/构建JobDetail实例，用于定义作业的实例。
    TriggerBuilder - 用于定义/构建触发器实例。

Scheduler的生命期，从SchedulerFactory创建它时开始，到Scheduler调用shutdown()方法时结束；Scheduler被创建后，可以增加、删除和列举Job和Trigger，以及执行其它与调度相关的操作（如暂停Trigger）。但是，Scheduler只有在调用start()方法后，才会真正地触发trigger（即执行job）