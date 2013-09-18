package com.darcstarsolutions.games.rulezofdaroad.core;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public abstract class BasicRule<T extends Serializable> implements Rule<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id;
	@NotBlank
	@Indexed(unique = true)
	private String name;
	@NotNull
	@Indexed
	private String description;

	public BasicRule() {
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

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void applyTo(@SuppressWarnings("unchecked") T... things) {
		List<T> ts = Arrays.asList(things);
		applyTo(ts);
	}

}