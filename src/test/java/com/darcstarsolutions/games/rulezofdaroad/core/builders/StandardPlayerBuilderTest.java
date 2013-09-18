package com.darcstarsolutions.games.rulezofdaroad.core.builders;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.config.builders.BuildersConfig;
import com.darcstarsolutions.games.rulezofdaroad.config.utils.UtilsConfig;
import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerRule;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;
import com.darcstarsolutions.games.rulezofdaroad.core.SetScorePlayerRule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UtilsConfig.class, BuildersConfig.class })
public class StandardPlayerBuilderTest {

	@Resource
	private StandardPlayerTemplateBuilder standardPlayerTemplateBuilder;

	@Resource
	private StandardPlayerBuilder standardPlayerBuilder;

	@Resource
	private PlayerRuleBuilder playerRuleBuilder;

	@Resource
	private SetScorePlayerRuleBuilder setScorePlayerRuleBuilder;

	private List<Rule<Player>> rules;

	private PlayerTemplate playerTemplate;

	@Before
	public void setup() {
		rules = new ArrayList<Rule<Player>>();
		playerRuleBuilder.createRule("Animals", "Give 1 point", 1L);
		PlayerRule playerRule = playerRuleBuilder.build();
		rules.add(playerRule);
		setScorePlayerRuleBuilder.createRule("Cemetery",
				"Cemetries set points to 0", 0L);
		SetScorePlayerRule setScorePlayerRule = setScorePlayerRuleBuilder
				.build();
		rules.add(setScorePlayerRule);
		standardPlayerTemplateBuilder.createPlayerTemplate(rules)
				.setDescription("Very basic Player");
		playerTemplate = standardPlayerTemplateBuilder.build();
	}

	@After
	public void teardown() {
		rules = null;
		playerTemplate = null;
	}

	@Test
	public void testExistence() {
		assertNotNull(standardPlayerBuilder);
	}

	@Test
	public void testCreatePlayer() {
		standardPlayerBuilder.createPlayer(playerTemplate);
		Player player = standardPlayerBuilder.build();
		assertNotNull(player);
		assertEquals(rules, player.getRules());
	}
	
	@Test
	public void testSetPlayerName() {
		standardPlayerBuilder.createPlayer(playerTemplate);
		standardPlayerBuilder.setName("John");
		Player player = standardPlayerBuilder.build();
		assertNotNull(player);
		assertEquals("John", player.getName());
	}
	
	@Test
	public void testSetPlayerScore() {
		standardPlayerBuilder.createPlayer(playerTemplate);
		standardPlayerBuilder.setScore(10);
		Player player = standardPlayerBuilder.build();
		assertNotNull(player);
		assertEquals(10, player.getScore());
	}
	
	@Test
	public void testAllArguments() {
		standardPlayerBuilder.createPlayer(playerTemplate, "John", 10);
		Player player = standardPlayerBuilder.build();
		assertNotNull(player);
		assertEquals("John", player.getName());
		assertEquals(10, player.getScore());
	}

}
