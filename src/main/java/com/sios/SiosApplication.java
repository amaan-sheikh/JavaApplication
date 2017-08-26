package com.sios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
public class SiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiosApplication.class, args);
	}
	
	
	@Bean
    public HttpMessageConverters customConverters() {
        HttpMessageConverter<?> jacksonMessageConverter = new MappingJackson2HttpMessageConverter();
//        HttpMessageConverter<?> another = ...
        return new HttpMessageConverters(jacksonMessageConverter);
    }
	
}
