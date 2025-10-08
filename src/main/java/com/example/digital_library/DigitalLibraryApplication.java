package com.example.digital_library;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.digital_library.mapper")
public class DigitalLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalLibraryApplication.class, args);
	}

}
