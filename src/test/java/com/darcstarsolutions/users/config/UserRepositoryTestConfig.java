package com.darcstarsolutions.users.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Profile(value="dev-local")
public class UserRepositoryTestConfig {

	@Bean(name = "dataSource", destroyMethod = "shutdown")
	public EmbeddedDatabase embeddedDatabase() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.HSQL);
		EmbeddedDatabase embeddedDatabase = builder.build();
		return embeddedDatabase;
	}

	@Bean(name = "entityProperties")
	public Properties properties() {
		Properties properties = new Properties();
		properties
				.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "create-drop");

		return properties;
	}
}
