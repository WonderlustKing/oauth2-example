package com.wonderlustking.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.wonderlustking.oauth2.config", "com.wonderlustking.oauth2.user"})
public class Oauth2SpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SpringBootExampleApplication.class, args);
	}
}
