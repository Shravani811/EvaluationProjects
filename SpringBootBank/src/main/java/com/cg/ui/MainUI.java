package com.cg.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cg.mycontroller")
@ComponentScan("com.cg.dao")
@ComponentScan("com.cg.service")
@ComponentScan("com.cg.model")
@EntityScan(basePackages = {"com.cg.model"})
@SpringBootApplication
public class MainUI {
	public static void main(String[] args) {
		SpringApplication.run(MainUI.class, args);
	}
}
