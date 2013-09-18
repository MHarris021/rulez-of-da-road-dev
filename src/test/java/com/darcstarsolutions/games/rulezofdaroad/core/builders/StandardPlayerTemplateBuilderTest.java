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
public class StandardPlayerTemplateBuilderTest {

	@Resource
	private StandardPlayerTemplateBuilder standardPlayerTemplateBuilder;

	@Resource
	private PlayerRuleBuilder playerRuleBuilder;

	@Resource
	private SetScorePlayerRuleBuilder setScorePlayerRuleBuilder;

	private List<Rule<Player>> rules;

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
	}

	@After
	public void teardown() {
		rules = null;
	}

	@Test
	public void testExistence() {
		assertNotNull(standardPlayerTemplateBuilder);
	}

	@Test
	public void testCreatePlayerTemplate() {
		standardPlayerTemplateBuilder.createPlayerTemplate(rules);
		PlayerTemplate playerTemplate = standardPlayerTemplateBuilder.build();
		assertNotNull(playerTemplate);
		assertEquals(rules, playerTemplate.getRules());
	}

	@Test
	public void testSetDescription() {
		standardPlayerTemplateBuilder.createPlayerTemplate(rules);
		standardPlayerTemplateBuilder.setDescription("Very basic Player");
		PlayerTemplate playerTemplate = standardPlayerTemplateBuilder.build();
		assertNotNull(playerTemplate);
		assertEquals("Very basic Player", playerTemplate.getDescription());
	}

	@Test
	public void testSetNumber() {
		standardPlayerTemplateBuilder.createPlayerTemplate(rules);
		standardPlayerTemplateBuilder.setNumber(2);
		PlayerTemplate playerTemplate = standardPlayerTemplateBuilder.build();
		assertNotNull(playerTemplate);
		assertEquals(2, playerTemplate.getNumber());
	}

	@Test
	public void testChaining() {
		standardPlayerTemplateBuilder.createPlayerTemplate(rules)
				.setDescription("Very basic Player").setNumber(2);
		PlayerTemplate playerTemplate = standardPlayerTemplateBuilder.build();
		assertNotNull(playerTemplate);
		assertEquals("Very basic Player", playerTemplate.getDescription());
		assertEquals(2, playerTemplate.getNumber());
	}

	@Test
	public void testRules() {
		standardPlayerTemplateBuilder.createPlayerTemplate(rules);
		PlayerTemplate playerTemplate = standardPlayerTemplateBuilder.build();
		assertNotNull(playerTemplate.getRules());
		assertEquals(2, playerTemplate.getRules().size());
		assertEquals(PlayerRule.class, playerTemplate.getRules().get(0)
				.getClass());
		assertEquals("Give 1 point", playerTemplate.getRules().get(0)
				.getDescription());
		assertEquals(SetScorePlayerRule.class, playerTemplate.getRules().get(1)
				.getClass());
		assertEquals("Cemetries set points to 0", playerTemplate.getRules()
				.get(1).getDescription());
	}

}
