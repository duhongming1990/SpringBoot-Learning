package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @author duhongming
 * @version 1.0
 * @description TODO
 * @date 2019/9/10 15:29
 */
@SpringBootApplication
@EnableScheduling
public class ScheduledApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledApplication.class, args);
	}

}
