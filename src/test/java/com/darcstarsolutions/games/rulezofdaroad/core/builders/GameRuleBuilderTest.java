package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.config.builders.BuildersTestConfiguration;
import com.darcstarsolutions.games.rulezofdaroad.core.GameRule;
import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerRule;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BuildersTestConfiguration.class)
public class GameRuleBuilderTest {

	@Resource
	private GameRuleBuilder gameRuleBuilder;

	@Resource
	private PlayerRule fog;

	@Resource
	private List<Rule<Player>> defaultPlayerRules;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExistence() throws Exception {
		assertNotNull(gameRuleBuilder);
	}

	@Test
	public void testGameRuleCreation() throws Exception {
		gameRuleBuilder.createRule("Test Rule");
		GameRule gameRule = gameRuleBuilder.build();
		assertNotNull(gameRule);
		assertEquals("Test Rule", gameRule.getName());
		assertEquals("", gameRule.getDescription());
		assertNotNull(gameRule.getPlayerRules());
		assertEquals(0, gameRule.getPlayerRules().size());
	}

	@Test
	public void testSetdescription() throws Exception {
		gameRuleBuilder.createRule("Test Rule");
		gameRuleBuilder.setDescription("I do nothing!");
		GameRule gameRule = gameRuleBuilder.build();
		assertNotNull(gameRule);
		assertEquals("Test Rule", gameRule.getName());
		assertEquals("I do nothing!", gameRule.getDescription());
		assertNotNull(gameRule.getPlayerRules());
		assertEquals(0, gameRule.getPlayerRules().size());
	}

	@Test
	public void testSetPlayerRulesPlayerRuleArray() {
		gameRuleBuilder.createRule("Test Rule");
		gameRuleBuilder.setDescription("I do nothing!");
		gameRuleBuilder.setPlayerRules(fog);
		GameRule gameRule = gameRuleBuilder.build();
		assertNotNull(gameRule);
		assertEquals("Test Rule", gameRule.getName());
		assertEquals("I do nothing!", gameRule.getDescription());
		assertNotNull(gameRule.getPlayerRules());
		assertEquals(1, gameRule.getPlayerRules().size());
		assertEquals("Fog", gameRule.getPlayerRules().get(0).getName());
	}

	@Test
	public void testSetPlayerRulesListOfPlayerRule() {
		gameRuleBuilder.createRule("Test Rule");
		gameRuleBuilder.setDescription("I do nothing!");
		gameRuleBuilder.setPlayerRules(defaultPlayerRules);
		GameRule gameRule = gameRuleBuilder.build();
		assertNotNull(gameRule);
		assertEquals("Test Rule", gameRule.getName());
		assertEquals("I do nothing!", gameRule.getDescription());
		assertNotNull(gameRule.getPlayerRules());
		assertEquals(3, gameRule.getPlayerRules().size());
		assertEquals("Animals", gameRule.getPlayerRules().get(0).getName());
	}

}
