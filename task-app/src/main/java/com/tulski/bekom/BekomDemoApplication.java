package com.tulski.bekom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tulski.bekom")
public class BekomDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BekomDemoApplication.class, args);
	}

}
