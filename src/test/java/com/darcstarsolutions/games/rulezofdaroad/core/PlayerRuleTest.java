package com.darcstarsolutions.games.rulezofdaroad.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.config.builders.BuildersConfig;
import com.darcstarsolutions.games.rulezofdaroad.config.utils.UtilsConfig;
import com.darcstarsolutions.games.rulezofdaroad.core.builders.PlayerRuleBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UtilsConfig.class, BuildersConfig.class })
public class PlayerRuleTest {

	private Player player;

	@Autowired
	private PlayerRuleBuilder playerRuleBuilder;

	@Before
	public void init() {
		player = new Player();
		player.setScore(0);
	}

	@Test
	public void testApplyTo() {
		playerRuleBuilder.createRule("Animals", "Animals get 1 point", 1L);
		PlayerRule playerRule = playerRuleBuilder.build();
		playerRule.applyTo(player);
		assertEquals(1, player.getScore());
	}

}
