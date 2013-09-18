package com.darcstarsolutions.games.rulezofdaroad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = { "classpath:database.properties",
		"classpath:mongo.properties" })
@ComponentScan(basePackages = {
		"com.darcstarsolutions.games.rulezofdaroad.config.utils",
		"com.darcstarsolutions.games.rulezofdaroad.config.builders",
		"com.darcstarsolutions.games.rulezofdaroad.config.repositories" })
public class ApplicationConfig {

	@Bean(name = "jpaPackagesToScanList")
	public List<String> jpaPackagesToScanList() {
		List<String> packages = new ArrayList<String>();
		packages.add("com.darcstarsolutions.user.repositories.jpa");
		return packages;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(true);
		return propertySourcesPlaceholderConfigurer;
	}

}
