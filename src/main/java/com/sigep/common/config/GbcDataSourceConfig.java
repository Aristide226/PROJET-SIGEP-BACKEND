package com.sigep.common.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = {
				"com.sigep.gbc.repository",
				"com.sigep.gbc.view.repository"
		},
		entityManagerFactoryRef = "gbcEntityManagerFactory",
		transactionManagerRef = "gbcTransactionManager"
		)
public class GbcDataSourceConfig {

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "datasource.gbc")
	public HikariDataSource gbcDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean gbcEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(gbcDataSource())
				.packages("com.sigep.gbc.entity", "com.sigep.gbc.view.entity")
				.persistenceUnit("gbcPU")
				.build();
	}
	
	@Primary
	@Bean
	public PlatformTransactionManager gbcTransactionManager(@Qualifier("gbcEntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
