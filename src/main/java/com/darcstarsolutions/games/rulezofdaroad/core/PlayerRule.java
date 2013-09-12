package com.darcstarsolutions.games.rulezofdaroad.core;

import java.io.Serializable;
import java.math.BigInteger;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public class PlayerRule implements Serializable, Rule<Player>, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id;

	@NotBlank
	private String name;

	@NotNull
	private String description;

	@NotNull
	private Long points;

	public PlayerRule() {
	}
	
	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.darcstarsolutions.games.rulezofdaroad.core.Rule#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.darcstarsolutions.games.rulezofdaroad.core.Rule#setName(java.lang
	 * .String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.darcstarsolutions.games.rulezofdaroad.core.Rule#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.darcstarsolutions.games.rulezofdaroad.core.Rule#setDescription(java
	 * .lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
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
	public void applyTo(Player... players) {
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
