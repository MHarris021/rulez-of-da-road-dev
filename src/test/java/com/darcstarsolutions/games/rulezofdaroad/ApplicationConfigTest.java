package com.darcstarsolutions.games.rulezofdaroad;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.users.repositories.jpa.UserAccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles={"jpa"})
@PropertySource(value = "classpath:database.properties")
@ContextConfiguration(classes = ApplicationConfig.class)
public class ApplicationConfigTest {

	@Resource
	private UserAccountRepository userAccountRepository;

	@Test
	public void testConfig() {
		assertNotNull(userAccountRepository);
	}

}
