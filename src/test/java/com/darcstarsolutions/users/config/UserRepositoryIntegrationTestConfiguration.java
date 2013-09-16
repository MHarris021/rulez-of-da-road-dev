package com.darcstarsolutions.users.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
@Profile(value = "dev-integration")
public class UserRepositoryIntegrationTestConfiguration {

	@Bean(name = "dataSource")
	public DataSource dataSource() {

		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		String url = "jdbc:postgresql://ec2-54-235-134-222.compute-1.amazonaws.com:5432/ddtf933fhn8g0s?user=wzcnvcjdchpleo&password=5mSY6nJEOqmKnogUXjGWRkwgYo";

		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(url);
		dataSource.setSuppressClose(true);
		Properties connectionProperties = new Properties();
		connectionProperties.put("ssl", "true");
		connectionProperties.put("sslfactory",
				"org.postgresql.ssl.NonValidatingFactory");
		dataSource.setConnectionProperties(connectionProperties);

		return dataSource;
	}

	@Bean(name = "entityProperties")
	public Properties properties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				"org.hibernate.dialect.PostgreSQL82Dialect");
		properties.put("hibernate.hbm2ddl.auto", "create-drop");
		return properties;

	}

}
