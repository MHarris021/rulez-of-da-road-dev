package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.common.utils.ValidationUtils;
import com.darcstarsolutions.games.rulezofdaroad.config.builders.BuildersConfig;
import com.darcstarsolutions.games.rulezofdaroad.config.utils.UtilsConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UtilsConfig.class, BuildersConfig.class })
public class RuleBuilderTest {

	@Resource
	private RuleBuilder<?, ?, ?> playerRuleBuilder;

	@Test
	public void testRuleBuilderExistence() {
		assertNotNull(playerRuleBuilder);
	}

	@Test
	public void testValidationUtilsRuleBuilderExistence() {
		assertNotNull(playerRuleBuilder);
		ValidationUtils validationUtils = playerRuleBuilder.getValidationUtils();
		assertNotNull(validationUtils);
	}

}
