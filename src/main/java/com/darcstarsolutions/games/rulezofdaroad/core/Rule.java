package com.darcstarsolutions.games.rulezofdaroad.core;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public interface Rule<T extends Serializable> extends Serializable {

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name);

	/**
	 * @return the description
	 */
	public String getDescription();

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description);

	@SuppressWarnings("unchecked")
	public void applyTo(T... things);
	
	public void applyTo(List<T> things);

}