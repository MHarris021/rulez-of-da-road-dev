package com.darcstarsolutions.games.rulezofdaroad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.darcstarsolutions.games.rulezofdaroad.config")
public class ApplicationConfig {

	@Bean(name = "jpaPackagesToScanList")
	public List<String> jpaPackagesToScanList() {
		List<String> packages = new ArrayList<String>();
		packages.add("com.darcstarsolutions.user.repositories.jpa");
		return packages;
	}

	@Bean
	public static PropertyPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
		
		return propertyPlaceholderConfigurer;
	}
}
