package com.trepudox.kafkahexagonal;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamoDBRepositories
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		throw new UnsupportedOperationException("Projeto ainda nao funcional, apenas rascunho");
		SpringApplication.run(Application.class, args);
	}

}
