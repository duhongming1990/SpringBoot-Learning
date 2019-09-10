package com.dhm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/8/14 9:50
 *
 * 《Spring Boot使用@Async实现异步调用：自定义线程池》
 *
 * 通过使用 ThreadPoolTaskExecutor创建了一个线程池，同时设置了以下这些参数：
 *
 * 核心线程数10：线程池创建时候初始化的线程数
 *
 * 最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
 *
 * 缓冲队列200：用来缓冲执行任务的队列
 *
 * 允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
 *
 * 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
 *
 * 线程池对拒绝任务的处理策略：这里采用了 CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
 */
@EnableAsync
@Configuration
public class TaskPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setQueueCapacity(200);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("taskExecutor-");
        /**
         * 任务拒绝策略
         *
         * 当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略，通常有以下四种策略：
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
         * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
         */
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return taskExecutor;
    }

    @Bean("redisTaskExecutor")
    public Executor redisTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setThreadNamePrefix("redisTaskExecutor-");
        /**
         * setWaitForTasksToCompleteOnShutdown（true）该方法就是这里的关键，
         * 用来设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean，
         * 这样这些异步任务的销毁就会先于Redis线程池的销毁。
         * 同时，这里还设置了 setAwaitTerminationSeconds(60)，
         * 该方法用来设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，
         * 以确保应用最后能够被关闭，而不是阻塞住。
         */
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(60);
        return taskExecutor;
    }
}