package com.maven.DependencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.maven.Interfaces")
public class AppConfig {
	@Bean
	public void fun() {
		
	}
}
