package com.example.MiniSplitwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.MiniSplitwise")
public class MiniSplitwiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniSplitwiseApplication.class, args);
		System.out.println("Running Splitwise");
	}

}
