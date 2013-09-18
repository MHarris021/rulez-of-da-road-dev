package com.darcstarsolutions.games.rulezofdaroad.repositories.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.core.PlayerRule;
import com.darcstarsolutions.games.rulezofdaroad.core.Rule;
import com.darcstarsolutions.games.rulezofdaroad.core.SetScorePlayerRule;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = { "mongo" })
@ContextConfiguration(locations = "file:src/test/resources/mongoContext.xml")
public class RuleRepositoryTest {

	@Resource
	private RuleRepository ruleRepository;

	private PlayerRule playerRule;

	@Before
	public void setup() {
		playerRule = new PlayerRule();
		playerRule.setName("Animals");
		playerRule.setDescription("Animals worth 1");
		playerRule.setPoints(1L);

	}

	@After
	public void cleanupRepository() {
		ruleRepository.deleteAll();
		playerRule = null;
	}

	@Test
	public void testRepositoryExistence() {
		assertNotNull(ruleRepository);
	}

	@Test
	public void testRepositorySave() {
		assertNotNull(ruleRepository);
		PlayerRule playerRule2 = ruleRepository.save(playerRule);
		assertNotNull(playerRule2);
		assertEquals(playerRule.getName(), playerRule2.getName());
		assertEquals(playerRule.getDescription(), playerRule2.getDescription());
		assertEquals(playerRule.getPoints(), playerRule2.getPoints());
	}
	
	@Test
	public void testRepositorySaveMultipleTypes() {
		assertNotNull(ruleRepository);
		PlayerRule playerRule2 = ruleRepository.save(playerRule);
		assertNotNull(playerRule2);
		SetScorePlayerRule setScorePlayerRule = new SetScorePlayerRule();
		setScorePlayerRule.setName("Cemetery");
		setScorePlayerRule.setName("Cemetery costs all points");
		setScorePlayerRule.setPoints(0);
		SetScorePlayerRule setScorePlayerRule2 = ruleRepository.save(setScorePlayerRule);
		assertEquals(setScorePlayerRule.getName(), setScorePlayerRule2.getName());
		assertEquals(setScorePlayerRule.getDescription(), setScorePlayerRule2.getDescription());
		assertEquals(setScorePlayerRule.getPoints(), setScorePlayerRule2.getPoints());
	}

	@Test
	public void testFindAll() {
		assertNotNull(ruleRepository);
		long count = ruleRepository.count();
		assertEquals(0L, count);
		List<Rule<?>> rules = ruleRepository.findAll();
		assertNotNull(rules);
		ruleRepository.save(playerRule);
		count = ruleRepository.count();
		assertEquals(1L, count);
		rules = ruleRepository.findAll();
		assertEquals(1, rules.size());
	}
	
	@Test
	public void testUniqueNameConstraint() {
		assertNotNull(ruleRepository);
		ruleRepository.save(playerRule);
		ruleRepository.save(playerRule);
		long count = ruleRepository.count();
		assertEquals(1L, count);
		
	}

}
