package com.darcstarsolutions.games.rulezofdaroad.repositories.mongo;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;

@Repository
public interface PlayerTemplateRepository extends
		MongoRepository<PlayerTemplate, BigInteger> {

}
