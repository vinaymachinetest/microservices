package com.study.microservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;



@SpringBootApplication
@ComponentScan(basePackages = { "com.study" })

public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}
	
	/*@Bean
	public LocaleResolver localeResolver() {
		
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}*/
	
	//simpler form of above
	@Bean
	public LocaleResolver localeResolver_simpler() {
		
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	//it is not required if we configure in properties file
	/*@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		
		ResourceBundleMessageSource messageSource =  new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}*/
	
	
}
