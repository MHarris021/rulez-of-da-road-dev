package com.darcstarsolutions.games.rulezofdaroad.core;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PlayerTemplate implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id;
	
	private int number;
	
	@DBRef
	private List<Rule<Player>> rules;
	
	public PlayerTemplate() {
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
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the playerRules
	 */
	public List<Rule<Player>> getRules() {
		return rules;
	}

	/**
	 * @param playerRules the playerRules to set
	 */
	public void setRules(List<Rule<Player>> rules) {
		this.rules = rules;
	}
	
	
}
