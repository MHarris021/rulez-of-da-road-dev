package com.darcstarsolutions.games.rulezofdaroad.config;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.common.utils.ValidationUtils;
import com.darcstarsolutions.games.rulezofdaroad.config.utils.UtilsConfig;
import com.darcstarsolutions.users.core.UserAccount;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=UtilsConfig.class)
public class UtilsConfigTest {

	@Autowired
	private Validator validator;
	
	@Autowired
	private ValidationUtils validationUtils;
	
	@Test
	public void testValidator() {
		assertNotNull(validator);
	}
	
	@Test
	public void testValidatorWorks() {
		assertNotNull(validator);
		UserAccount userAccount = new UserAccount("test", "test");
		validator.validate(userAccount);
		assertEquals("test", userAccount.getName());
		assertEquals("test", userAccount.getPassword());
	}

	@Test
	public void testValidatorWorksOnBadData() {
		assertNotNull(validator);
		UserAccount userAccount = new UserAccount("", "");
		Set<ConstraintViolation<UserAccount>> constaintViolations = validator.validate(userAccount);
		assertEquals(2, constaintViolations.size());
		for(ConstraintViolation<UserAccount> constraintViolation : constaintViolations){
			System.err.println(constraintViolation.getMessage());
		}
	}
	
	@Test
	public void testValidationUtils() {
		assertNotNull(validationUtils);
	}
	
	@Test
	public void testValidationUtilsWorks() {
		assertNotNull(validationUtils);
		UserAccount userAccount = new UserAccount("test", "test");
		validationUtils.validate(userAccount);
		assertEquals("test", userAccount.getName());
		assertEquals("test", userAccount.getPassword());
	}

	@Test(expected=ConstraintViolationException.class)
	public void testValidationUtilsThrowsExceptionOnBadData() {
		assertNotNull(validationUtils);
		UserAccount userAccount = new UserAccount("", "");
		validationUtils.validate(userAccount);
		assertEquals("test", userAccount.getName());
		assertEquals("test", userAccount.getPassword());
	}

	
	
}
