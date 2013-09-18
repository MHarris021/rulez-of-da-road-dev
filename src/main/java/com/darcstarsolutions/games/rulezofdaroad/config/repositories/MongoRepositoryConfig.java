package com.darcstarsolutions.games.rulezofdaroad.config.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@Profile(value={"mongo", "prod"})
@EnableMongoRepositories(basePackages = "com.darcstarsolutions.games.rulezofdaroad.repositories.mongo")
public class MongoRepositoryConfig extends AbstractMongoConfiguration {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MongoRepositoryConfig.class);

	@Value("${MONGOHQ_URL}")
	private String databaseUrl;

	@Bean
	public MongoClientURI mongoDatabaseURI() {
		MongoClientURI mongoDbURI = null;
		LOGGER.debug("Creating MongoDB Client using: " + databaseUrl);
		mongoDbURI = new MongoClientURI(databaseUrl);
		return mongoDbURI;
	}

	@Override
	protected String getDatabaseName() {
		return mongoDatabaseURI().getDatabase();
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		LOGGER.info("Creating MongoDB Client using: " + databaseUrl);
		MongoClient mongoClient = new MongoClient(mongoDatabaseURI());
		return mongoClient;
	}

}
