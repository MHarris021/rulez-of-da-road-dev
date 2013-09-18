package com.darcstarsolutions.games.rulezofdaroad.config;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.common.utils.ValidationUtils;
import com.darcstarsolutions.games.rulezofdaroad.config.builders.BuildersConfig;
import com.darcstarsolutions.games.rulezofdaroad.config.utils.UtilsConfig;
import com.darcstarsolutions.users.core.builders.UserAccountBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UtilsConfig.class, BuildersConfig.class })
public class BuildersConfigTest implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Test
	public void testBuilderWorks() {
		UserAccountBuilder userAccountBuilder = applicationContext
				.getBean(UserAccountBuilder.class);
		assertNotNull(userAccountBuilder);
	}

	@Test
	public void testAutowiring() {
		UserAccountBuilder userAccountBuilder = applicationContext
				.getBean(UserAccountBuilder.class);
		assertNotNull(userAccountBuilder);
		ValidationUtils validationUtils = userAccountBuilder
				.getValidationUtils();
		assertNotNull(validationUtils);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}
