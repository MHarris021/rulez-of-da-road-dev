package com.darcstarsolutions.games.rulezofdaroad.core;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public class SetScorePlayerRule extends PlayerRule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void applyTo(List<Player> players) {
		for (Player player : players) {
			player.setScore(getPoints());
		}
	}

}
