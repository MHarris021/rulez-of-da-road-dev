package com.darcstarsolutions.games.rulezofdaroad.config.repositories;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@Configuration
@Profile(value={"jpa", "prod"})
public class JpaDataBaseConfig {

	private static final String DATABASE_DRIVER_CLASSNAME = "org.postgresql.Driver";

	private static final String JDBC_PREFIX = "jdbc:postgresql://";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JpaDataBaseConfig.class);

	@Value("${DATABASE_URL}")
	private String suppliedDbUrl;

	@Autowired
	private Environment environment;

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

		String databaseUrl = createConnectionURI(databaseUri);
		dataSource.setUrl(databaseUrl);
		dataSource.setDriverClassName(DATABASE_DRIVER_CLASSNAME);
		assignCredentials(dataSource, databaseUri);
		dataSource.setSuppressClose(true);
		Properties connectionProperties = createDatabaseProperties();
		dataSource.setConnectionProperties(connectionProperties);

		return dataSource;
	}

	/**
	 * @param databaseUri
	 */
	private String createConnectionURI(URI databaseUri) {
		StringBuilder url = new StringBuilder(JDBC_PREFIX);
		url.append(databaseUri.getHost());
		url.append(":" + databaseUri.getPort());
		url.append(databaseUri.getPath());
		return url.toString();
	}

	/**
	 * @return
	 */
	private Properties createDatabaseProperties() {
		Properties connectionProperties = new Properties();
		connectionProperties.put("ssl", "true");
		if (!environment.acceptsProfiles("prod")) {
			connectionProperties.put("sslfactory",
					"org.postgresql.ssl.NonValidatingFactory");
		}
		return connectionProperties;
	}

	/**
	 * @param dataSource
	 * @param databaseUri
	 */
	public void assignCredentials(SingleConnectionDataSource dataSource,
			URI databaseUri) {
		String username = databaseUri.getUserInfo().split(":")[0];
		dataSource.setUsername(username);
		String password = databaseUri.getUserInfo().split(":")[1];
		dataSource.setPassword(password);
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
