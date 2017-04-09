package com.tongwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tongwen")
public class SpringBootMyBatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisDemoApplication.class, args);
	}
}
