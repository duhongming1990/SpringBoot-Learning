package com.dhm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot使用@Async实现异步调用：自定义线程池
 */
@SpringBootApplication
public class CustomizeThreadpoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomizeThreadpoolApplication.class, args);
    }
}
