package com.lopez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LopezT1MsCitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LopezT1MsCitasApplication.class, args);
	}

}
