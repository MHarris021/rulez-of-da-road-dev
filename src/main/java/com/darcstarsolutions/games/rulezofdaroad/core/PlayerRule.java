package com.darcstarsolutions.games.rulezofdaroad.core;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public class PlayerRule extends BasicRule<Player> implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private Long points;

	public PlayerRule() {
	}

	/**
	 * @return the points
	 */
	public long getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(long points) {
		this.points = points;
	}

	@Override
	public void applyTo(List<Player> players) {
		for (Player player : players) {
			Long score = player.getScore();
			score += points;
			player.setScore(score);
		}
	}

	@Override
	protected PlayerRule clone() throws CloneNotSupportedException {
		PlayerRule playerRule = new PlayerRule();
		playerRule.setName(getName());
		playerRule.setDescription(getDescription());
		playerRule.setPoints(getPoints());
		return playerRule;
	}

}
