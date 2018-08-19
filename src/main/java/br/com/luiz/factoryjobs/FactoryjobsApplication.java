package br.com.luiz.factoryjobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FactoryjobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryjobsApplication.class, args);
	}
}
