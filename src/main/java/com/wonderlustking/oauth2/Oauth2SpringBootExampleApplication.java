package com.wonderlustking.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.wonderlustking.oauth2.config"}, excludeFilters = {
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Oauth2SpringBootExampleApplication.class) })
public class Oauth2SpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SpringBootExampleApplication.class, args);
	}
}
