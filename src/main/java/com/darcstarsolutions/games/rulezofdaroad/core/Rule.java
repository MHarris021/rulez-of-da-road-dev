package com.darcstarsolutions.games.rulezofdaroad.core;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rule {
	
	@Id
	private BigInteger id;
	private String name;
	private String description;
	private long points;


	public Rule() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

}
