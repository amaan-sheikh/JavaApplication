package com.sios.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public SessionFactory getSessionFactory() {
		if (null == entityManagerFactory.unwrap(SessionFactory.class)) {
			throw new NullPointerException("Factory not initialized");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}
