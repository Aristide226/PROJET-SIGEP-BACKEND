package com.sigep.common.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
				"com.sigep.gim.repository",
				"com.sigep.gim.view.repository",
		},
		entityManagerFactoryRef = "gimEntityManagerFactory",
		transactionManagerRef = "gimTransactionManager"
		)
public class GimDataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix = "datasource.gim")
	public DataSource gimDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean gimEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(gimDataSource())
				.packages("com.sigep.gim.entity", "com.sigep.gim.view..entity")
				.persistenceUnit("gimPU")
				.build();
	}
	
	@Bean
	public PlatformTransactionManager gimTransactionManager(@Qualifier("gimEntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
