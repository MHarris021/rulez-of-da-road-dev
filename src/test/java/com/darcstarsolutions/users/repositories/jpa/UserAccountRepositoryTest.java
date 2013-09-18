package com.darcstarsolutions.users.repositories.jpa;

import static org.junit.Assert.*;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.darcstarsolutions.users.config.UserRepositoryConfig;
import com.darcstarsolutions.users.config.UserRepositoryIntegrationTestConfiguration;
import com.darcstarsolutions.users.core.UserAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = { "jpa", "dev-integration" })
@ContextConfiguration(classes = {
		UserRepositoryIntegrationTestConfiguration.class,
		UserRepositoryConfig.class })
public class UserAccountRepositoryTest {

	@Resource
	private UserAccountRepository userAccountRepository;

	private UserAccount userAccount;

	@Before
	public void setup() {
		userAccount = new UserAccount("john", "smith");
	}

	@Test
	public void testRepositoryExists() {
		assertNotNull(userAccountRepository);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testSaveS() {
		userAccountRepository.save(userAccount);
		BigInteger id = userAccount.getId();
		assertNotNull(id);
		assertEquals(BigInteger.ONE, id);
		long total = userAccountRepository.count();
		assertEquals(1, total);
		UserAccount returnedUserAccount = userAccountRepository.findOne(id);
		assertEquals("john", returnedUserAccount.getName());
	}

	@Test
	public void testNotExists() {
		assertFalse(userAccountRepository.exists(BigInteger.ONE));
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testDeleteT() {
		userAccountRepository.save(userAccount);
		BigInteger id = userAccount.getId();
		assertNotNull(id);
		userAccountRepository.delete(id);
		long count = userAccountRepository.count();
		assertEquals(0, count);
		assertNull(userAccountRepository.findOne(id));
	}

}
