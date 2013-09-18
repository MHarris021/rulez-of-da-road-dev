package com.darcstarsolutions.games.rulezofdaroad.core;

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

import com.darcstarsolutions.games.rulezofdaroad.config.builders.BuildersTestConfiguration;
import com.darcstarsolutions.games.rulezofdaroad.core.builders.PlayerRuleBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BuildersTestConfiguration.class)
public class GameRuleTest {

	@Resource
	private PlayerRuleBuilder playerRuleBuilder;

	private GameRule gameRule;

	private List<Rule<Player>> environmentRules;

	private List<Game> games;

	private List<Player> players;

	@Before
	public void setup() {
		gameRule = new GameRule();
		gameRule.setName("Game rules");
		gameRule.setDescription("Environmental Effects");
		environmentRules = new ArrayList<Rule<Player>>();
		playerRuleBuilder.createRule("Fog")
				.setDescription("Fog removes 1 point").setPoints(-1);
		environmentRules.add(playerRuleBuilder.build());
		gameRule.setPlayerRules(environmentRules);

		players = new ArrayList<Player>();
		Player player = new Player();
		player.setName("Test");
		player.setScore(10);
		players.add(player);
		games = new ArrayList<Game>();
		Game game = new Game();
		game.setName("Regular Game");
		List<Rule<Game>> gameRules = new ArrayList<Rule<Game>>();
		gameRules.add(gameRule);
		game.setRules(gameRules);
		game.setPlayers(players);
		games.add(game);

	}

	@After
	public void teardown() {
		gameRule = null;
		environmentRules = null;
		games = null;
		players = null;
	}

	@Test
	public void testApplyTo() {
		gameRule.applyTo(games.toArray(new Game[] {}));
		Player player = games.get(0).getPlayers().get(0);
		assertNotNull(player);
		assertEquals(9, player.getScore());
	}

}
