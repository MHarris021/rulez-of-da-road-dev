package com.darcstarsolutions.games.rulezofdaroad.repositories.mongo;

import static org.junit.Assert.*;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = { "mongo" })
@ContextConfiguration(locations = "file:src/test/resources/mongoContext.xml")
public class GameTemplateRepositoryTest {

	@Resource
	private GameTemplateRepository gameTemplateRepository;
	
	@Test
	public void testRepoExistence() {
		assertNotNull(gameTemplateRepository);
	}

}
