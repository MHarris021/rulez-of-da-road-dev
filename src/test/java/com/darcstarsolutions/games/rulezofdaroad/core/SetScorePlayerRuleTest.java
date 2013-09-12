package com.darcstarsolutions.games.rulezofdaroad.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.config.BuildersConfig;
import com.darcstarsolutions.games.rulezofdaroad.config.UtilsConfig;
import com.darcstarsolutions.games.rulezofdaroad.core.builders.PlayerRuleBuilder;
import com.darcstarsolutions.games.rulezofdaroad.core.builders.SetScorePlayerRuleBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UtilsConfig.class, BuildersConfig.class })
public class SetScorePlayerRuleTest {

	private Player player;

	@Autowired
	private SetScorePlayerRuleBuilder setScorePlayerRuleBuilder;
	
	@Autowired
	private PlayerRuleBuilder playerRuleBuilder;

	@Before
	public void init() {
		player = new Player();
		player.setScore(0);
	}
	
	@Test
	public void testExistence() {
		assertNotNull(setScorePlayerRuleBuilder);
		assertNotNull(playerRuleBuilder);
		assertNotEquals(playerRuleBuilder, setScorePlayerRuleBuilder);
	}

	@Test
	public void testApplyTo() {
		setScorePlayerRuleBuilder.createRule("Cemetery", "Cemetries set points to 0", 0L);
		SetScorePlayerRule playerRule = setScorePlayerRuleBuilder.build();
		playerRule.applyTo(player);
		assertEquals(0, player.getScore());
	}
	
	@Test
	public void testBaseApplyTo() {
		playerRuleBuilder.createRule("Animals", "1 point", 1L);
		PlayerRule playerRule2 = playerRuleBuilder.build();
		playerRule2.applyTo(player);
		assertEquals(1, player.getScore());
	}
	
	@Test
	public void testTwoRules() {
		setScorePlayerRuleBuilder.createRule("Cemetery", "Cemetries set points to 0", 0L);
		SetScorePlayerRule playerRule = setScorePlayerRuleBuilder.build();
		playerRule.applyTo(player);
		assertEquals(0, player.getScore());
		playerRuleBuilder.createRule("Animals", "1 point", 1L);
		PlayerRule playerRule2 = playerRuleBuilder.build();
		playerRule2.applyTo(player);
		assertEquals(1, player.getScore());
	}

}
