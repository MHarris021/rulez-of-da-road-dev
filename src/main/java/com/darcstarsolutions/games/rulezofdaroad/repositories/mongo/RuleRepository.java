package com.darcstarsolutions.games.rulezofdaroad.repositories.mongo;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.darcstarsolutions.games.rulezofdaroad.core.Rule;

@Repository
public interface RuleRepository extends MongoRepository<Rule<?>, BigInteger> {

}
