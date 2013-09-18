package com.darcstarsolutions.users.config;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.users.repositories.jpa.UserAccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles={"jpa", "dev-local"})
@ContextConfiguration(classes = { UserRepositoryTestConfig.class,
		UserRepositoryConfig.class })
public class UserRepositoryConfigTest {

	@Resource
	private UserAccountRepository userAccountRepository;

	@Test
	public void testExistence() {
		assertNotNull(userAccountRepository);
	}

}
