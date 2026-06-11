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
				"com.sigep.common.histoGbk.repository",
		},
		entityManagerFactoryRef = "histoGbkEntityManagerFactory",
		transactionManagerRef = "histoGbkTransactionManager"
		)
public class HistoGbkDataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix = "datasource.histo-gbk")
	public DataSource histoGbkDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean histoGbkEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(histoGbkDataSource())
				.packages("com.sigep.common.histoGbk.entity")
				.persistenceUnit("histoGbkPU")
				.build();
	}
	
	@Bean
	public PlatformTransactionManager histoGbkTransactionManager(@Qualifier("histoGbkEntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
