package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
/**
 * @author duhongming
 * @version 1.0
 * @description Spring Boot使用@Async实现异步调用：自定义线程池
 * @date 2019/9/6 9:31
 */
@SpringBootApplication
@EnableAsync
public class AsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}

}
