package com.darcstarsolutions.common.core.builders;

import java.io.Serializable;

public abstract class Builder<Entity extends Serializable> {

	private Entity entity;

	
	/**
	 * @return the entity
	 */
	@SuppressWarnings("unchecked")
	protected <T extends Entity> T getEntity() {
		return (T) entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	protected <T extends Entity>void setEntity(T entity) {
		this.entity = entity;
	}

	@SuppressWarnings("unchecked")
	public <T extends Entity> T build() {
		return (T)entity;
	}

}