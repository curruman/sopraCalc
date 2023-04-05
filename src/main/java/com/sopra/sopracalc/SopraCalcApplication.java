package com.sopra.sopracalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sopra")
public class SopraCalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SopraCalcApplication.class, args);
	}

}
