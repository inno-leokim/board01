package com.brand13.board01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@ConfigurationPropertiesScan //Thymeleaf 디커플링 사용을 위한 어노테이션
@SpringBootApplication
public class Board01Application {

	public static void main(String[] args) {
		// System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Board01Application.class, args);
	}

}
