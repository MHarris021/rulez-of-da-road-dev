package com.darcstarsolutions.games.rulezofdaroad.core;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "playerTemplates")
public class PlayerTemplate implements Serializable {

	public static final int DEFAULT_PLAYER_NUMBER = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id;

	private int number;

	@Indexed
	@NotNull
	private String description;

	@DBRef
	@NotEmpty
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
	 * @param id
	 *            the id to set
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
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
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
	 * @return the playerRules
	 */
	public List<Rule<Player>> getRules() {
		return rules;
	}

	/**
	 * @param playerRules
	 *            the playerRules to set
	 */
	public void setRules(List<Rule<Player>> rules) {
		this.rules = rules;
	}

}
