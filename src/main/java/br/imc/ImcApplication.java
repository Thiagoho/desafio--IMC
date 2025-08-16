package br.imc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImcApplication.class, args);
		System.out.println("What is my name?");
	}

}
