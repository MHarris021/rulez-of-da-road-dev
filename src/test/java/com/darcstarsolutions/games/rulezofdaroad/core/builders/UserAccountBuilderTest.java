package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import static org.junit.Assert.*;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.config.BuildersConfig;
import com.darcstarsolutions.games.rulezofdaroad.config.UtilsConfig;
import com.darcstarsolutions.users.core.UserAccount;
import com.darcstarsolutions.users.core.builders.UserAccountBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UtilsConfig.class, BuildersConfig.class })
public class UserAccountBuilderTest implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Test
	public void testBasicCreation() {
		UserAccountBuilder userAccountBuilder = (UserAccountBuilder) applicationContext
				.getBean("userAccountBuilder");
		userAccountBuilder.createUserAccount("Test", "pass");
		assertNotNull(userAccountBuilder);
		UserAccount userAccount = userAccountBuilder.build();
		assertNotNull(userAccount);
		assertEquals("Test", userAccount.getName());
		assertEquals("pass", userAccount.getPassword());
	}

	@Test
	public void testAddingEmail() {
		UserAccountBuilder userAccountBuilder = (UserAccountBuilder) applicationContext
				.getBean("userAccountBuilder");
		userAccountBuilder.createUserAccount("Test", "pass");
		userAccountBuilder.setEmail("m@b.fu");
		assertNotNull(userAccountBuilder);
		UserAccount userAccount = userAccountBuilder.build();
		assertNotNull(userAccount);
		assertEquals("Test", userAccount.getName());
		assertEquals("pass", userAccount.getPassword());
		assertEquals("m@b.fu", userAccount.getEmail());
	}

	@Test(expected = ConstraintViolationException.class)
	public void testBasicValidation() {
		UserAccountBuilder userAccountBuilder = (UserAccountBuilder) applicationContext
				.getBean("userAccountBuilder");
		userAccountBuilder.createUserAccount("Test", "");
		assertNotNull(userAccountBuilder);
		UserAccount userAccount = userAccountBuilder.build();
		assertNotNull(userAccount);
		assertEquals("Test", userAccount.getName());
		assertEquals("", userAccount.getPassword());

	}

	@Test
	public void testBuilderChaining() {
		UserAccountBuilder userAccountBuilder = (UserAccountBuilder) applicationContext
				.getBean("userAccountBuilder");
		userAccountBuilder.createUserAccount("Test", "pass").setEmail("m@f.ca");
		assertNotNull(userAccountBuilder);
		UserAccount userAccount = userAccountBuilder.build();
		assertNotNull(userAccount);
		assertEquals("Test", userAccount.getName());
		assertEquals("pass", userAccount.getPassword());
		assertEquals("m@f.ca", userAccount.getEmail());
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testEmailViolation() {
		UserAccountBuilder userAccountBuilder = (UserAccountBuilder) applicationContext
				.getBean("userAccountBuilder");
		userAccountBuilder.createUserAccount("Test", "pass").setEmail("3");
		assertNotNull(userAccountBuilder);
		UserAccount userAccount = userAccountBuilder.build();
		assertNotNull(userAccount);
		assertEquals("Test", userAccount.getName());
		assertEquals("pass", userAccount.getPassword());
		assertEquals("3", userAccount.getEmail());
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testMultipleViolations() {
		UserAccountBuilder userAccountBuilder = (UserAccountBuilder) applicationContext
				.getBean("userAccountBuilder");
		userAccountBuilder.createUserAccount("", "");
		assertNotNull(userAccountBuilder);
		UserAccount userAccount = userAccountBuilder.build();
		assertNotNull(userAccount);
		assertEquals("", userAccount.getName());
		assertEquals("", userAccount.getPassword());
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}

}
