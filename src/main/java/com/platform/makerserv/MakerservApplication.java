package com.platform.makerserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class MakerservApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakerservApplication.class, args);
	}

}
