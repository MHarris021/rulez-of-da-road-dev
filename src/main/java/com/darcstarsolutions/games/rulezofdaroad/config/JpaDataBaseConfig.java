package com.darcstarsolutions.games.rulezofdaroad.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
public class JpaDataBaseConfig {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JpaDataBaseConfig.class);

	@Value("${DATABASE_URL}")
	private String suppliedDbUrl;

	@Bean
	public URI databaseUrl() {
		URI uri = null;
		try {
			uri = new URI(suppliedDbUrl);
		} catch (URISyntaxException e) {
			LOGGER.error("Invalid URI Syntax: " + suppliedDbUrl);
			throw new BeanCreationException("Invalid URI Syntax: "
					+ suppliedDbUrl);
		}
		return uri;
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {

		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		URI databaseUri = databaseUrl();

		StringBuilder url = new StringBuilder("jdbc:postgresql://");
		url.append(databaseUri.getHost());
		url.append(":" + databaseUri.getPort());
		url.append("/" + databaseUri.getPath());
		dataSource.setUrl(url.toString());
		dataSource.setDriverClassName("org.postgresql.Driver");
		String username = databaseUri.getUserInfo().split(":")[0];
		dataSource.setUsername(username);
		String password = databaseUri.getUserInfo().split(":")[1];
		dataSource.setPassword(password);
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
