package com.darcstarsolutions.games.rulezofdaroad.config.builders;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.core.GameTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.Player;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerRule;
import com.darcstarsolutions.games.rulezofdaroad.core.PlayerTemplate;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;
import com.darcstarsolutions.games.rulezofdaroad.core.SetScorePlayerRule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BuildersTestConfiguration.class)
public class BuildersTestConfigurationTest implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Resource
	private PlayerRule animals;

	@Resource
	private PlayerRule restaurants;

	@Resource
	private SetScorePlayerRule cemeteries;

	@Autowired
	private List<Rule<Player>> playerRules;

	@Resource
	private PlayerTemplate defaultPlayerTemplate;

	@Resource
	private List<PlayerTemplate> defaultPlayerTemplates;

	@Resource
	private GameTemplate defaultGameTemplate;

	@Resource
	private Player defaultPlayer;

	@Test
	public void testAnimals() {
		assertNotNull(animals);
		assertEquals("Animals", animals.getName());
		PlayerRule playerRule = (PlayerRule) applicationContext
				.getBean("animals");
		assertSame(animals, playerRule);
	}

	@Test
	public void testRestaurants() {
		assertNotNull(restaurants);
		assertEquals("Restaurants", restaurants.getName());
		PlayerRule playerRule = (PlayerRule) applicationContext
				.getBean("restaurants");
		assertSame(restaurants, playerRule);
	}

	@Test
	public void testCemeteries() {
		assertNotNull(cemeteries);
		assertEquals("Cemeteries", cemeteries.getName());
		PlayerRule playerRule = (PlayerRule) applicationContext
				.getBean("cemeteries");
		assertSame(cemeteries, playerRule);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testPlayerRules() {
		assertNotNull(playerRules);
		assertEquals(3, playerRules.size());
		List<PlayerRule> rules = (List<PlayerRule>) applicationContext
				.getBean("defaultPlayerRules");
		assertNotNull(rules);
		assertNotSame(playerRules, rules);
	}

	@Test
	public void testPlayerTemplate() {
		assertNotNull(defaultPlayerTemplate);
		assertEquals("Default Player Template",
				defaultPlayerTemplate.getDescription());
		PlayerTemplate playerTemplate = (PlayerTemplate) applicationContext
				.getBean("defaultPlayerTemplate");
		assertNotNull(playerTemplate);
		assertNotSame(defaultPlayerTemplate, playerTemplate);
		assertNotSame(defaultPlayerTemplate.getRules(),
				playerTemplate.getRules());
	}

	@Test
	public void testDefaultPlayerTemplates() {
		assertNotNull(defaultPlayerTemplates);
		assertEquals(2, defaultPlayerTemplates.size());
		PlayerTemplate playerTemplate1 = defaultPlayerTemplates.get(0);
		assertNotNull(playerTemplate1);
		PlayerTemplate playerTemplate2 = defaultPlayerTemplates.get(1);
		assertNotNull(playerTemplate2);
		assertNotSame(playerTemplate1, playerTemplate2);
		assertEquals(playerTemplate1.getDescription(),
				playerTemplate2.getDescription());
	}

	@Test
	public void testDefaultGameTemplate() {
		assertNotNull(defaultGameTemplate);
		assertEquals(2, defaultGameTemplate.getPlayerTemplates().size());
		GameTemplate gameTemplate = (GameTemplate) applicationContext
				.getBean("defaultGameTemplate");
		assertNotNull(gameTemplate);
		assertNotSame(defaultGameTemplate, gameTemplate);
	}

	@Test
	public void testDefaultPlayer() {
		assertNotNull(defaultPlayer);
		assertEquals(Player.DEFAULT_PLAYER_NAME, defaultPlayer.getName());
		assertNotNull(defaultPlayer.getRules());
		assertEquals(3, defaultPlayer.getRules().size());
		Player player = (Player) applicationContext.getBean("defaultPlayer");
		assertNotNull(player);
		assertNotSame(defaultPlayer, player);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}
