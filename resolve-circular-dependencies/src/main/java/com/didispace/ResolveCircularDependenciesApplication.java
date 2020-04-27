package com.didispace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019/9/7 20:27
 */
@Slf4j
@SpringBootApplication
public class ResolveCircularDependenciesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResolveCircularDependenciesApplication.class, args);
    }
}
