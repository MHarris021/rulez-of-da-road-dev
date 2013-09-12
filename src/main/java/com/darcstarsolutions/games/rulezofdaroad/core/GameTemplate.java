package com.darcstarsolutions.games.rulezofdaroad.core;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GameTemplate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id;
	
	private int uniquePlayers;
	
	@DBRef
	private List<PlayerTemplate> playerTemplates;
	
	@DBRef
	private List<PlayerRule> defaultRules;

	
	public GameTemplate() {
	}
	
	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the uniquePlayers
	 */
	public int getUniquePlayers() {
		return uniquePlayers;
	}

	/**
	 * @param uniquePlayers the uniquePlayers to set
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
	 * @param playerTemplates the playerTemplates to set
	 */
	public void setPlayerTemplates(List<PlayerTemplate> playerTemplates) {
		this.playerTemplates = playerTemplates;
	}

	/**
	 * @return the defaultRules
	 */
	public List<PlayerRule> getDefaultRules() {
		return defaultRules;
	}

	/**
	 * @param defaultRules the defaultRules to set
	 */
	public void setDefaultRules(List<PlayerRule> defaultRules) {
		this.defaultRules = defaultRules;
	}
	
	
}
