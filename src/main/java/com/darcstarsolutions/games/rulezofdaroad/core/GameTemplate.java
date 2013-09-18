package com.darcstarsolutions.games.rulezofdaroad.core;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gameTemplatess")
public class GameTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id;

	@Indexed
	@NotNull
	private String description;

	private int uniquePlayers;

	@DBRef
	@Valid
	private List<PlayerTemplate> playerTemplates;

	@DBRef
	@Valid
	private List<Rule<Game>> rules;

	public static final int DEFAULT_UNIQUE_PLAYERS = 1;

	public GameTemplate() {
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the uniquePlayers
	 */
	public int getUniquePlayers() {
		return uniquePlayers;
	}

	/**
	 * @param uniquePlayers
	 *            the uniquePlayers to set
	 */
	public void setUniquePlayers(int uniquePlayers) {
		this.uniquePlayers = uniquePlayers;
	}

	/**
	 * @return the playerTemplates
	 */
	public List<PlayerTemplate> getPlayerTemplates() {
		return playerTemplates;
	}

	/**
	 * @param playerTemplates
	 *            the playerTemplates to set
	 */
	public void setPlayerTemplates(List<PlayerTemplate> playerTemplates) {
		this.playerTemplates = playerTemplates;
	}

	/**
	 * @return the rules
	 */
	public List<Rule<Game>> getRules() {
		return rules;
	}

	/**
	 * @param rules
	 *            the rules to set
	 */
	public void setRules(List<Rule<Game>> rules) {
		this.rules = rules;
	}

}
