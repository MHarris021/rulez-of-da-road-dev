package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.config.BuildersConfig;
import com.darcstarsolutions.games.rulezofdaroad.config.UtilsConfig;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerRule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UtilsConfig.class, BuildersConfig.class })
public class PlayerRuleBuilderTest {

	@Autowired
	private PlayerRuleBuilder playerRuleBuilder;

	@Test
	public void testSetPoints() {
		playerRuleBuilder.createRule("Animals", "Give 1 point", 1L);
		PlayerRule playerRule = playerRuleBuilder.build();
		assertNotNull(playerRule);
		assertEquals("Animals", playerRule.getName());
		assertEquals(1L, playerRule.getPoints());
		assertEquals("Give 1 point", playerRule.getDescription());
	}

	@Test
	public void testCreateRule() {
		playerRuleBuilder.createRule("Animals");
		PlayerRule playerRule = playerRuleBuilder.build();
		assertNotNull(playerRule);
		assertEquals("Animals", playerRule.getName());
		assertEquals("", playerRule.getDescription());
	}

	@Test
	public void testSetDescription() {
		playerRuleBuilder.createRule("Animals", "Give 1 point");
		playerRuleBuilder.setPoints(1L);
		PlayerRule playerRule = playerRuleBuilder.build();
		assertNotNull(playerRule);
		assertEquals("Animals", playerRule.getName());
		assertEquals(1L, playerRule.getPoints());
		assertEquals("Give 1 point", playerRule.getDescription());
	}

	@Test
	public void testCascade() {
		playerRuleBuilder.createRule("Animals").setDescription("Give 1 point")
				.setPoints(1L);
		PlayerRule playerRule = playerRuleBuilder.build();
		assertNotNull(playerRule);
		assertEquals("Animals", playerRule.getName());
		assertEquals(1L, playerRule.getPoints());
		assertEquals("Give 1 point", playerRule.getDescription());
	}
}
