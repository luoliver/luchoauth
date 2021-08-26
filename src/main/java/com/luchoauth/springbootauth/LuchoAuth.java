package com.luchoauth.springbootauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.luchoauth.springbootauth.modelodatos.modelo" })
@EnableJpaRepositories(basePackages = { "com.luchoauth.springbootauth.modelodatos.dao" })
public class LuchoAuth {

	public static void main(String[] args) {
		SpringApplication.run(LuchoAuth.class, args);
	}

}
