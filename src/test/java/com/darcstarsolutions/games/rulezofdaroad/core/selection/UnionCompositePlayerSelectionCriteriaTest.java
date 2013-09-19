package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.darcstarsolutions.games.rulezofdaroad.config.builders.BuildersTestConfiguration;
import com.darcstarsolutions.games.rulezofdaroad.core.Player;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BuildersTestConfiguration.class)
public class UnionCompositePlayerSelectionCriteriaTest {

	@Resource
	private Player defaultPlayer;

	private UnionCompositePlayerSelectionCriteria criteria;

	private MaximumScoreBasedPlayerSelectionCriteria maximumScoreBasedPlayerSelectionCriteria;
	private MinimumScoreBasedPlayerSelectionCriteria minimumScoreBasedPlayerSelectionCriteria;

	private IncludeNamedPlayerSelectionCriteria includeNamedPlayerSelectionCriteria;

	@Before
	public void setUp() throws Exception {
		minimumScoreBasedPlayerSelectionCriteria = new MinimumScoreBasedPlayerSelectionCriteria(
				5);
		maximumScoreBasedPlayerSelectionCriteria = new MaximumScoreBasedPlayerSelectionCriteria(
				5);
		includeNamedPlayerSelectionCriteria = new IncludeNamedPlayerSelectionCriteria(
				"Dummy");

		Collection<PlayerSelectionCriteria<Player>> criterias = new ArrayList<>();
		criterias.add(minimumScoreBasedPlayerSelectionCriteria);
		criterias.add(maximumScoreBasedPlayerSelectionCriteria);
		criterias.add(includeNamedPlayerSelectionCriteria);
		criteria = new UnionCompositePlayerSelectionCriteria(criterias);
	}

	@After
	public void tearDown() throws Exception {
		minimumScoreBasedPlayerSelectionCriteria = null;
		maximumScoreBasedPlayerSelectionCriteria = null;
		includeNamedPlayerSelectionCriteria = null;
		criteria = null;
	}

	@Test
	public void testMatches() {
		assertFalse(minimumScoreBasedPlayerSelectionCriteria
				.matches(defaultPlayer));
		assertFalse(includeNamedPlayerSelectionCriteria.matches(defaultPlayer));
		assertTrue(maximumScoreBasedPlayerSelectionCriteria
				.matches(defaultPlayer));
		assertTrue(criteria.matches(defaultPlayer));
	}

	@Test
	public void testNotMatches() {
		assertFalse(minimumScoreBasedPlayerSelectionCriteria
				.matches(defaultPlayer));
		assertFalse(includeNamedPlayerSelectionCriteria.matches(defaultPlayer));
		maximumScoreBasedPlayerSelectionCriteria.setScore(-1);
		assertFalse(maximumScoreBasedPlayerSelectionCriteria
				.matches(defaultPlayer));
		assertFalse(criteria.matches(defaultPlayer));
	}

}
