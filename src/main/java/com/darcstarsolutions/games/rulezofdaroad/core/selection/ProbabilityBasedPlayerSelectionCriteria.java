package com.darcstarsolutions.games.rulezofdaroad.core.selection;

import java.util.Random;

import javax.validation.constraints.Max;

import com.darcstarsolutions.games.rulezofdaroad.core.Player;

public class ProbabilityBasedPlayerSelectionCriteria implements
		PlayerSelectionCriteria<Player> {

	private Random random;

	@Max(value = 1)
	private double probability;

	public ProbabilityBasedPlayerSelectionCriteria(
			@Max(value = 1) double probability) {
		this(probability, new Random());
	}

	public ProbabilityBasedPlayerSelectionCriteria(
			@Max(value = 1) double probability, Random random) {
		this.random = random;
		setProbability(probability);
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	@Override
	public boolean matches(Player item) {
		double outcome = random.nextDouble();
		boolean result = false;
		if (outcome <= getProbability()) {
			result = true;
		}
		return result;
	}

}
