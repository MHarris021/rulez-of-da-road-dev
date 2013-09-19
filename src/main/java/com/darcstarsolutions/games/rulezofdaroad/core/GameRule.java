package com.darcstarsolutions.games.rulezofdaroad.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class GameRule extends BasicRule<Game> implements Serializable,
		Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<? extends Rule<Player>> playerRules;

	public GameRule() {
	}

	@Override
	public void applyTo(List<Game> games) {
		for (Game game : games) {
			for (Rule<Player> rule : playerRules) {
				rule.applyTo(game.getPlayers());
			}
		}

	}

	public List<? extends Rule<Player>> getPlayerRules() {
		return playerRules;
	}

	public void setPlayerRules(List<? extends Rule<Player>> playerRules) {
		this.playerRules = playerRules;
	}

	@SuppressWarnings("unchecked")
	public void setPlayerRules(Rule<Player>... playerRules) {
		List<Rule<Player>> rules = Arrays.asList(playerRules);
		setPlayerRules(rules);
	}

}
