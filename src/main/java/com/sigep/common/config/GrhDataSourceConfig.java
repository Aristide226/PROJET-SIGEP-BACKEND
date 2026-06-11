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
				"com.sigep.grh.repository",
				"com.sigep.grh.view.repository",
		},
		entityManagerFactoryRef = "grhEntityManagerFactory",
		transactionManagerRef = "grhTransactionManager"
		)
public class GrhDataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix = "datasource.grh")
	public DataSource grhDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean grhEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(grhDataSource())
				.packages("com.sigep.grh.entity", "com.sigep.grh.view..entity")
				.persistenceUnit("grhPU")
				.build();
	}
	
	@Bean
	public PlatformTransactionManager grhTransactionManager(@Qualifier("grhEntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
