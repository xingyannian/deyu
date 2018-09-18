package com.xingyannian.deyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DeyuApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeyuApplication.class, args);
	}
}
