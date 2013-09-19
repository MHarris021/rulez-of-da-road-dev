package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public class ProbabilityBasedPlayerSelectionCriteriaTest {

	private static Player defaultPlayer;

	private static List<ProbabilityBasedPlayerSelectionCriteria> criterias;

	private static int iterations = 1000000;

	private static Random random;

	@BeforeClass
	public static void setUp() throws Exception {
		defaultPlayer = new Player();
		random = new Random();
		criterias = new ArrayList<ProbabilityBasedPlayerSelectionCriteria>(
				iterations);
		for (int i = 0; i < (iterations / 10000); i++) {
			ProbabilityBasedPlayerSelectionCriteria criteria = new ProbabilityBasedPlayerSelectionCriteria(
					random.nextDouble());
			criterias.add(criteria);
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		random = null;
		criterias = null;
	}

	@Test
	public void testMatches1() {
		for (int index = 0; index < (criterias.size() / 5); index++) {
			ProbabilityBasedPlayerSelectionCriteria criteria = criterias
					.get(index);
			double expectedOutcome = criteria.getProbability() * iterations;
			double actualOutcome = 0;
			for (int i = 0; i < iterations; i++) {
				if (criteria.matches(defaultPlayer)) {
					actualOutcome += 1;
				}
			}
			assertEquals(expectedOutcome, actualOutcome, 0.005 * iterations);
			// System.out.println(String.format(
			// "Probability %s passes assertion with 1 percent delta",
			// String.valueOf(criteria.getProbability())));
		}
	}

	@Test
	public void testMatches2() {
		for (int index = (criterias.size() / 5); index < (2 * criterias.size() / 5); index++) {
			ProbabilityBasedPlayerSelectionCriteria criteria = criterias
					.get(index);
			double expectedOutcome = criteria.getProbability() * iterations;
			double actualOutcome = 0;
			for (int i = 0; i < iterations; i++) {
				if (criteria.matches(defaultPlayer)) {
					actualOutcome += 1;
				}
			}
			assertEquals(expectedOutcome, actualOutcome, 0.005 * iterations);
			// System.out.println(String.format(
			// "Probability %s passes assertion with 1 percent delta",
			// String.valueOf(criteria.getProbability())));
		}
	}

	@Test
	public void testMatches3() {
		for (int index = (2 * criterias.size() / 5); index < (3 * criterias
				.size() / 5); index++) {
			ProbabilityBasedPlayerSelectionCriteria criteria = criterias
					.get(index);
			double expectedOutcome = criteria.getProbability() * iterations;
			double actualOutcome = 0;
			for (int i = 0; i < iterations; i++) {
				if (criteria.matches(defaultPlayer)) {
					actualOutcome += 1;
				}
			}
			assertEquals(expectedOutcome, actualOutcome, 0.005 * iterations);
			// System.out.println(String.format(
			// "Probability %s passes assertion with 1 percent delta",
			// String.valueOf(criteria.getProbability())));
		}
	}

	@Test
	public void testMatches4() {
		for (int index = (3 * criterias.size() / 5); index < (4 * criterias
				.size() / 5); index++) {
			ProbabilityBasedPlayerSelectionCriteria criteria = criterias
					.get(index);
			double expectedOutcome = criteria.getProbability() * iterations;
			double actualOutcome = 0;
			for (int i = 0; i < iterations; i++) {
				if (criteria.matches(defaultPlayer)) {
					actualOutcome += 1;
				}
			}
			assertEquals(expectedOutcome, actualOutcome, 0.005 * iterations);
			// System.out.println(String.format(
			// "Probability %s passes assertion with 1 percent delta",
			// String.valueOf(criteria.getProbability())));
		}
	}

	@Test
	public void testMatches5() {
		for (int index = (4 * criterias.size() / 5); index < (5 * criterias
				.size() / 5); index++) {
			ProbabilityBasedPlayerSelectionCriteria criteria = criterias
					.get(index);
			double expectedOutcome = criteria.getProbability() * iterations;
			double actualOutcome = 0;
			for (int i = 0; i < iterations; i++) {
				if (criteria.matches(defaultPlayer)) {
					actualOutcome += 1;
				}
			}
			assertEquals(expectedOutcome, actualOutcome, 0.005 * iterations);
			// System.out.println(String.format(
			// "Probability %s passes assertion with 1 percent delta",
			// String.valueOf(criteria.getProbability())));
		}
	}

}
